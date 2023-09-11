import java.util.List;
import java.util.stream.Collectors;

public class Q10 {
    public static List<Class> deleteClass(List<Student> students, List<Class> classes) {
        List<Integer> newIdList =   students.stream().map(Student::getClass_id).
                collect(Collectors.toList());
        List<Class> newClassList = classes.stream().filter(classe ->newIdList
                .contains(classe.getId())).collect(Collectors.toList());
        return newClassList;
    }
}