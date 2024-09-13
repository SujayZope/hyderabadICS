package lk.restaurant.Service.Impl;

import lk.restaurant.Builder.DtoBulder;
import lk.restaurant.DTO.ConfigDiscountDTO;
import lk.restaurant.Model.Config_Discount;
import lk.restaurant.Model.M_Item;
import lk.restaurant.Repository.DiscountRepository;
import lk.restaurant.Repository.Item_Group_Repository;
import lk.restaurant.Service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    DiscountRepository discountRepository;

    @Autowired
    Item_Group_Repository item_group_repository;

    @Autowired
    DtoBulder dtoBulder;

    @Override
    public List<ConfigDiscountDTO> getAll(Integer id) throws Exception {
        List<ConfigDiscountDTO> result=new ArrayList<>();
        Double percentage=null;
        for(Config_Discount discount:discountRepository.getAll(id)){
            percentage=discount.getDispercentage();
            result.add(dtoBulder.buildDiscount(discount));
        }


        if(percentage!=null) {
            ConfigDiscountDTO discount = new ConfigDiscountDTO();
            discount.setDisNo(0);
            discount.setFamilyNo(id);
            discount.setDisPosName("Remove");
            discount.setDisType(0);
            discount.setDisPercentage(0.0);
            discount.setDisValue(0.0);
            discount.setIsFamily(0);

            result.add(discount);
        }
        return result;
    }

    @Override
    public Integer getAllGroups(Integer id) throws Exception {
        List<M_Item> result=new ArrayList<>();
        result=item_group_repository.getAllGroups(id);
        Integer groups=null;
        for(M_Item item: result){
            groups=item.getFamilyGno();
        }
        return groups;
    }

}
