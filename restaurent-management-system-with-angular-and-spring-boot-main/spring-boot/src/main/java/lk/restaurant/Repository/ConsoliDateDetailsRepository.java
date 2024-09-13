package lk.restaurant.Repository;

import lk.restaurant.Model.Consolidatedetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoliDateDetailsRepository extends JpaRepository<Consolidatedetail,Long>{

    Consolidatedetail save(Consolidatedetail consolidateDetail);

    @Modifying
    @Query("UPDATE Consolidatedetail c SET c.qty = :qty, c.unit_prices = :unit_prices, c.ttlvalue = :ttlvalue WHERE c.item_no = :item_no")
    int updateDetails(@Param("item_no") int item_no, @Param("qty") Integer qty, @Param("unit_prices") Double unit_prices,
                      @Param("ttlvalue") Double ttlvalue);


    @Modifying
    @Query("delete from Consolidatedetail where Kot_no = :Kot_no and item_code = :item_code")
    void deleteDetails(@Param("Kot_no") Integer Kot_no, @Param("item_code") Integer item_code);

}
