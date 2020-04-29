package aem.training.core.servlets;

import com.day.cq.tagging.Tag;
import com.day.cq.tagging.TagManager;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.json.JSONArray;
import org.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

@Component(name = "Article Servlet", service = Servlet.class, property = {
        Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=" + "/bin/articleservlet",

})
public class ArticleServlet extends SlingSafeMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        try {
            String path = request.getParameter("path");
            if (path != null) {
                ResourceResolver resourceResolver = request.getResourceResolver();
                Resource resource = resourceResolver.getResource(path);
                TagManager tagManager = resourceResolver.adaptTo(TagManager.class);
                if (resource != null) {
                    Page page = resource.adaptTo(Page.class);
                    if (page != null) {
                        Iterator<Page> iterator = page.listChildren();
                        JSONArray jsonArray = new JSONArray();

                        while (iterator.hasNext()) {
                            Page childPage = iterator.next();
                            Resource contentResource = childPage.getContentResource();
                            ValueMap valueMap = contentResource.getValueMap();
                            String articleName = valueMap.get("articleName", String.class);
                            String articleDescription = valueMap.get("articleDescription", String.class);
                            Date articledate = valueMap.get("articledate", Date.class);

                            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
                            String date = sdf.format(new Date());

                            String authorname = valueMap.get("authorname", String.class);

                            String[] articleCategory = valueMap.get("tag", String[].class);
                            JSONArray newJsonArray = new JSONArray();
                            if (articleCategory != null) {
                                for (String category : articleCategory) {
                                    Tag tag = tagManager.resolve(category);
                                    String name = tag.getName();
                                    String title = tag.getTitle();
                                    String id = tag.getTagID();

                                    JSONObject newJsonObject = new JSONObject();
                                    newJsonObject.put("name", name);
                                    newJsonObject.put("title", title);
                                    newJsonObject.put("id", id);
                                    newJsonArray.put(newJsonObject);
                                }
                            }
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("name", articleName);
                            jsonObject.put("description", articleDescription);
                            jsonObject.put("date", date);
                            jsonObject.put("author", authorname);

                            jsonObject.put("tag", newJsonArray);

                            jsonArray.put(jsonObject);

                        }

                        response.getWriter().println(jsonArray.toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
