package demo;

import demo.domain.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CountryRepository extends PagingAndSortingRepository<Country, String> {
}
