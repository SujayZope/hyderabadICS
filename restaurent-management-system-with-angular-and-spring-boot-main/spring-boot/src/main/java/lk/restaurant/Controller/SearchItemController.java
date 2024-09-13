package lk.restaurant.Controller;

import lk.restaurant.DTO.Item_GroupDTO;
import lk.restaurant.Service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/api")
public class SearchItemController {



    @Autowired
    QueryService queryService;

    @RequestMapping(value = "/")
    public List<Item_GroupDTO>getAll(@RequestParam(value = "keyword",required = true)String keyword){

        List<Item_GroupDTO> values = null;
        try {
            values = queryService.searchAllItems(keyword);
        }catch (Exception e){
            System.out.println(e);
        }
        return values;

    }






}



