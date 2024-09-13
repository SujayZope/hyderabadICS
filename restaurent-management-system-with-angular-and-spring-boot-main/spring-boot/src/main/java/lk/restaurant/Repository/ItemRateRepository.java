package lk.restaurant.Repository;

import lk.restaurant.Model.M_Item_Rate;
import lk.restaurant.Repository.Custom.ItemRateCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRateRepository extends JpaRepository<M_Item_Rate,Integer>, ItemRateCustom {
}
