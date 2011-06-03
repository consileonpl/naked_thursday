package pl.consileon.jelvis.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class JelvisServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(JelvisServlet.class);

    /** Currently processed request */
    private HttpServletRequest currentRequest;

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        currentRequest = request;

        logger.info("Received GET {}", getRequestUri());
    }

    public String getRequestUri() {
        return currentRequest.getRequestURI();
    }

}
