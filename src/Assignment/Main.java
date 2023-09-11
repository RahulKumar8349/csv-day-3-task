package Assignment;

import java.io.File;
import Questions.*;
import Questions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args)
        {
            String studentFilePath="C:\\Users\\Rahul\\IdeaProjects\\csv basic operation\\src\\Assignment\\student.csv";
            String addressFilePath="C:\\Users\\Rahul\\IdeaProjects\\csv basic operation\\src\\Assignment\\address.csv";
            String classFilePath="C:\\Users\\Rahul\\IdeaProjects\\csv basic operation\\src\\Assignment\\class.csv";

            List<Student> student = uploadStudent(studentFilePath);
            List<Address> address = uploadAddress(addressFilePath);
            List<Class> classes= uploadClass(classFilePath);

            System.out.println("Assignment.Student data in csv\n");
            System.out.println(student+"\n\n");

            System.out.println("address data in csv\n");
            System.out.println(address+"\n\n");

            System.out.println("class data in csv\n");
            System.out.println(classes+"\n\n");

            System.out.println("\n\n");

            System.out.println("Questions.Q1 - Find all students of pincode X(ex X = 482002). I can pass different filters like gender, age, class\n");
            System.out.println(Q1.findByPincode(student,address,422002)+"\n\n");

            System.out.println("Questions.Q2 - Find all students of city ex X = Indore. I can pass different filters like gender, age, class\n\n");
            System.out.println(Q2.findByCity(student,address,"indore")+"\n\n");

            System.out.println("Questions.Q3 - marks < 50 failed else passed\n" +
                    "Give ranks to highest mark achievers.\n" +
                    "Highest marks - First\n" +
                    "Third Highest marks - third\n" +
                    "Rest of all pass / fail\n");
            System.out.println(Q3.findAchievers(student)+"\n\n");

            System.out.println("Questions.Q4 - Get the passed students. I can pass different filters like gender, age, class, city, pincode\n");
            System.out.println(Q4.findPassed(student)+"\n\n");

            System.out.println("Questions.Q5 - Get the failed students. I can pass different filters like gender, age, class, city, pincode\n");
            System.out.println(Q5.findFailed(student)+"\n\n");

            System.out.println("Questions.Q6 - Find all student of class X (ex X = A). I can pass different filters like gender, age, class, city, pincode\n");
            System.out.println(Q6.findByClass(student,classes,"A")+"\n\n");

            System.out.println("Questions.Q8 -  It should fail if student record is having age > 20\n");
            System.out.println(Q8.findOverAged(student)+"\n\n");


            System.out.println("Questions.Q9 - I should be able to delete student. After that it should delete the respective obj from Assignment.Address & Assignment.Student\n");
            Q9.delete(studentFilePath,addressFilePath,2);

            System.out.println("Questions.Q10 - If there is no student remaining in that class. Assignment.Class should also be deleted\n");
            System.out.println(Q10.deleteClass(student,classes,classFilePath)+"\n\n");

            System.out.println("Questions.Q11 - like : read female students first 1-9\n");
            System.out.println(Q11.getFirstFemaleListInRange(student,1,9)+"\n\n");

            System.out.println("Questions.Q11 - like : read female students first 7-8 order by name\n");
            System.out.println(Q11.getFemaleOrderByName(student,7,8)+"\n\n");

            System.out.println("Questions.Q11 - like : read female students first 1-5 order by marks\n");
            System.out.println(Q11.getFemaleOrderByMarks(student,1,5)+"\n\n");
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