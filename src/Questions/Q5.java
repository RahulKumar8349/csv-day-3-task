package Questions;

import Assignment.Student;

import java.util.List;
import java.util.stream.Collectors;

public class Q5 {
    public static   List<Student> findFailed(List<Student> students)
    {
        List<Student> foundStudents = students.stream()
                .filter(student -> student.getMarks()<=50)
                .collect(Collectors.toList());
        return foundStudents;
    }
}
