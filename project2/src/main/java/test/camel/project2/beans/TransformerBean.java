package test.camel.project2.beans;

public class TransformerBean {

    public String transform(String input) {
        String output = input;
        System.out.println("Project2 transform method");
        System.out.println(input);
        return output;
    }

    public String process(String input) {
        String output = input;
        System.out.println("Project2 process method");
        return output;
    }

}
