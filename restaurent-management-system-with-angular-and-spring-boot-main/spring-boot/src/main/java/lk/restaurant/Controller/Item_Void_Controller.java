package lk.restaurant.Controller;

import lk.restaurant.DTO.Front_kot_bot_item_voidDTO;
import lk.restaurant.DTO.M_void_reasonDTO;
import lk.restaurant.Service.Front_kot_bot_MainService;
import lk.restaurant.Service.ItemVoidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class Item_Void_Controller {

    @Autowired
    ItemVoidService itemVoidService;

    @Autowired
    Front_kot_bot_MainService front_kot_bot_mainService;

    @GetMapping(value = "/reasons")
    public ArrayList<M_void_reasonDTO> getAll(){
        ArrayList<M_void_reasonDTO> reasons=null;
        try {
            reasons=itemVoidService.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return reasons;
    }

    @PostMapping(value = "/add")
    public boolean save(@RequestBody Front_kot_bot_item_voidDTO item_voidDTO){

        Integer id=front_kot_bot_mainService.getUserId(item_voidDTO.getKotNo());
        try {

            if(id.equals(item_voidDTO.getUserId()) || item_voidDTO.getUserType()==1){
                itemVoidService.saveVoid(item_voidDTO);
            }else{
                System.out.println("You can't void this item");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @GetMapping(value = "/allKots")
    public List<Integer> getAllKotNumbers(){
        return front_kot_bot_mainService.getAllKotNumbers();
    }
}
