package lk.restaurant.Repository;

import lk.restaurant.Model.Tax;
import lk.restaurant.Repository.Custom.TaxClass_Custom;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxClass_Repository extends PagingAndSortingRepository<Tax,Long>, TaxClass_Custom {

}
