package test.camel.project2.routes;

import org.apache.camel.builder.RouteBuilder;
import test.camel.project2.beans.TransformerBean;
import test.camel.project2.filters.XpathFilter;

/*
* With the help of xPath parse the document and process some logic according to system tag value
* */

public class TestRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file://resources/project2/inbox").startupOrder(1)
                .choice()
                    .when().method(new XpathFilter(), "processItem")
                    .when().method(new XpathFilter(), "mimiSystem")
                .otherwise()
//                .choice()
//                    .when()
//                    .xpath("//system/text() = 'ololo'").log("log: this is ololo")
//                    .to("direct:another")
//                .end()
                .bean(TransformerBean.class, "transform")
                .bean(TransformerBean.class, "process")
                .to("file://resources/project2/outbox");
    }
}
