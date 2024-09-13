package lk.restaurant.Service.Impl;

import lk.restaurant.Model.Front_kot_bot_main;
import lk.restaurant.Repository.Front_Kot_Bot_Main_Repository;
import lk.restaurant.Service.Front_kot_bot_MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Front_kot_bot_MainServiceImpl implements Front_kot_bot_MainService {

    @Autowired
    Front_Kot_Bot_Main_Repository front_kot_bot_main_repository;

    @Override
    public Integer getUserId(Integer kot) {
        Front_kot_bot_main main=front_kot_bot_main_repository.findByKotNo(kot);
        return main.getUserid();
    }

    @Override
    public List<Integer> getAllKotNumbers() {
        List<Integer> kotNumbers = new ArrayList<>();

        for (Front_kot_bot_main frontKotBotMain: front_kot_bot_main_repository.findAll()) {
            kotNumbers.add(frontKotBotMain.getKotNo());

        }

        return kotNumbers;
    }
}
