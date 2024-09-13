package lk.restaurant.Service.Impl;

import lk.restaurant.DTO.Item_GroupDTO;
import lk.restaurant.Model.M_Item;
import lk.restaurant.Model.M_Item_Rate;
import lk.restaurant.Repository.ItemRateRepository;
import lk.restaurant.Repository.Item_Group_Repository;
import lk.restaurant.Service.Item_Group_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Item_Group_ServiceImpl implements Item_Group_Service {

    @Autowired
    Item_Group_Repository item_group_repository;

    @Autowired
    ItemRateRepository itemRateRepository;

    @Override
    public List<Item_GroupDTO> getAll(Integer rid, Integer mid, Integer fid, Integer maid, Integer rate) throws Exception{
        List<M_Item> allNames = item_group_repository.getAllNames(rid, mid, fid, maid);
        List<Integer>demo=new ArrayList<>();
        ArrayList<Item_GroupDTO>groups=new ArrayList<>();

        for(M_Item item:allNames){

            if(!demo.contains(item.getItem_code())){
                demo.add(item.getItem_code());

                List<M_Item_Rate> ratePrice=itemRateRepository.getAllRates(item.getItem_code(),rate);

                if(rate==4){
                    for(M_Item_Rate r:ratePrice) {
                        groups.add(new Item_GroupDTO(item.getItem_code(), item.getItem_name(), r.getRate_Value(),r.getRoundprice()));
                    }
                }else if(rate==5){
                    for(M_Item_Rate r:ratePrice){
                        groups.add(new Item_GroupDTO(item.getItem_code(), item.getItem_name(), r.getRate_Value(),r.getRoundprice()));
                    }
                }else if(rate==1){
                    for(M_Item_Rate r:ratePrice){
                        groups.add(new Item_GroupDTO(item.getItem_code(), item.getItem_name(),r.getRate_Value(),r.getRoundprice()));
                    }
                }
            }
        }
        return groups;
    }

}
