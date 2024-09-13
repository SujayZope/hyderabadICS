package lk.restaurant.Repository.Custom;

import lk.restaurant.Model.M_Group_Master;

import java.util.List;

public interface Master_Group_Custom {
    public List<M_Group_Master> getAllNames(Integer rid, Integer mid, Integer fid)throws Exception;
}
