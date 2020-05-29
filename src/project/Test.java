package project;

public class Test {
    public static void main(String[] args) {
        //new Client("localhost");
        Secure secure = new Secure();
        System.out.println("password : " + secure.hash("password"));
    }
}