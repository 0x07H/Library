package gr.upatras.Library;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {
    List<Customer> findByLastName(String lastName);
	Student findById(int id);
}