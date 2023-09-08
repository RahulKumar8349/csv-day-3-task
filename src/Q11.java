import java.util.List;
import java.util.stream.Collectors;

public class Q11 {
    public static   List<Student> findFailed(List<Student> students)
    {
        List<Student> foundStudents = students.stream()
                .filter(student -> student.getMarks()<=50)
                .collect(Collectors.toList());
        return foundStudents;
    }
}