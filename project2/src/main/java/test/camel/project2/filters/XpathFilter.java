package test.camel.project2.filters;

import org.apache.camel.language.XPath;

public class XpathFilter {

    public boolean processItem(@XPath("//system/text()") String item) {
        boolean condition = item != null && "ololo".equals(item);
        if (condition) System.out.println(item);
        return condition;
    }

    public boolean mimiSystem(@XPath("//system/text()") String item) {
        boolean condition = item != null && "mimi".equals(item);
        if (condition) System.out.println(item);
        return condition;
    }

}
