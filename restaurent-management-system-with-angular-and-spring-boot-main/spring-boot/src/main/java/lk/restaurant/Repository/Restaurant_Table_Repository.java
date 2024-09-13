package lk.restaurant.Repository;

import lk.restaurant.Model.M_Restaurant_Table;
import lk.restaurant.Repository.Custom.Restaurant_Table_Custom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Restaurant_Table_Repository extends JpaRepository<M_Restaurant_Table,Integer>, Restaurant_Table_Custom {


}
