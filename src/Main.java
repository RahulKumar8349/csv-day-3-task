import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)
        {
            String studentFilePath="C:\\Users\\Rahul\\IdeaProjects\\csv basic operation\\src\\student.csv";
            String addressFilePath="C:\\Users\\Rahul\\IdeaProjects\\csv basic operation\\src\\address.csv";
            String classFilePath="C:\\Users\\Rahul\\IdeaProjects\\csv basic operation\\src\\class.csv";

            List<Student> student = uploadStudent(studentFilePath);
            List<Address> address = uploadAddress(addressFilePath);
            List<Class> classes= uploadClass(classFilePath);

            System.out.println(student);
            System.out.println(address);
            System.out.println(classes);

            System.out.println("\n\n");

            System.out.println(Q1.findByPincode(student,address,422002)+"\n\n");
            System.out.println(Q2.findByCity(student,address,"indore")+"\n\n");
            System.out.println(Q3.findAchievers(student)+"\n\n");
            System.out.println(Q4.findPassed(student)+"\n\n");
            System.out.println(Q5.findFailed(student)+"\n\n");
            System.out.println(Q6.findByClass(student,classes,"A")+"\n\n");
            System.out.println(Q8.findOverAged(student)+"\n\n");
            System.out.println(Q8.findOverAged(student)+"\n\n");
            Q9.delete(student,address,studentFilePath,addressFilePath,2);
            //2,geeta,1,70,F,11
            //3,412002,indore,2

        }

    public static List<Student> uploadStudent(String filePath){
        List<Student> student= new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // Skip the header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Read and process the rest of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the line here (e.g., split it into fields)
                String[] fields = line.split(",");
                Student s1=new Student(Integer.parseInt(fields[0]),fields[1],Integer.parseInt(fields[2]),Integer.parseInt(fields[3]),fields[4],Integer.parseInt(fields[5]));
                student.add(s1);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    static List<Address> uploadAddress(String filePath){
        List<Address> address= new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // Skip the header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Read and process the rest of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the line here (e.g., split it into fields)
                String[] fields = line.split(",");
                Address a1=new Address(Integer.parseInt(fields[0]),Integer.parseInt(fields[1]),fields[2],Integer.parseInt(fields[3]));
                address.add(a1);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }

    static List<Class> uploadClass(String filePath){
        List<Class> classes= new ArrayList<>();
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // Skip the header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            // Read and process the rest of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Process the line here (e.g., split it into fields)
                String[] fields = line.split(",");
                Class s1=new Class(Integer.parseInt(fields[0]),fields[1]);
                classes.add(s1);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classes;
    }

}