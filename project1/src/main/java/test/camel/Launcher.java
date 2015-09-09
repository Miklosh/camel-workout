package test.camel;

import org.apache.camel.CamelContext;
import test.camel.routes.FileRB;
import test.camel.util.CamelContextConfig;

public class Launcher {

    public static void main(String[] args) {
        try {
            CamelContext cc = CamelContextConfig.getCameContext();
            cc.addRoutes(new FileRB());
            cc.start();
            Thread.sleep(5000);
            cc.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
