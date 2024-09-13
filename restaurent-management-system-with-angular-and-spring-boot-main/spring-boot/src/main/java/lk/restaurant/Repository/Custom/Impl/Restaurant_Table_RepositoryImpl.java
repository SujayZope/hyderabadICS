package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.Model.M_Restaurant_Table;
import lk.restaurant.Repository.Custom.Restaurant_Table_Custom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Restaurant_Table_RepositoryImpl implements Restaurant_Table_Custom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<M_Restaurant_Table> getAllTables(Integer id) {
        Query query=entityManager.createNativeQuery("SELECT Table_Id,Table_Name,Resturent_Id FROM m_restaurant_table WHERE Resturent_Id="+id+"",M_Restaurant_Table.class);
        return query.getResultList();
    }
}
