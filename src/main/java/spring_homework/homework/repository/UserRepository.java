package spring_homework.homework.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import spring_homework.homework.model.User;

import java.util.Optional;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findById (String id);

    boolean existsById (String id);

    void deleteById (String id);

}
