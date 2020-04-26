package project;

public class LaZone {
    public static void main(String[] args) {
        try {
            DataBase db = new DataBase();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}