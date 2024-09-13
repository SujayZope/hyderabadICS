package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.Model.M_Item_Rate;
import lk.restaurant.Repository.Custom.ItemRateCustom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ItemRateCustomImpl implements ItemRateCustom {

    @Autowired
    EntityManager entityManager;


    @Override
    public List<M_Item_Rate> getAllRates(Integer itemCode, Integer rate) throws Exception {
        Query q=entityManager.createNativeQuery("SELECT * FROM m_item_rate WHERE Item_No='"+itemCode+"' AND Rate_No='"+rate+"'",M_Item_Rate.class);
        return q.getResultList();
    }
}
