package aem.training.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
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
        "sling.servlet.paths=" + "/bin/addnode",

})
public class NewNodeServlet extends SlingSafeMethodsServlet {
    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        try {
            String path = request.getParameter("path");
            ResourceResolver resourceResolver = request.getResourceResolver();
            Resource resource = resourceResolver.getResource(path);
            Node node = resource.adaptTo(Node.class);
            if (!node.hasNode("Anchal")) {
                Node newnode = node.addNode("Anchal", "nt:unstructured");
                Session session = node.getSession();
                // session.save();
                newnode.setProperty("name", "abc");
                newnode.setProperty("value", "cde");
                session.save();
                response.getWriter().println("Success");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Failure");
        }
    }

}
