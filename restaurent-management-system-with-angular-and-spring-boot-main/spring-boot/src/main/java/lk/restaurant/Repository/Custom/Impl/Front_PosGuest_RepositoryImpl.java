package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.Model.Front_posguest;
import lk.restaurant.Repository.Custom.Front_PosGuest_Custom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Front_PosGuest_RepositoryImpl implements Front_PosGuest_Custom {

    @Autowired
    EntityManager entityManager;

    @Override
    public Integer getMax() {
        Query q=entityManager.createNativeQuery("SELECT MAX(pos_guest_no) FROM Front_posguest", Front_posguest.class);
        System.out.println(q.getSingleResult());
        return q.getFirstResult();
    }
}
