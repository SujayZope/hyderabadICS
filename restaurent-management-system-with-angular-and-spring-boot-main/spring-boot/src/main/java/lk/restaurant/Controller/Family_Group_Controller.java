package lk.restaurant.Controller;

import lk.restaurant.DTO.Family_GroupDTO;
import lk.restaurant.Service.Family_GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class Family_Group_Controller {

    @Autowired
    Family_GroupService family_groupService;

    @GetMapping(value = "/familyGroup/{id}")
    public List<Family_GroupDTO>getAll(@PathVariable Integer id){
        List<Family_GroupDTO> values=null;
        try {
            values = family_groupService.getAll(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return values;
    }
}
