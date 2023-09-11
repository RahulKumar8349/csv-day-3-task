package Questions;

import Assignment.Class;
import Assignment.Student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Q10 {
    public static List<Class> deleteClass(List<Student> students, List<Class> classes,String classFilePath) {


        List<String> lines = Q9.readCsvFile(classFilePath);
        System.out.println(lines);

        List<Integer> newIdList =   students.stream().map(Student::getClass_id).
                collect(Collectors.toList());
        List<Class> newClassList = classes.stream().filter(classe ->newIdList
                .contains(classe.getId())).collect(Collectors.toList());


        List<String> str=new ArrayList<>();
        String temp="id,name";
        str.add(temp);


       newClassList.forEach(abc->
       {
           String data=abc.getId()+","+abc.getName();
           str.add(data);
       });

//        // Write the remaining lines back to the CSV file
        Q9.writeCsvFile(str, classFilePath);

        return newClassList;
    }
}