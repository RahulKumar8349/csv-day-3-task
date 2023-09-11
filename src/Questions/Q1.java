package Questions;

import Assignment.Address;
import Assignment.Student;

import java.util.List;
import java.util.stream.Collectors;

public class Q1 {
    public static   List<Student> findByPincode(List<Student> students, List<Address> address, int pincode)
    {
        List<Integer> addid= address.stream().filter(a->a.getPin_code()==pincode).map(Address::getId).collect(Collectors.toList());
        List<Student> foundStudents = students.stream()
                .filter(student -> addid.contains(student.getId()))
                .collect(Collectors.toList());
        return foundStudents;
    }
}
