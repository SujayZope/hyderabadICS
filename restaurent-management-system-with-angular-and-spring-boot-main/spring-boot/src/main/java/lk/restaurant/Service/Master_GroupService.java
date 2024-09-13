package lk.restaurant.Service;

import lk.restaurant.DTO.Master_GroupDTO;

import java.util.List;

public interface Master_GroupService {

    public List<Master_GroupDTO> getAll(Integer id,Integer mid,Integer fid)throws Exception;
}
