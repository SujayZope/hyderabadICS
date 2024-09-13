package lk.restaurant.Repository;

import lk.restaurant.Model.Front_kot_bot_main;
import lk.restaurant.Repository.Custom.Front_Kot_Bot_Main_Custom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Front_Kot_Bot_Main_Repository extends JpaRepository<Front_kot_bot_main,Integer>, Front_Kot_Bot_Main_Custom {

    Front_kot_bot_main findByKotNo(Integer kot);

    List<Front_kot_bot_main>findAll();

    @Modifying
    @Query("UPDATE Front_kot_bot_main c SET c.tableno = :tableno WHERE c.kotNo = :kotNo")
    int updateKotTransfer(@Param("kotNo") int kotNo, @Param("tableno") Integer tableno);



}
