package lk.restaurant.Repository;

import lk.restaurant.Model.M_Group_Family;
import lk.restaurant.Repository.Custom.Family_Group_Custom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Family_Group_Repository extends JpaRepository<M_Group_Family,Long>, Family_Group_Custom {

}
