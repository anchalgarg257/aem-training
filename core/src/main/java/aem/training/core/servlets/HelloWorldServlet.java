package aem.training.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;

@Component(name = "Hello Wold Servlet", service = Servlet.class, property = {
        Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=" + "/bin/helloworld",
        "sling.servlet.resourceTypes=" + "aemtutorials/components/content/component",
        "sling.servlet.extensions=" + "sample",
        "sling.servlet.selectors=" + "country",
        "sling.servlet.selectors=" + "state",
})
public class HelloWorldServlet extends SlingSafeMethodsServlet {

    private final Logger logger = LoggerFactory.getLogger(HelloWorldServlet.class);

    @Override
    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {

        if (request.getRequestPathInfo().getSelectors()[0].equals("country")) {
            logger.info("I am inside if condition when selector is country");
            response.getWriter().println("Hello World");

        } else if (request.getRequestPathInfo().getSelectors()[0].equals("state")) {
            logger.info("I am inside if condition when selector is state");
            response.getWriter().println("hiii");
        } else {
            response.getWriter().println("Hello");
        }
    }
}
