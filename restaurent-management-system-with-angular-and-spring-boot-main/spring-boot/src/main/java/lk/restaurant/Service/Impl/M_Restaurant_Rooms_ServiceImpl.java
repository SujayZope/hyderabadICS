package lk.restaurant.Service.Impl;

import lk.restaurant.Builder.DtoBulder;
import lk.restaurant.DTO.M_Restaurant_RoomsDTO;
import lk.restaurant.Model.M_Restaurant_Room;
import lk.restaurant.Repository.M_Restaurant_Rooms_Repository;
import lk.restaurant.Service.M_Restaurant_Rooms_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class M_Restaurant_Rooms_ServiceImpl implements M_Restaurant_Rooms_Service {

    @Autowired
    M_Restaurant_Rooms_Repository m_restaurant_rooms_repository;

    @Autowired
    DtoBulder dtoBulder;

    @Override
    public List<M_Restaurant_RoomsDTO> getAllResRooms(Integer id) {

        List<M_Restaurant_RoomsDTO> getAll=new ArrayList<>();

        for(M_Restaurant_Room room:m_restaurant_rooms_repository.getResRooms(id)){
            getAll.add(dtoBulder.buildResRooms(room));
        }
        return getAll;
    }
}
