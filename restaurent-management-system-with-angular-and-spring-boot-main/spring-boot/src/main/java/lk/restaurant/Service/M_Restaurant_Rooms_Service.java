package lk.restaurant.Service;

import lk.restaurant.DTO.M_Restaurant_RoomsDTO;

import java.util.List;

public interface M_Restaurant_Rooms_Service {

    List<M_Restaurant_RoomsDTO> getAllResRooms(Integer id);
}
