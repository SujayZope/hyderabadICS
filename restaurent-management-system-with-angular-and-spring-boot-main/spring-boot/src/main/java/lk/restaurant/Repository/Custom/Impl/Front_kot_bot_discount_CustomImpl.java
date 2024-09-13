package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.Model.Front_kot_bot_discount;
import lk.restaurant.Repository.Custom.Front_kot_bot_discount_Custom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Front_kot_bot_discount_CustomImpl implements Front_kot_bot_discount_Custom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Front_kot_bot_discount> getDisNo(Integer id) throws Exception {
        Query q=entityManager.createNativeQuery("SELECT * FROM front_kot_bot_discount WHERE item_no='"+id+"'", Front_kot_bot_discount.class);
        return q.getResultList();
    }
}
