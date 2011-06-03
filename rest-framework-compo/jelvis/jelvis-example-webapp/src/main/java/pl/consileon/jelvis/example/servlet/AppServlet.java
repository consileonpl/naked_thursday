package pl.consileon.jelvis.example.servlet;

import pl.consileon.jelvis.bind.annotation.GET;
import pl.consileon.jelvis.servlet.JelvisServlet;

public class AppServlet extends JelvisServlet {
    public class Greet {
        public String greet = "Ahoj!";

        @Override
        public String toString() {
            return "Greet{" +
                    "greet='" + greet + '\'' +
                    '}';
        }
    }

    @GET
    public Greet greetJson() {
        return new Greet();
    }

}
