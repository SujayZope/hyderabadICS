package lk.restaurant.Service;

import lk.restaurant.DTO.Main_ReservationDTO;
import lk.restaurant.DTO.TempDataDTO;
import lk.restaurant.Service.Commen.CRUDServise;

public interface MainReservationService extends CRUDServise<Main_ReservationDTO> {

    public Integer deleteItems(Integer kot,Integer itemNo,Integer itemCode);

    void addTempData(TempDataDTO tempDataDTO);

    Double getRateForPickMeAndUber();


}
