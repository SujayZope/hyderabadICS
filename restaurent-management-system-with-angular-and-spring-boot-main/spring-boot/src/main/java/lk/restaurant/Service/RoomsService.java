package lk.restaurant.Service;

import lk.restaurant.DTO.RoomsDTO;

import java.util.ArrayList;


public interface RoomsService {

    public ArrayList<RoomsDTO> getAll()throws Exception;

}
