package lk.restaurant.Controller;

import lk.restaurant.DTO.Master_GroupDTO;
import lk.restaurant.Service.Master_GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class Master_Group_Controller {

    @Autowired
    Master_GroupService master_groupService;

    @PostMapping(value = "/masterGroup/")
    public List<Master_GroupDTO>getAll(@RequestParam(value = "rid",required = true)Integer rid,
                                       @RequestParam(value = "mid",required = true)Integer mid,
                                       @RequestParam(value = "fid",required = true)Integer fid){
        List<Master_GroupDTO> values=null;
        try {
            values=master_groupService.getAll(rid,mid,fid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return values;
    }
}