package spring_homework.homework.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import spring_homework.homework.model.User;

@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
