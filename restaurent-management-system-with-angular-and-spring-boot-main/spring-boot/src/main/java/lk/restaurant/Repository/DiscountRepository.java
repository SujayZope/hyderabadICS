package lk.restaurant.Repository;

import lk.restaurant.Model.Config_Discount;
import lk.restaurant.Repository.Custom.DiscountRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DiscountRepository extends JpaRepository<Config_Discount,Integer>,DiscountRepositoryCustom{

}
