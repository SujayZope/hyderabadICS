package lk.restaurant.Repository.Custom;

import lk.restaurant.Model.M_Item_Rate;

import java.util.List;

public interface ItemRateCustom {

    public List<M_Item_Rate> getAllRates(Integer itemCode, Integer rate)throws Exception;
}
