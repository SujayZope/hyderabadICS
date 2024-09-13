package lk.restaurant.Controller;

import lk.restaurant.DTO.Consolidate_detailDTO;
import lk.restaurant.DTO.Front_PaymentDTO;
import lk.restaurant.Service.Payment_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class Payment_Controller {
    @Autowired
    Payment_Service payment_service;



    @PostMapping(value = "/saveUser")
    public boolean savePayment(@RequestBody Front_PaymentDTO front_paymentDTO){
        return payment_service.addPayment(front_paymentDTO);

    }

    @PostMapping(value = "/saveConso")
    public void saveConsolidateDetails(@RequestBody Consolidate_detailDTO consolidateDtoList){
         payment_service.addConsolidateDetails(consolidateDtoList);
    }


}
