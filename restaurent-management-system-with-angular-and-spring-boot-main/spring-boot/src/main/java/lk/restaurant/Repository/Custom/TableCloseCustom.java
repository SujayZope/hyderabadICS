package lk.restaurant.Repository.Custom;

import lk.restaurant.Model.Front_kot_bot_main;

import java.util.List;

public interface TableCloseCustom {

    List<Front_kot_bot_main> getAllValues(Integer id);

    List<Front_kot_bot_main> getAllKot(Integer taId,Integer reId);

}
