package rest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

// import the @Entity to form a repository of
import rest.City;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called countryRepository
// CRUD refers Create, Read, Update, Delete
// Extends CrudRepository (also could be subclasses JpaRepository, PagingAndSortingRepository)

public interface CityRepository extends PagingAndSortingRepository<City, Integer> {

    City findCityByCountryCodeContainsOrNameContainsOrderByPopulationDesc(String s, String s1);
    List<City> findTopByPopulationOrderByPopulationDesc(Integer i);

}
