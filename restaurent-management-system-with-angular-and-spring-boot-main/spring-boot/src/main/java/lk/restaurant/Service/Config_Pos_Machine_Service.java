package lk.restaurant.Service;

import lk.restaurant.DTO.Config_pos_machineDTO;
import lk.restaurant.Service.Commen.CRUDServise;

public interface Config_Pos_Machine_Service extends CRUDServise<Config_pos_machineDTO> {

    Integer findByPosIp(String posIp);


}
