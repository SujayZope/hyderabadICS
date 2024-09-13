package lk.restaurant.Controller;

import lk.restaurant.DBConnection.Factory;
import lk.restaurant.DTO.RoomsDTO;
import lk.restaurant.Service.Impl.RoomsServiceImpl;
import lk.restaurant.Service.RoomsService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class RoomsController {


    RoomsService roomsService=new RoomsServiceImpl();

    public RoomsController() {
        try {
            roomsService= Factory.getInstance().getDAO(Factory.DAOType.ROOMS);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @GetMapping(value = "/rooms")
    public ArrayList<RoomsDTO> getAll(){
        ArrayList<RoomsDTO> rooms= null;
        try {
            rooms = roomsService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }
}
