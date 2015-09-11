package test.camel.project2.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class XpathRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:another")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("it was ololo system");
                    }
                });
    }
}
