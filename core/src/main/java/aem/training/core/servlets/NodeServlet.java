package aem.training.core.servlets;

import aem.training.core.services.GenericService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Node;
import javax.jcr.Session;
import javax.servlet.Servlet;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;

@Component(service = Servlet.class, property = {
        Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=" + "/bin/node",

})
public class NodeServlet extends SlingSafeMethodsServlet {
    @Reference (target="(type=Shivani)")
    GenericService genericService;
    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        try {
          //  String path = request.getParameter("path");
            ResourceResolver resourceResolver = request.getResourceResolver();
//            Resource resource = resourceResolver.getResource(path);
//            Node node = resource.adaptTo(Node.class);
//             node.setProperty("name", "Shivani");
//             node.setProperty("value", "Anchal");
//
//            Session session = node.getSession();
//            session.save();
            response.getWriter().println(genericService.getName());
        }
        catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Failure");
        }

    }
}
