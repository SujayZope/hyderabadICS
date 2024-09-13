package lk.restaurant.Controller;

import lk.restaurant.Service.KotTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class KotTransferController {

    @Autowired
    KotTransferService kotTransferService;

    @PostMapping(value = "/kotTransfer/")
    public boolean getTables(@RequestParam(value = "kot",required = true) Integer kot,
                             @RequestParam(value = "tableId",required = true) Integer tableId){
        boolean result=kotTransferService.addTransfer(kot,tableId);
        if (result){
            return true;
        }else{
            return false;
        }
    }
}
