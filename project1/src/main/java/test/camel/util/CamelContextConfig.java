package test.camel.util;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Created by myko0715 on 9/9/2015.
 */
public enum CamelContextConfig { ;

    private static CamelContext cc = new DefaultCamelContext();

    public static CamelContext getCameContext() {
        return cc;
    }

}
