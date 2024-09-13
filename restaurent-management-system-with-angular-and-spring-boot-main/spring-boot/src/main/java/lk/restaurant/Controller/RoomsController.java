package lk.restaurant.Controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaxxer.hikari.util.ClockSource.Factory;

import lk.restaurant.DTO.RoomsDTO;
import lk.restaurant.Service.RoomsService;
import lk.restaurant.Service.Impl.RoomsServiceImpl;

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
