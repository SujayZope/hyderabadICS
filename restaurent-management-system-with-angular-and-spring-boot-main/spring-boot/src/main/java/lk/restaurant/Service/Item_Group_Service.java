package lk.restaurant.Service;

import lk.restaurant.DTO.Item_GroupDTO;

import java.util.List;

public interface Item_Group_Service {

    public List<Item_GroupDTO> getAll(Integer rid, Integer mid, Integer fid,Integer maid,Integer rate)throws Exception;
}
