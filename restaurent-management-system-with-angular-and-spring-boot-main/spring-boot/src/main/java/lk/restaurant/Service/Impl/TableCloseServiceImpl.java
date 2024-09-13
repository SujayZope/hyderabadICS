package lk.restaurant.Service.Impl;

import lk.restaurant.Builder.DtoBulder;
import lk.restaurant.Builder.EntityBuilder;
import lk.restaurant.DTO.Front_kot_bot_mainDTO;
import lk.restaurant.Model.Front_kot_bot_main;
import lk.restaurant.Repository.TableCloseRepository;
import lk.restaurant.Service.TableCloseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TableCloseServiceImpl implements TableCloseService {

    @Autowired
    EntityBuilder entityBuilder;

    @Autowired
    DtoBulder dtoBulder;

    @Autowired
    TableCloseRepository tableCloseRepository;


    @Override
    public Integer update(Integer bot_mainDTO) {
        Front_kot_bot_main bot_main=tableCloseRepository.getOne((bot_mainDTO));
        bot_main.setOpen_in_table(0);
        bot_main.setTableStatus(0);
        tableCloseRepository.save(bot_main);
        return bot_main.getKotNo();
    }

    @Override
    public List<Front_kot_bot_mainDTO> getAll(Integer id) {
        List<Front_kot_bot_mainDTO> dtos=new ArrayList<>();
        for (Front_kot_bot_main botMain:tableCloseRepository.getAllValues(id)){
            dtos.add(dtoBulder.buildOrderTablesEntity(botMain));
        }
        return dtos;
    }

    @Override
    public List<Front_kot_bot_mainDTO> getAllKots(Integer taId,Integer reId) {
        List<Front_kot_bot_mainDTO> botMainDTOS=new ArrayList<>();
        for (Front_kot_bot_main bot_main:tableCloseRepository.getAllKot(taId,reId)){
            botMainDTOS.add(dtoBulder.buildGetKotEntity(bot_main));
        }
        return botMainDTOS;
    }
}

