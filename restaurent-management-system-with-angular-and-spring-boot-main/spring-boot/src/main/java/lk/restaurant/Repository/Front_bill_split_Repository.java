package lk.restaurant.Repository;

import lk.restaurant.Model.Front_bill_split;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Front_bill_split_Repository extends JpaRepository<Front_bill_split,Integer> {

    @Modifying
    @Query("delete from Front_bill_split where kotNo= :kotNo")
    void deleteSplit(@Param("kotNo") Integer kotNo);

}
