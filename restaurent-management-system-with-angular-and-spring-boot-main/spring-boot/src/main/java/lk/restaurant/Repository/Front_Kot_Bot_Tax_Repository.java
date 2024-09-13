package lk.restaurant.Repository;

import lk.restaurant.Model.Front_kot_bot_tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Front_Kot_Bot_Tax_Repository extends JpaRepository<Front_kot_bot_tax,Long> {

    @Modifying
    @Query("delete from Front_kot_bot_tax where KB_ItemNo = :KB_ItemNo")
    void deleteTax(@Param("KB_ItemNo") Integer KB_ItemNo);

}
