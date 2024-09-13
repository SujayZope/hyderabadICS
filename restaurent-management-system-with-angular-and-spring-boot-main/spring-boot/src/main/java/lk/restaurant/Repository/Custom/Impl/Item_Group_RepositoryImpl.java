package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.Model.M_Item;
import lk.restaurant.Repository.Custom.Item_Group_Custom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class Item_Group_RepositoryImpl implements Item_Group_Custom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<M_Item> getAllNames(Integer rid, Integer mid, Integer fid, Integer maid)  {
        Query q=entityManager.createNativeQuery("SELECT m_item.item_code,m_item.family_gno,m_item.item_name,m_item.roundPrice,m_item.txtWithTax,tax_calssId, cost FROM " +
                "m_item INNER JOIN config_restaurant_item ON m_item.item_code= config_restaurant_item.item_no WHERE " +
                "res_no = "+rid+" AND majer_no = "+mid+" AND family_no = "+fid+" AND master_no="+maid+"",M_Item.class);

        return q.getResultList();
    }

    @Override
    public List<M_Item> getAllGroups(Integer id) throws Exception {
        Query q=entityManager.createNativeQuery("SELECT item_code,family_gno,item_name,roundPrice,txtWithTax,tax_calssId,cost FROM m_item WHERE item_code='"+id+"'",M_Item.class);
        return q.getResultList();
    }
}
