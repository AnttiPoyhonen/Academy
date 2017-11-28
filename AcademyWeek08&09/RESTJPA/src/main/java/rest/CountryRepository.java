package rest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

// import the @Entity to form a repository of
import rest.Country;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called countryRepository
// CRUD refers Create, Read, Update, Delete
// Extends CrudRepository (also could be subclasses JpaRepository, PagingAndSortingRepository)

public interface CountryRepository extends PagingAndSortingRepository<Country, String> {

    Country findCountryByCode(String code);
    List<Country> findCountriesByCodeContainingOrNameContainingOrderByName(String s, String s2);

    @Query("SELECT c FROM Country c where c.population IS NOT EMPTY ORDER BY c.population DESC")
    Page<Country> findCountriesWithMaxPopulations(Pageable pageable);
}
