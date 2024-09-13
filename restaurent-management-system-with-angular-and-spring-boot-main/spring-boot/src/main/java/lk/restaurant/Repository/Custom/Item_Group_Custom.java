package lk.restaurant.Repository.Custom;

import lk.restaurant.Model.M_Item;

import java.util.List;

public interface Item_Group_Custom {

    public List<M_Item> getAllNames(Integer rid, Integer mid, Integer fid, Integer maid)throws Exception;
    List<M_Item> getAllGroups(Integer id)throws Exception;
}
