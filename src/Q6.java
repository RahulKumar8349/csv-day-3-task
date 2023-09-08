import java.util.List;
import java.util.stream.Collectors;

public class Q6 {
    public static   List<Student> findByClass(java.util.List<Student> students, java.util.List<Class> clas,String clasname)
    {
        List<Integer> addid= clas.stream().filter(a->a.getName().equals(clasname)).map(Class::getId).collect(Collectors.toList());
        List<Student> foundStudents = students.stream()
                .filter(student -> addid.contains(student.getClass_id()))
                .collect(Collectors.toList());
        return foundStudents;
    }
}
