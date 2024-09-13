package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.Model.M_Item;
import lk.restaurant.Model.Tax;
import lk.restaurant.Repository.Custom.TaxClass_Custom;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TaxClass_RepositoryImpl implements TaxClass_Custom {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<M_Item> getAll(Integer code){
        Query query=entityManager.createNativeQuery("SELECT * FROM m_item WHERE item_code="+code+"",M_Item.class);
        return query.getResultList();
    }

    @Override
    public List<Tax> getAllTax(Integer taxClass) {
        Query query=entityManager.createNativeQuery("SELECT TaxNo,TaxName,Rate,taxCalculateValue FROM tax " +
                "INNER JOIN tax_class_taxes ON tax.TaxNo = tax_class_taxes.Tax_No WHERE Tax_Class_No="+taxClass+"",Tax.class);
        return query.getResultList();
    }
}
