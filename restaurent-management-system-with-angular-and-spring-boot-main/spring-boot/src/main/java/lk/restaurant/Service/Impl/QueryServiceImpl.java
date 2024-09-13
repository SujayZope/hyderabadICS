package lk.restaurant.Service.Impl;

import lk.restaurant.Builder.DtoBulder;
import lk.restaurant.DTO.AddedDiscountDTO;
import lk.restaurant.DTO.Item_GroupDTO;
import lk.restaurant.DTO.QueryDTO;
import lk.restaurant.Model.ItemsQueryEntity;
import lk.restaurant.Model.M_ItemEntity;
import lk.restaurant.Repository.QueryRepository;
import lk.restaurant.Service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    DtoBulder dtoBulder;

    @Autowired
    QueryRepository queryRepository;

    @Override
    public List<QueryDTO> getAll(Integer kot) {
        List<QueryDTO> getAll=new ArrayList<>();
        for(ItemsQueryEntity itemsQueryEntity:queryRepository.getAll(kot)){
            getAll.add(dtoBulder.buildItemsQuery(itemsQueryEntity));
        }
        return getAll;
    }

    @Override
    public List<AddedDiscountDTO> getAllDiscount(Integer kot) {
        List<AddedDiscountDTO> getAll=new ArrayList<>();
        List<Integer> Test=new ArrayList<>();
        List<AddedDiscountDTO>getValues=new ArrayList<>();
        for(ItemsQueryEntity itemsQueryEntity:queryRepository.getAll(kot)){
            getAll.add(dtoBulder.buildDiscountQuery(itemsQueryEntity));
        }

        for (AddedDiscountDTO values:getAll){
            if(!Test.contains(values.getfId())){
                Test.add(values.getfId());
                getValues.add(values);
            }
        }


        return getValues;
    }

     @Override
    public List<Item_GroupDTO> getAllItems(Integer majerGno,Integer rId) {
        List<Item_GroupDTO> getAllItems=new ArrayList<>();
        for (M_ItemEntity mitem:queryRepository.getAllItems(majerGno,rId)) {

            getAllItems.add(dtoBulder.buildMItemQuery(mitem));
        }
        return getAllItems;
    }

    @Override
    public List<Item_GroupDTO> searchAllItems(String keyword) throws Exception {
        List<Item_GroupDTO> searchAllItems = new ArrayList<>();
        for (M_ItemEntity mitem: queryRepository.searchAllItems(keyword)){
            searchAllItems.add(dtoBulder.buildMItemQuery(mitem));
        }
        return searchAllItems;
    }
}
