import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q10 {
    public static List<Class> deleteClass(List<Student> students, List<Class> classes,String classFilePath) {


        //List<String> lines = Q9.readCsvFile(classFilePath);


        List<Integer> newIdList =   students.stream().map(Student::getClass_id).
                collect(Collectors.toList());
        List<Class> newClassList = classes.stream().filter(classe ->newIdList
                .contains(classe.getId())).collect(Collectors.toList());



//        List<String> str=new ArrayList<>();
//       newClassList.forEach(abc->
//       {
//           str.add(new String(abc.getId()+","+abc.getName()));
//       });
//
//
//        // Write the remaining lines back to the CSV file
//        Q9.writeCsvFile(str, classFilePath);

        return newClassList;
    }
}