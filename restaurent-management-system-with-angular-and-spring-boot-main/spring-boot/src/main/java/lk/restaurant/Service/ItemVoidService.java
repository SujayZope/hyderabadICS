package lk.restaurant.Service;

import lk.restaurant.DTO.Front_kot_bot_item_voidDTO;
import lk.restaurant.DTO.M_void_reasonDTO;
import lk.restaurant.Service.Commen.CRUDServise;

import java.util.ArrayList;

public interface ItemVoidService extends CRUDServise<M_void_reasonDTO> {

    public ArrayList<M_void_reasonDTO> getAll()throws Exception;

    public Integer saveVoid(Front_kot_bot_item_voidDTO voidDTO)throws Exception;
}
