package aem.training.core.servlets;

import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import java.io.IOException;
import java.util.Iterator;


@Component(service = Servlet.class, property = {
        Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=" + "/bin/name",

})
public class NameServelet extends SlingSafeMethodsServlet {
    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        try {
            String path = request.getParameter("path");
            ResourceResolver resourceResolver = request.getResourceResolver();
            Resource resource = resourceResolver.getResource(path);
            Page page = resource.adaptTo(Page.class);
            Iterator<Page> iterator = page.listChildren();
            JSONArray pageObject = new JSONArray();
            while (iterator.hasNext()) {
                Page childPage = iterator.next();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("title", childPage.getTitle());
                jsonObject.put("path", childPage.getPath());
                pageObject.put(jsonObject);
            }
            response.getWriter().println(pageObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
