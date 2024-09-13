package lk.restaurant.Service.Impl;

import lk.restaurant.Repository.InventoryRepository;
import lk.restaurant.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceimpl implements InventoryService {

    @Autowired(required=true)
    InventoryRepository inventoryRepository;

    @Override
    public Integer selectCurrentId(Integer ItemNo,Integer qty) {

        return inventoryRepository.selectCurrentId(ItemNo,qty);
    }
}
