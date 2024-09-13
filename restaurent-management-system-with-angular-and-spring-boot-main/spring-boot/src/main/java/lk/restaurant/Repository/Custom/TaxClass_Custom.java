package lk.restaurant.Repository.Custom;

import lk.restaurant.Model.M_Item;
import lk.restaurant.Model.Tax;

import java.util.List;

public interface TaxClass_Custom {

    public List<M_Item> getAll(Integer code);

    List<Tax> getAllTax(Integer taxClass);
}
