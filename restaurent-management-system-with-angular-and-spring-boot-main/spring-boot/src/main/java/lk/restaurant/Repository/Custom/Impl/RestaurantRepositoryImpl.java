package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.Model.M_Restaurant;
import lk.restaurant.Repository.Custom.RestaurantRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RestaurantRepositoryImpl implements RestaurantRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<M_Restaurant> getAllRestaurant() {
        Query query=entityManager.createNativeQuery("SELECT restraunt_id,r_location,r_name,TableC FROM m_restaurant",M_Restaurant.class);
        return query.getResultList();
    }
}
