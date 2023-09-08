import java.util.*;
import java.util.stream.Collectors;

public class Q3 {
    public static Map<String,List<Student>> findAchievers(List<Student> students)
    {
        Map<String,List<Student>> hp=new HashMap<>();

         List<Student> first=new ArrayList<>();
                first.add(students.stream()
                        .max(Comparator.comparingInt(Student::getMarks))
                        .orElse(null));

        List<Student> second=new ArrayList<>();

        second.add(students.stream()
                .sorted(Comparator.comparingInt(Student::getMarks).reversed())
                .skip(1) // Skip the first highest mark student
                .findFirst()
                .orElse(null));

        List<Student> third=new ArrayList<>();

                third.add(students.stream()
                        .sorted(Comparator.comparingInt(Student::getMarks).reversed())
                        .skip(2)
                        .findFirst()
                        .orElse(null));

        List<Student> pass= students.stream()
                            .filter(student -> student.getMarks()>50)
                            .collect(Collectors.toList());

        List<Student> fail=students.stream()
                            .filter(student -> student.getMarks()>50)
                            .collect(Collectors.toList());

        hp.put("first",first);
        hp.put("second",second);
        hp.put("third",third);
        hp.put("pass",pass);
        hp.put("fail",fail);
        return hp;
    }
}