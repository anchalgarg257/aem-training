package aem.training.core.servlets;

import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.Iterator;

@Component(name = "Product Listing Servlet", service = Servlet.class, property = {
        Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=" + "/bin/productservlet",

})
public class ProductListingServlet extends SlingSafeMethodsServlet {
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        try {

            String path = request.getParameter("path");
            ResourceResolver resourceResolver = request.getResourceResolver();
            Resource resource = resourceResolver.getResource(path);
            Page page = resource.adaptTo(Page.class);
            Iterator<Page> iterator = page.listChildren();
            JSONArray jsonArray = new JSONArray();
            while (iterator.hasNext()) {
                Page childpage = iterator.next();
                Resource contentResource = childpage.getContentResource();

                JSONArray childJsonArray = new JSONArray();
                Resource childResource = contentResource.getChild("productFeatures");
                Iterator<Resource> pageIterator = childResource.listChildren();
                while (pageIterator.hasNext()) {
                    Resource childrenResource = pageIterator.next();

                    ValueMap featureValueMap = childrenResource.getValueMap();
                    String image = featureValueMap.get("image", String.class);
                    String title = featureValueMap.get("title", String.class);

                    JSONObject childJsonObject = new JSONObject();
                    childJsonObject.put("path", image);
                    childJsonObject.put("name", title);
                    childJsonArray.put(childJsonObject);

                }

                ValueMap valueMap = contentResource.getValueMap();
                String productName = valueMap.get("productName", String.class);
                String productDescription = valueMap.get("productDescription", String.class);
                String productImage = valueMap.get("productImage", String.class);
                String productPath = page.getPath();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("title", productName);
                jsonObject.put("description", productDescription);
                jsonObject.put("image", productImage);
                jsonObject.put("path", productPath);
                jsonObject.put("features", childJsonArray);
                jsonArray.put(jsonObject);
            }

            response.getWriter().println(jsonArray.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
