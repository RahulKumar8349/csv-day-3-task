import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q11 {
    public static List<Student> getFirstFemaleListInRange(List<Student> students, int start, int end) {
        return getFemaleStudentsList(students).stream()
                .skip(start - 1)
                .limit(end - start + 1)
                .collect(Collectors.toList());
    }

    private static List<Student> getFemaleOrderByName(List<Student> student, int start, int end) {
        return getFemaleStudentsList(student).stream()
                .sorted(Comparator.comparing(Student::getName))
                .skip(start - 1)
                .limit(end - start + 1)
                .collect(Collectors.toList());
    }

    private static List<Student> getFemaleOrderByMarks(List<Student> student, int start, int end) {
        return getFemaleStudentsList(student).stream()
                .sorted(Comparator.comparingInt(Student::getMarks).reversed())
                .skip(start - 1)
                .limit(end - start + 1)
                .collect(Collectors.toList());
    }

    static List<Student>	getFemaleStudentsList(List<Student> student)
    {
        List<Student> femaleStudents = student.stream()
                .filter(students -> students.getGender().equals("F"))
                .collect(Collectors.toList());
        return femaleStudents;
    }

}