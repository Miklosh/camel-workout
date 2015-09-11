package test.camel.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class FileRB extends RouteBuilder {

    Logger logger = LoggerFactory.getLogger(FileRB.class);

    @Override
    public void configure() throws Exception {
        from("file://resources/project1/inbox?delete=true")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        Map<String, Object> map = exchange.getIn().getHeaders();
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            System.out.println("[KEY]: " + entry.getKey() + " [VALUE]: " + entry.getValue());
                        }
                        //TODO investigate why does this call breaks route execution
//                        System.out.println("[OUT BODY]: " + exchange.getOut().getBody());
                        Map<String, Object> propMap = exchange.getProperties();
                        for (Map.Entry<String,Object> s : propMap.entrySet()) {
                            System.out.println("[PKEY]: " + s.getKey() + "  [PVALUE]: " + s.getValue());
                        }
                        System.out.println("[FROM ENDPOINT]: "+exchange.getFromEndpoint());
                        System.out.println("We've just processed file: " + exchange.getIn().getHeader("CamelFileName"));
                        exchange.getIn().setHeader("CamelFileName", "mikola.xml");
                        System.out.println("We've just processed file: " + exchange.getIn().getHeader("CamelFileName"));
                        System.out.println("[BODY]: " + exchange.getIn().getBody().toString());
                    }
                })
                .convertBodyTo(String.class)
                .to("direct:test1")
                .to("direct:test2");

        from("direct:test1").process(new Processor() {
            public void process(Exchange exchange) throws Exception {
                System.out.println("[TEST1]: " + exchange.getIn().getBody());
            }
        });

        from("direct:test2")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        String body = (String) exchange.getIn().getBody();
                        System.out.println("[TEST2]: " + body);
                        String[] arr = body.split(" ");
                        StringBuilder sb = new StringBuilder();
                        for (String s : arr) {
                            if ("test".equals(s)) {
                                s = "ololo";
                            }
                            sb.append(s + " ");
                        }
                        exchange.getIn().setBody(sb.toString().trim());
                        System.out.println("[NEW BODY]: " + exchange.getIn().getBody());
                    }
                })
                .to("file://resources/project1/outbox");
    }
}
