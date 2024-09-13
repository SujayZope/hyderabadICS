package lk.restaurant.Service;

import lk.restaurant.DTO.Front_kot_bot_mainDTO;

import java.util.List;

public interface TableCloseService{

    Integer update(Integer kot);

    List<Front_kot_bot_mainDTO> getAll(Integer id);

    List<Front_kot_bot_mainDTO> getAllKots(Integer taId,Integer reId);
}
