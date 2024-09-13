package lk.restaurant.Service.Impl;

import lk.restaurant.DTO.Config_pos_machineDTO;
import lk.restaurant.Model.Config_pos_machine;
import lk.restaurant.Repository.Config_Pos_Machine_Repository;
import lk.restaurant.Service.Config_Pos_Machine_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Config_Pos_Machine_ServiceImpl implements Config_Pos_Machine_Service {

    @Autowired
    Config_Pos_Machine_Repository config_pos_machine_repository;

    @Override
    public Integer findByPosIp(String posIp) {
        Config_pos_machine id=config_pos_machine_repository.findByPosIp(posIp);
        return id.getRestraunt_id();
    }

    @Override
    public Integer add(Config_pos_machineDTO config_pos_machineDTO) {
        return null;
    }

    @Override
    public Integer update(Config_pos_machineDTO config_pos_machineDTO) {
        return null;
    }

    @Override
    public List<Config_pos_machineDTO> searchLike(Integer userId, String username, String pwd) {
        return null;
    }

    @Override
    public List<Config_pos_machineDTO> get(Integer id) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }
}
