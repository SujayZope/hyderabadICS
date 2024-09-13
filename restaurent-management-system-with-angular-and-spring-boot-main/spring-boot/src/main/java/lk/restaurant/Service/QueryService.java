package lk.restaurant.Service;

import lk.restaurant.DTO.AddedDiscountDTO;
import lk.restaurant.DTO.Item_GroupDTO;
import lk.restaurant.DTO.QueryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QueryService {

    List<QueryDTO> getAll(Integer kot);

    List<AddedDiscountDTO> getAllDiscount(Integer kot);

    public List<Item_GroupDTO> getAllItems(Integer majerGno, Integer rId) throws Exception;

    public List<Item_GroupDTO> searchAllItems(String keyword) throws Exception;
}
