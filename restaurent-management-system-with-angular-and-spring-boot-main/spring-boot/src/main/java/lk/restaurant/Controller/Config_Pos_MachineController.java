package lk.restaurant.Controller;

import lk.restaurant.DTO.Config_pos_machineDTO;
import lk.restaurant.Service.Config_Pos_Machine_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class Config_Pos_MachineController {

    @Autowired
    Config_Pos_Machine_Service config_pos_machine_service;

    @GetMapping(value = "/config")
    public Integer config(@RequestBody Config_pos_machineDTO config_pos_machineDTO){

        int status=0;
        String message=null;
        Integer id=config_pos_machine_service.findByPosIp(config_pos_machineDTO.getPos_ip());
            status=200;
            message="Login Success";
        return id;
    }
}
