package lk.restaurant.Service.Impl;

import lk.restaurant.DTO.Front_kot_bot_item_voidDTO;
import lk.restaurant.DTO.M_void_reasonDTO;
import lk.restaurant.Model.Front_kot_bot_item_void;
import lk.restaurant.Model.M_void_reason;
import lk.restaurant.Repository.Front_Kot_Bot_ItemVoid_Repository;
import lk.restaurant.Repository.ItemVoidRepository;
import lk.restaurant.Service.ItemVoidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ItemVoidServiceImpl implements ItemVoidService {

    @Autowired
    ItemVoidRepository itemVoidRepository;

    @Autowired
    Front_Kot_Bot_ItemVoid_Repository front_kot_bot_itemVoid_repository;

    @Override
    public Integer add(M_void_reasonDTO m_void_reasonDTO) throws Exception {
        return null;
    }

    @Override
    public Integer update(M_void_reasonDTO m_void_reasonDTO) {
        return null;
    }

    @Override
    public List<M_void_reasonDTO> searchLike(Integer userId, String username, String pwd) {
        return null;
    }

    @Override
    public List<M_void_reasonDTO> get(Integer id) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public ArrayList<M_void_reasonDTO> getAll() throws Exception {
        ArrayList<M_void_reasonDTO> getAll=new ArrayList<>();
        List<M_void_reason> result=itemVoidRepository.findAll();
        for (M_void_reason reasons :
                result) {
            getAll.add(new M_void_reasonDTO(reasons.getPkno(),reasons.getReason()));
        }
        return getAll;
    }

    @Override
    public Integer saveVoid(Front_kot_bot_item_voidDTO voidDTO) throws Exception {

        Front_kot_bot_item_void item_void=new Front_kot_bot_item_void();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        item_void.setFront_voidid(0);
        item_void.setKotno(voidDTO.getKotNo());
        item_void.setUserid(voidDTO.getUserId());
        item_void.setResturentid(voidDTO.getRestaurantId());
        item_void.setItemno(voidDTO.getItemNo());
        item_void.setQty(voidDTO.getQty());
        item_void.setVoidno(voidDTO.getVoidNo());
        item_void.setSystemdate(date);
        front_kot_bot_itemVoid_repository.save(item_void);
        return 1;
    }
}
