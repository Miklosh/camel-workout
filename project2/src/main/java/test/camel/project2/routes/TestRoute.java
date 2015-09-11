package test.camel.project2.routes;

import org.apache.camel.builder.RouteBuilder;
import test.camel.project2.beans.TransformerBean;

public class TestRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file://resources/project2/inbox")
                .bean(TransformerBean.class, "transform")
                .bean(TransformerBean.class, "process")
                .to("file://resources/project2/outbox");
    }
}
