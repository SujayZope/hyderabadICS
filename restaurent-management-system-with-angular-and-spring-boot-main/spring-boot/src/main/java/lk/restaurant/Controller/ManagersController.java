package lk.restaurant.Controller;

import lk.restaurant.DTO.ManagersDTO;
import lk.restaurant.Service.HouseAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class ManagersController {

    @Autowired
    HouseAccountService houseAccountService;

    @GetMapping(value = "/managers")
    public ArrayList<ManagersDTO> getAll(){
        ArrayList<ManagersDTO>values=null;
        try {
            values=houseAccountService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return values;
    }
}
