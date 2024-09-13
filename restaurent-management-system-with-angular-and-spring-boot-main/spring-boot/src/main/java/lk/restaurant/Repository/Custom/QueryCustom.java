package lk.restaurant.Repository.Custom;

import lk.restaurant.Model.ItemsQueryEntity;
import lk.restaurant.Model.M_ItemEntity;

import java.util.List;


public interface QueryCustom {

    public List<ItemsQueryEntity> getAll(Integer kot);

    public List<M_ItemEntity> getAllItems(Integer majerId,Integer rId);

    public List<M_ItemEntity> searchAllItems(String keyword);
}
