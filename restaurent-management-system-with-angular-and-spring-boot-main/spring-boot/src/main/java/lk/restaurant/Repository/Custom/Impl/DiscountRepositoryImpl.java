package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.Model.Config_Discount;
import lk.restaurant.Repository.Custom.DiscountRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DiscountRepositoryImpl implements DiscountRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Config_Discount> getAll(Integer id) throws Exception {
        Query q=entityManager.createNativeQuery("SELECT * FROM config_discount WHERE FamilyNo='"+id+"'",Config_Discount.class);
        return q.getResultList();
    }
}
