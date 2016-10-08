package xml.ws.client;

public class HelloClient {
    public static void main(String[] args) {
        Hello hello = new HelloService().getHelloPort();
        String text = hello.sayHello("Henry");
        System.out.println(text);
    }
}
