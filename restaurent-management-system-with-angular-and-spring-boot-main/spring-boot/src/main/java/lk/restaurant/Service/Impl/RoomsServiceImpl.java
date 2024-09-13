package lk.restaurant.Service.Impl;

import lk.restaurant.DTO.RoomsDTO;
import lk.restaurant.Model.Rooms;
import lk.restaurant.Repository.Custom.Impl.RoomsRepositoryImpl;
import lk.restaurant.Repository.RoomsRepository;
import lk.restaurant.Service.RoomsService;

import java.util.ArrayList;
import java.util.List;


public class RoomsServiceImpl implements RoomsService {


    RoomsRepository roomsRepository=new RoomsRepositoryImpl();

    @Override
    public ArrayList<RoomsDTO> getAll()throws Exception {

        ArrayList<RoomsDTO> getResult=new ArrayList<>();
            List<Rooms> result=roomsRepository.getAll();
            for(Rooms rooms:result){
                getResult.add(new RoomsDTO(rooms.getfName(),rooms.getlName(),
                        rooms.getGuestNo(),rooms.getConfNo(),rooms.getGuestStatus(),rooms.getRoomNo(),
                        rooms.getNoAdult(),rooms.getIsTax(),rooms.getPakage(),rooms.getResNo(),rooms.getNoChild(),
                        rooms.getExBedAdult(),rooms.getMarketCate()));
            }

        return getResult;
    }
}
