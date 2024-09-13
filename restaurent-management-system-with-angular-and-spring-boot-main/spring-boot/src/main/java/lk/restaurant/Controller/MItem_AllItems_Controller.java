package lk.restaurant.Controller;

import lk.restaurant.DTO.Item_GroupDTO;
import lk.restaurant.Service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class MItem_AllItems_Controller {

    @Autowired
    QueryService queryService;
    @PostMapping(value = "/getAllPosItems/")
    public List<Item_GroupDTO>getAll(@RequestParam(value = "majer_gno",required = true)Integer majer_gno,
                                     @RequestParam(value = "rId",required = true)String rId
                                     ){
        List<Item_GroupDTO> values = null;
        try {
            values = queryService.getAllItems(majer_gno,Integer.parseInt(rId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return values;
    }
}
