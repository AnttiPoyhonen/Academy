package rest;

import org.springframework.data.repository.CrudRepository;

// import the @Entity to form a repository of
import org.springframework.transaction.annotation.Transactional;
import rest.User;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
// Extends CrudRepository (also could be subclasses JpaRepository, PagingAndSortingRepository)

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findUsersByNameContainingOrEmailContainingOrderById(String s, String st);
    User findUserById(int id);

    // DOESNT WORK! NEEDS TO BE CONTROLLED THROUGH TRANSACTION AND .remove()
    // int deleteUserById(int id);

    // Edit, works as @Transactional!
    @Transactional
    Long deleteById(int id);

}
