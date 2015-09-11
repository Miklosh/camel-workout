package test.camel.project2.routes;

import org.apache.camel.builder.RouteBuilder;

public class ReturnRoute extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("file://resources/project2/outbox").startupOrder(3)
                .to("file://resources/project2/inbox");
    }
}
