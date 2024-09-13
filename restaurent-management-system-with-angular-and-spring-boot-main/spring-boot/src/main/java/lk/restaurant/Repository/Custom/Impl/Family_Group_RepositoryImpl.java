package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.Model.M_Group_Family;
import lk.restaurant.Repository.Custom.Family_Group_Custom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class Family_Group_RepositoryImpl implements Family_Group_Custom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<M_Group_Family> getAllNames(Integer rid) throws Exception {
        Query q=entityManager.createNativeQuery("SELECT m_group_family.F_no,m_group_family.F_M_no,m_group_family.F_name FROM " +
                "m_group_family INNER JOIN config_restaurant_item ON m_group_family .F_no = config_restaurant_item.family_no " +
                "WHERE res_no="+rid+"",M_Group_Family.class);

        return q.getResultList();

    }
}
