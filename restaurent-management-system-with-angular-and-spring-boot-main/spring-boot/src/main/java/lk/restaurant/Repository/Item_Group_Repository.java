package lk.restaurant.Repository;

import lk.restaurant.Model.M_Item;
import lk.restaurant.Repository.Custom.Item_Group_Custom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Item_Group_Repository extends JpaRepository<M_Item,Integer>, Item_Group_Custom {

}
