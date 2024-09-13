package lk.restaurant.Repository;

import lk.restaurant.Model.Config_pos_machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Config_Pos_Machine_Repository extends JpaRepository<Config_pos_machine,Long> {

    Config_pos_machine findByPosIp(String posIp);


}
