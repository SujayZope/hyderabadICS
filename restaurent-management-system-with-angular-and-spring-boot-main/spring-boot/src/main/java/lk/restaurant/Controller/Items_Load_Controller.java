package lk.restaurant.Controller;

import lk.restaurant.DTO.AddedDiscountDTO;
import lk.restaurant.DTO.Family_GroupDTO;
import lk.restaurant.DTO.QueryDTO;
import lk.restaurant.Service.Family_GroupService;
import lk.restaurant.Service.Front_kot_bot_MainService;
import lk.restaurant.Service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class Items_Load_Controller {

    @Autowired
    QueryService queryService;

    @Autowired
    Front_kot_bot_MainService front_kot_bot_mainService;

    @Autowired
    Family_GroupService family_groupService;

    @PostMapping(value = "/getAllItems/")
    public List<QueryDTO> getAllItems(@RequestParam(value = "kot", required = true) Integer kot,
                                      @RequestParam(value = "userId", required = true) Integer userId,
                                      @RequestParam(value = "userType", required = true) Integer userType) {

        List<QueryDTO> all = new ArrayList<>();
        Integer id = front_kot_bot_mainService.getUserId(kot);

        if (id == userId || userType == 1) {
            all = queryService.getAll(kot);
            return all;
        } else {
            return null;
        }
    }

    @PostMapping(value = "/getBill/")
    public List<QueryDTO> loadItems(@RequestParam(value = "kot", required = true) Integer kot) {
        List<QueryDTO> all = queryService.getAll(kot);
        return all;
    }

    @PostMapping(value = "/getAllAddedDiscount/")
    public List<AddedDiscountDTO> getAllGroups(@RequestParam(value = "kot", required = true) Integer kot,
                                               @RequestParam(value = "userId", required = true) Integer userId,
                                               @RequestParam(value = "userType", required = true) Integer userType,
                                               @RequestParam(value = "rId", required = true) Integer rId) {


        List<AddedDiscountDTO> all = new ArrayList<>();
        List<Integer> test = new ArrayList<>();
        List<Integer> test2 = new ArrayList<>();
        List<AddedDiscountDTO> finalAll = new ArrayList<>();
        List<AddedDiscountDTO> last = new ArrayList<>();
        List<AddedDiscountDTO> lastReturn = new ArrayList<>();


        Integer id = front_kot_bot_mainService.getUserId(kot);
        List<Family_GroupDTO> families = new ArrayList<>();

        if (id == userId || userType == 1) {
            all = queryService.getAllDiscount(kot);
        } else {
        }

        try {
            families = family_groupService.getAll(rId);

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Family_GroupDTO Object : families) {
            for (AddedDiscountDTO Obj : all) {
                if (Object.getfNo() == Obj.getfId()) {
                    finalAll.add(Obj);
                } else {
                    AddedDiscountDTO addedDiscountDTO = new AddedDiscountDTO();
                    addedDiscountDTO.setfId(Object.getfNo());
                    addedDiscountDTO.setPercentage(0.0);
                    finalAll.add(addedDiscountDTO);
                }
            }
        }


        for (AddedDiscountDTO Obj:finalAll) {
            if (Obj.getPercentage() != 0) {
                test.add(Obj.getfId());
                last.add(Obj);
            }
        }
        for (AddedDiscountDTO Obj:finalAll) {
            if (Obj.getPercentage() == 0) {
                test.add(Obj.getfId());
                last.add(Obj);
            }
        }

        for(AddedDiscountDTO obj:last){
            if(!test2.contains(obj.getfId())){
                test2.add(obj.getfId());
                lastReturn.add(obj);
            }
        }

        return lastReturn;


    }
}
