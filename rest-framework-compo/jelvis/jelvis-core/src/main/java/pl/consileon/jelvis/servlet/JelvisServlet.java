package pl.consileon.jelvis.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.consileon.jelvis.bind.annotation.GET;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class JelvisServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(JelvisServlet.class);

    /**
     * Currently processed request
     */
    private HttpServletRequest currentRequest;

    /**
     * Currently processed response.
     */
    private HttpServletResponse currentResponse;

    private Method method;

    public void init() {
        logger.debug("Initializing the servlet");

        for (Method method : getClass().getMethods()) {
            if (method.isAnnotationPresent(GET.class)) {
                this.method = method;
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        currentRequest = request;
        currentResponse = response;

        logger.info("Received GET {}", getRequestUri());

        try {
            // default content type
            setContentType("text/plain");
            setCharacterEncoding("utf-8");

            Object result = method.invoke(this);

            PrintWriter writer = response.getWriter();
            writer.println(result.toString());
            writer.close();
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    protected String getRequestUri() {
        return currentRequest.getRequestURI();
    }

    protected void setContentType(String contentType) {
        currentResponse.setContentType(contentType);
    }

    protected void setCharacterEncoding(String encoding) {
        currentResponse.setCharacterEncoding(encoding);
    }
}
