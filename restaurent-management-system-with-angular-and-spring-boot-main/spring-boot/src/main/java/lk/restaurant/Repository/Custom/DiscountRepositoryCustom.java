package lk.restaurant.Repository.Custom;

import lk.restaurant.Model.Config_Discount;

import java.util.List;

public interface DiscountRepositoryCustom {

    List<Config_Discount> getAll(Integer id)throws Exception;
}
