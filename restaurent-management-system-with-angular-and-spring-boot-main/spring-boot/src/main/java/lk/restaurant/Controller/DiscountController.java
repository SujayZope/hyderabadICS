package lk.restaurant.Controller;

import lk.restaurant.DTO.ConfigDiscountDTO;
import lk.restaurant.Service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class DiscountController {

    @Autowired
    DiscountService discountService;


    @PostMapping(value = "/discount")
    public List<List<ConfigDiscountDTO>> getAll(@RequestBody List<Integer> id) {
        List<List<ConfigDiscountDTO>> result = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (Integer object : id) {
            if (!numbers.contains(object)) {
                numbers.add(object);
            }
        }
        for (Integer value : numbers) {
            try {
                List<ConfigDiscountDTO> all = discountService.getAll(value);


                result.add(all);


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @PostMapping(value = "getAllGroups")
    public List<Integer> getAllGroups(@RequestBody List<Integer> id) {
        List<Integer> groups = new ArrayList<>();
        List<Integer> familyIds = new ArrayList<>();
        try {
            for (int i = 0; i < id.size(); i++) {
                Integer allGroups = discountService.getAllGroups(id.get(i));
                groups.add(allGroups);
            }
            for (Integer object : groups) {
                if (!familyIds.contains(object)) {
                    familyIds.add(object);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return familyIds;
    }

}
