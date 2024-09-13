package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.Model.M_Group_Master;
import lk.restaurant.Repository.Custom.Master_Group_Custom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class Master_Group_RepositoryImpl implements Master_Group_Custom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<M_Group_Master> getAllNames(Integer rid, Integer mid, Integer fid) throws Exception {
        Query q=entityManager.createNativeQuery("SELECT m_group_master.Master_no,m_group_master.Master_F_no,m_group_master.Master_m_no," +
                "m_group_master.Master_name FROM m_group_master INNER JOIN config_restaurant_item ON " +
                "m_group_master.Master_no= config_restaurant_item.master_no WHERE res_no="+rid+" AND majer_no="+mid+" " +
                "AND family_no="+fid+"",M_Group_Master.class);

        return q.getResultList();
    }
}
