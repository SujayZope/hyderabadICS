package lk.restaurant.Controller;

import lk.restaurant.DTO.Item_GroupDTO;
import lk.restaurant.Service.Item_Group_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class Item_Group_Controller {

    @Autowired
    Item_Group_Service item_group_service;

    @PostMapping(value = "/itemGroup/")
    public List<Item_GroupDTO>getAll(@RequestParam(value = "rid",required = true)Integer rid,
                                     @RequestParam(value = "mid",required = true)Integer mid,
                                     @RequestParam(value = "fid",required = true)Integer fid,
                                     @RequestParam(value = "maid",required = true)Integer maid,
                                     @RequestParam(value = "rate",required = true)Integer rate){

        List<Item_GroupDTO> values=null;
        try {
            System.out.println("Rid : "+rid);
            System.out.println("Mid : "+mid);
            System.out.println("Fid : "+fid);
            System.out.println("Maid : "+maid);
            System.out.println("Rate : "+rate);
            values = item_group_service.getAll(rid, mid, fid, maid,rate);

        } catch (Exception e) {
            System.out.println(e);
        }

        return values;
    }
}
