package lk.restaurant.Service;

import lk.restaurant.DTO.ConfigDiscountDTO;

import java.util.List;

public interface DiscountService {

    List<ConfigDiscountDTO> getAll(Integer id)throws Exception;

    Integer getAllGroups(Integer id)throws Exception;
}
