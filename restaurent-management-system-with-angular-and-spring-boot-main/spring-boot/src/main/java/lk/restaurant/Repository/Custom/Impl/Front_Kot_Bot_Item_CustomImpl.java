package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.Model.Front_kot_bot_item;
import lk.restaurant.Repository.Custom.Front_Kot_Bot_Item_Custom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Front_Kot_Bot_Item_CustomImpl implements Front_Kot_Bot_Item_Custom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Front_kot_bot_item> getAllItemNo(Integer kot) throws Exception {
        Query q=entityManager.createNativeQuery("SELECT * FROM front_kot_bot_item WHERE kot_bot_no="+kot+"",Front_kot_bot_item.class);
        return q.getResultList();
    }
}
