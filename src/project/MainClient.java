package project;

public class MainClient {
    public static void main(String[] args) {
        new Client("localhost");
        Secure secure = new Secure();
    }
}