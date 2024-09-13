package lk.restaurant.Service.Impl;

import lk.restaurant.Model.Front_kot_bot_main;
import lk.restaurant.Repository.Front_Kot_Bot_Main_Repository;
import lk.restaurant.Repository.Front_PosGuest_Repository;
import lk.restaurant.Service.KotTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class KotTransferServiceImpl implements KotTransferService {

    @Autowired
    Front_Kot_Bot_Main_Repository front_kot_bot_main_repository;

    @Autowired
    Front_PosGuest_Repository front_posGuest_repository;

    @Transactional
    @Override
    public boolean addTransfer(Integer kot, Integer tableId) {
        front_kot_bot_main_repository.updateKotTransfer(kot,tableId);
        Front_kot_bot_main result=front_kot_bot_main_repository.findByKotNo(kot);
        front_posGuest_repository.updateKotTransfer(result.getPos_Guest_no(),tableId);
        return true;
    }
}
