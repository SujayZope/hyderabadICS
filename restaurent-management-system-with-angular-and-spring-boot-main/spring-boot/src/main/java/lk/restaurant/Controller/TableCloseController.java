package lk.restaurant.Controller;

import lk.restaurant.DTO.Front_kot_bot_mainDTO;
import lk.restaurant.Service.TableCloseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class
TableCloseController {

    @Autowired
    TableCloseService tableCloseService;

    @GetMapping(value = "/closeTable/{kot}")
    public Integer closeTable(@PathVariable Integer kot){
        Integer id=tableCloseService.update(kot);
        return id;
    }

    @PostMapping(value = "/getOpenTables/")
    public List<Front_kot_bot_mainDTO> getAll(@RequestParam(value = "reId")Integer reId){
        List<Front_kot_bot_mainDTO> botMainDTOS=tableCloseService.getAll(reId);
        return  botMainDTOS;
    }

    @PostMapping(value = "/getOrderTables/")
    public List<Front_kot_bot_mainDTO> getAllKot(@RequestParam(value = "taId") Integer taId, @RequestParam(value = "reId") Integer reId){
        List<Front_kot_bot_mainDTO> botMainDTOS=tableCloseService.getAllKots(taId,reId);
        return botMainDTOS;
    }
}
