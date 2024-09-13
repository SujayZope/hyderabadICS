package lk.restaurant.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lk.restaurant.DTO.Front_kot_bot_itemDTO;
import lk.restaurant.DTO.Main_ReservationDTO;
import lk.restaurant.DTO.TempDataDTO;
import lk.restaurant.DTO.Commen.ResponsDTO;
import lk.restaurant.ReportManager.ReportManager;
import lk.restaurant.Service.InventoryService;
import lk.restaurant.Service.MainReservationService;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
public class MainReservationController {

    @Autowired
    MainReservationService mainReservationService;

    @Autowired(required=true)
    InventoryService inventoryService;

    @PostMapping(value = "/mainReservation/addTemp")
    public boolean saveTempData(@RequestBody TempDataDTO tempDataDTO){
            mainReservationService.addTempData(tempDataDTO);
            return true;
    }

    @GetMapping(value = "/mainReservation/getRate")
    public Double getRateForPickMeAndUber(){
       return mainReservationService.getRateForPickMeAndUber();
    }

    @PostMapping(value = "/mainReservation/add")
    public ResponsDTO saveAll(@RequestBody Main_ReservationDTO main_reservationDTO) {



        List<Front_kot_bot_itemDTO> frontKotBotItemDTO = main_reservationDTO.getFrontKotBotItemDTO();

       for (int i=0;i<main_reservationDTO.getFrontKotBotItemDTO().size();i++){
            inventoryService.selectCurrentId(frontKotBotItemDTO.get(i).getItemCode(),frontKotBotItemDTO.get(i).getQty());
      }

        Integer kot=null;
        int status=0;
        String message=null;
        String[] lastOrderDetails=null;
        try {
            kot = mainReservationService.add(main_reservationDTO);

            status=200;
            message="Save Successful";
        } catch (Exception e) {
            status=400;
            message="Save Fail";
        }

        // End Report Section ..............................................................
        try {
            boolean b = new ReportManager().printInvoice(new ResponsDTO(kot, status, message));
            System.out.println("submit order is : "+b);
        }catch(Exception e){
            System.out.println(e);
        }

        return new ResponsDTO(kot,status,message);
    }

    @PutMapping(value = "/mainReservation/update")
    public ResponsDTO updateAll(@RequestBody Main_ReservationDTO main_reservationDTO){
        System.err.println("Update Running..............");
        Integer no=null;
        int status=0;
        String message=null;
        try {
            no= mainReservationService.update(main_reservationDTO);
            status=200;
            message="Update Successful";

        }catch (Exception e){
            status=400;
            message="Update fail";
        }
            return new ResponsDTO(no,status,message);
    }

    @DeleteMapping(value = "/mainReservation/delete")
    public boolean deleteAll(@RequestParam(value ="kot", required = true)Integer kot,
                             @RequestParam(value = "itemNo", required = true)Integer itemNo,
                             @RequestParam(value = "itemCode", required = true)Integer itemCode){
        if(kot!=null) {
            Integer no = mainReservationService.deleteItems(kot, itemNo, itemCode);
            return true;
        }
        return false;
    }
}
