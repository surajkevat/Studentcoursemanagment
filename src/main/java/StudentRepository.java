import java.util.Optional;

public interface StudentRepository {
    Optional<Student> findById(Long id);
    Student save(Student student);
}