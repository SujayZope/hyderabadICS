package lk.restaurant.Service.Impl;

import lk.restaurant.DTO.ItemDetailsDTO;
import lk.restaurant.Repository.Front_Kot_Bot_Item_Repository;
import lk.restaurant.Service.Front_Kot_Bot_ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Front_Kot_Bot_ItemServiceImpl implements Front_Kot_Bot_ItemService {

    @Autowired
    Front_Kot_Bot_Item_Repository front_kot_bot_item_repository;

    @Override
    public List<ItemDetailsDTO> getAllItems(Integer kot) {
        List<ItemDetailsDTO> detailsDTOS=new ArrayList<>();
//        List<Object> all = front_kot_bot_item_repository.getAll(kot);
//        for(Object al:all){
//            System.out.println(all.size());
//        }
        return null;
    }
}
