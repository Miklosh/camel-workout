package test.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import test.camel.routes.FileRB;

public class Launcher {

    public static void main(String[] args) {
        CamelContext cc = new DefaultCamelContext();
        try {
            cc.addRoutes(new FileRB());
            cc.start();
            Thread.sleep(5000);
            cc.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
