package fi.academy;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);
    List<User> findByEmailStartsWith(String email);
    Integer countDistinctByEmailEndingWith(String email);
}
