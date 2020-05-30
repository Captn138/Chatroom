import java.io.*;
import java.util.*;

class Test{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ID of the employee");
        String id = sc.nextLine();
        System.out.println("Enter the first name of the employee");
        String fn = sc.nextLine();
        System.out.println("Enter the last name of the employee");
        String ln = sc.nextLine();
        System.out.println("Enter the salary of the employee");
        String sl = sc.nextLine();
        System.out.println("Enter the location of the employee");
        String lo = sc.nextLine();

        try{
            File f = new File("Database.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(f, true));
            pw.append("\n"+id+","+fn+","+ln+","+sl+","+lo);
            pw.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}