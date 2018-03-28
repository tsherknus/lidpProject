package demo;

public class Greeting {

    private final String content;
    private final String context;

    public Greeting(String content, String context) {
        this.content = content;
        this.context = context;
    }
    public String getContext() {
        return context;
    }
    public String getContent() {
        return content;
    }
}