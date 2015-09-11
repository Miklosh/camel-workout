package test.camel.project2;

import org.apache.camel.CamelContext;
import test.camel.project2.routes.ReturnRoute;
import test.camel.project2.routes.TestRoute;
import test.camel.util.CamelContextConfig;

public class LauncherP2 {

    public static void main(String[] args) {
        CamelContext cc = CamelContextConfig.getCameContext();
        try {
            cc.addRoutes(new TestRoute());
            cc.addRoutes(new ReturnRoute());
            cc.start();
            Thread.sleep(5000);
            cc.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
