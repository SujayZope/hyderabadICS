package lk.restaurant.Repository;

import lk.restaurant.Model.M_Item;
import lk.restaurant.Repository.Custom.InventoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<M_Item,Integer>,InventoryCustom {



}
