package pl.consileon.jelvis.example.servlet;

import pl.consileon.jelvis.bind.annotation.GET;
import pl.consileon.jelvis.servlet.JelvisServlet;

public class AppServlet extends JelvisServlet {

    @GET
    public String greet() {
        return "Hello there!";
    }

}
