package lk.restaurant.Repository;

import lk.restaurant.Model.ItemsQueryEntity;
import lk.restaurant.Repository.Custom.QueryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends JpaRepository<ItemsQueryEntity,Integer>, QueryCustom {

    @Modifying
    @Query("UPDATE ItemsQueryEntity c SET c.qty = :qty, c.price= :price, c.priceWithTax= :priceWithTax WHERE c.itemNo = :itemNo")
    int updateItemDetails(@Param("itemNo") int item_no, @Param("qty") Integer qty, @Param("price") Double price,
                      @Param("priceWithTax") Double priceWithTax);

    @Modifying
    @Query("UPDATE ItemsQueryEntity c SET c.familyId = :familyId, c.disPercentage= :disPercentage, c.disType = :disType WHERE c.itemNo = :itemNo")
    int updateItemDiscount(@Param("itemNo") int item_no, @Param("familyId") Integer familyId, @Param("disPercentage") Double disPercentage, @Param("disType") Integer disType);

    @Modifying
    @Query("delete from ItemsQueryEntity where itemNo = :itemNo")
    void deleteDetails(@Param("itemNo") Integer itemNo);
}
