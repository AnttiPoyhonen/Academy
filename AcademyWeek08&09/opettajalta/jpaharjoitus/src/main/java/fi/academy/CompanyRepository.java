package fi.academy;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Integer> {
    List<User> findByName(String name);

    //<editor-fold desc="Jotain tulevaisuutta varten">
    @Query("SELECT c FROM Company c JOIN c.users u WHERE u.name = :name")
    List<Company> etsiYritysKayttajanNimella(@Param("name") String name);
    //</editor-fold>
}
