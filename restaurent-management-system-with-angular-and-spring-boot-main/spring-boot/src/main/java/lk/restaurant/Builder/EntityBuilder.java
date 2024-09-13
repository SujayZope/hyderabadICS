package lk.restaurant.Builder;

import lk.restaurant.DTO.Front_kot_bot_itemDTO;
import lk.restaurant.DTO.Front_kot_bot_mainDTO;
import lk.restaurant.Model.Front_kot_bot_item;
import lk.restaurant.Model.Front_kot_bot_main;
import org.springframework.stereotype.Component;

@Component
public class EntityBuilder {

    public Front_kot_bot_item build_Front_kot_bot_item(Front_kot_bot_item botItem, Front_kot_bot_itemDTO botItemDTO){
        if (botItemDTO == null) {
            return null;
        }

        return botItem;
    }

    public Front_kot_bot_main buildCloseTableEntity(Front_kot_bot_main bot_main, Front_kot_bot_mainDTO kot){
        if(kot==null){
            return null;
        }

        if(kot.getKotNo()!=null){
            System.out.println("UPDATE");
            bot_main.setKotNo(kot.getKotNo());
            bot_main.setOpen_in_table(0);
        }
        return bot_main;
    }
}
