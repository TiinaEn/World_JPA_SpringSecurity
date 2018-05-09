package fi.academy;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


/*
public interface CountryRepository extends CrudRepository<Country, String> {
    }*/

public interface CountryRepository extends PagingAndSortingRepository<Country, String> {

}

