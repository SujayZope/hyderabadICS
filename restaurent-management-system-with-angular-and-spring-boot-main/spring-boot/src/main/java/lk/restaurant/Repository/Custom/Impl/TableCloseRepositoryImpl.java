package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.Model.Front_kot_bot_main;
import lk.restaurant.Repository.Custom.TableCloseCustom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TableCloseRepositoryImpl implements TableCloseCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Front_kot_bot_main> getAllValues(Integer id) {
        Query query=entityManager.createNativeQuery("SELECT * FROM front_kot_bot_main WHERE resturent_id="+id+"  AND open_in_table=1 AND table_status=1",Front_kot_bot_main.class);
//        AND resRoom='"+resRoom+"'
        return query.getResultList();
    }

    @Override
    public List<Front_kot_bot_main> getAllKot(Integer taId,Integer reId) {
        Query query=entityManager.createNativeQuery("SELECT * FROM front_kot_bot_main WHERE open_in_table=1 AND table_status=1 AND tableNo="+taId+" AND resturent_Id="+reId+"",Front_kot_bot_main.class);
        return query.getResultList();
    }

}
