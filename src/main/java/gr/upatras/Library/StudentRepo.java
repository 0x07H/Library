package gr.upatras.Library;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {
    List<Student> findByLastName(String lastName);
	Student findById(int id);
}