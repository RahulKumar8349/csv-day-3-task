import java.util.List;
import java.util.stream.Collectors;

public class Q2 {
    public static   List<Student> findByCity(List<Student> students, List<Address> address, String city)
    {
        List<Integer> addid= address.stream().filter(a->a.getCity().equals(city)).map(Address::getId).collect(Collectors.toList());
        List<Student> foundStudents = students.stream()
                .filter(student -> addid.contains(student.getId()))
                .collect(Collectors.toList());
        return foundStudents;
    }
}
