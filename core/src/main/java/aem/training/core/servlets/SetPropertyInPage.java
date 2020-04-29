package aem.training.core.servlets;

import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.jcr.Node;
import java.io.IOException;

@Component(service = Servlet.class, property = {
        Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=" + "/bin/setproperty",
})
public class SetPropertyInPage extends SlingSafeMethodsServlet {
    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        try {
            String path = request.getParameter("path");
            ResourceResolver resourceResolver = request.getResourceResolver();
            Resource resource = resourceResolver.getResource(path);
            if (resource.isResourceType("cq:Page")) {

                Resource childResource = resource.getChild("jcr:content");

                Node node = childResource.adaptTo(Node.class);
                node.setProperty("name", "Anchal");
                Session session = node.getSession();
                session.save();
                response.getWriter().println("Success");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Failure");
        }
    }
}
