import java.util.List;
import java.util.stream.Collectors;

public class Q8 {
    public static   List<Student> findOverAged(List<Student> students)
    {
        return students.stream().filter(a->a.getAge()>20).collect(Collectors.toList());
    }
}
