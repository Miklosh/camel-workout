package test.camel.routes;

import org.apache.camel.builder.RouteBuilder;

public class FileRB extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:./resources/inbox?delete=true")
                .to("file:./resources/outbox");
    }
}
