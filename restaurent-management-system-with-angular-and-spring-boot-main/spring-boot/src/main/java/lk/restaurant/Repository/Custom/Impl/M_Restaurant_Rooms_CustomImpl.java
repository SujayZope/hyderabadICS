package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.Model.M_Restaurant_Room;
import lk.restaurant.Repository.Custom.M_Restaurant_Rooms_Custom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class M_Restaurant_Rooms_CustomImpl implements M_Restaurant_Rooms_Custom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<M_Restaurant_Room> getResRooms(Integer id) {
        Query q=entityManager.createNativeQuery("SELECT * FROM m_restaurant_room WHERE Res_no='"+id+"'",M_Restaurant_Room.class);
        return q.getResultList();
    }
}
