package lk.restaurant.Repository;

import lk.restaurant.Model.Front_kot_bot_discount;
import lk.restaurant.Repository.Custom.Front_kot_bot_discount_Custom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Front_kot_bot_discount_Repository extends JpaRepository<Front_kot_bot_discount,Integer>, Front_kot_bot_discount_Custom {

    @Modifying
    @Query("UPDATE Front_kot_bot_discount c SET c.value = :value, c.disvountType= :disvountType WHERE c.itemNo = :itemNo")
    int updateDiscountFDetails(@Param("itemNo") int ìtemNo, @Param("value") Double value, @Param("disvountType") Integer disvountType);

    @Modifying
    @Query("delete from Front_kot_bot_discount where itemNo = :itemNo")
    void deleteDiscount(@Param("itemNo") Integer itemNo);

}
