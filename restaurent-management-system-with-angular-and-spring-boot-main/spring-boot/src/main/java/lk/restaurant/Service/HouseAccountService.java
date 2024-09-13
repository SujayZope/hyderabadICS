package lk.restaurant.Service;

import lk.restaurant.DTO.ManagersDTO;

import java.util.ArrayList;

public interface HouseAccountService {

    public ArrayList<ManagersDTO> getAll()throws Exception;
}
