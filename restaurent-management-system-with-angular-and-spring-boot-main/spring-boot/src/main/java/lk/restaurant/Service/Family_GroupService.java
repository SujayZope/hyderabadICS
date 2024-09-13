package lk.restaurant.Service;

import lk.restaurant.DTO.Family_GroupDTO;

import java.util.List;

public interface Family_GroupService {

    public List<Family_GroupDTO>getAll(Integer id)throws Exception;
}
