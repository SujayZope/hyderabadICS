package lk.restaurant.Repository;

import lk.restaurant.Model.Front_posguest;
import lk.restaurant.Repository.Custom.Front_PosGuest_Custom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Front_PosGuest_Repository extends JpaRepository<Front_posguest,Integer>, Front_PosGuest_Custom {

    @Modifying
    @Query("UPDATE Front_posguest c SET c.table_no = :table_no WHERE c.posguestNo = :posguestNo")
    int updateKotTransfer(@Param("posguestNo") int posguestNo, @Param("table_no") Integer table_no);
}
