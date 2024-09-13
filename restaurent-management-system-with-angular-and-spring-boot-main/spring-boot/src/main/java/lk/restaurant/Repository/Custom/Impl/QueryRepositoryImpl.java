package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.Model.ItemsQueryEntity;
import lk.restaurant.Model.M_ItemEntity;
import lk.restaurant.Repository.Custom.QueryCustom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class QueryRepositoryImpl implements QueryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<ItemsQueryEntity> getAll(Integer kot) {
        Query query=entityManager.createNativeQuery("SELECT * FROM items_query_entity WHERE kot="+kot+"",ItemsQueryEntity.class);
        return query.getResultList();
    }


     @Override
    public List<M_ItemEntity> getAllItems(Integer majerId, Integer rId) {
        Query query = entityManager.createNativeQuery("SELECT * FROM m_item mi,config_restaurant_item cri WHERE majer_gno="+majerId+" AND mi.item_code=cri.item_no AND res_no="+rId+"", M_ItemEntity.class);



        return query.getResultList();


    }


    @Override
    public List<M_ItemEntity> searchAllItems(String keyword) {

        Query query = entityManager.createNativeQuery("SELECT * FROM m_item WHERE item_name LIKE %:keyword%");
        System.out.println(query.getResultList().size());
        return query.getResultList();
    }


}
