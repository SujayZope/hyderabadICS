package lk.restaurant.Builder;

import lk.ites.HotelPOS.DTO.*;
import lk.ites.HotelPOS.Model.*;
import lk.restaurant.DTO.*;
import lk.restaurant.Model.*;
import org.springframework.stereotype.Component;

@Component
public class DtoBulder {

    public RestaurantTablesDTO buildRestaurantTables(Config_restaurant_room_table restaurantTable){

        if (restaurantTable==null){
            return null;
        }

        RestaurantTablesDTO tablesDTO=new RestaurantTablesDTO();
        tablesDTO.setTableId(restaurantTable.getTable_id());
        tablesDTO.setTableName("Table Name");
        tablesDTO.setRoomId(restaurantTable.getRoom_id());
        return tablesDTO;
    }

    public Front_kot_bot_mainDTO buildOrderTablesEntity(Front_kot_bot_main front_kot_bot_main){
        if (front_kot_bot_main==null){
            return null;
        }

        Front_kot_bot_mainDTO botMainDTO=new Front_kot_bot_mainDTO();
        botMainDTO.setTableId(front_kot_bot_main.getTableno());
        botMainDTO.setRoomId(front_kot_bot_main.getResroom());
        return botMainDTO;
    }

    public Front_kot_bot_mainDTO buildGetKotEntity(Front_kot_bot_main front_kot_bot_main){
        if(front_kot_bot_main==null){
            return null;
        }

        Front_kot_bot_mainDTO bot_main=new Front_kot_bot_mainDTO();
        bot_main.setKotNo(front_kot_bot_main.getKotNo());

        return bot_main;
    }

    public QueryDTO buildItemsQuery(ItemsQueryEntity itemsQueryEntity){
        if (itemsQueryEntity==null){
            return null;
        }

        QueryDTO queryDTO=new QueryDTO();
        queryDTO.setKot(itemsQueryEntity.getKot());
        queryDTO.setItemNo(itemsQueryEntity.getItemNo());
        queryDTO.setItemCode(itemsQueryEntity.getItemCode());
        queryDTO.setQty(itemsQueryEntity.getQty());
        queryDTO.setPrice(itemsQueryEntity.getPrice());
        queryDTO.setPriceWithTax(itemsQueryEntity.getPriceWithTax());
        queryDTO.setItemName(itemsQueryEntity.getItemName());
        queryDTO.setUserName(itemsQueryEntity.getUserName());
        queryDTO.setRate(itemsQueryEntity.getRate());
        queryDTO.setFamilyId(itemsQueryEntity.getFamilyId());
        queryDTO.setDisPercentage(itemsQueryEntity.getDisPercentage());
        
        return queryDTO;
    }

    public AddedDiscountDTO buildDiscountQuery(ItemsQueryEntity itemsQueryEntity){
        if (itemsQueryEntity==null){
            return null;
        }

        AddedDiscountDTO queryDTO=new AddedDiscountDTO();
        queryDTO.setfId(itemsQueryEntity.getFamilyId());
        queryDTO.setPercentage(itemsQueryEntity.getDisPercentage());
        queryDTO.setDisType(itemsQueryEntity.getDisType());
        return queryDTO;
    }

    public RestaurantDTO buildRestaurants(M_Restaurant restaurants) {
        if (restaurants==null){
            return null;
        }

        RestaurantDTO restaurantDTO=new RestaurantDTO();
        restaurantDTO.setRestaurantId(restaurants.getRestrauntId());
        restaurantDTO.setrName(restaurants.getR_name());
        return restaurantDTO;
    }

    public ConfigDiscountDTO buildDiscount(Config_Discount config_discount){
        if(config_discount==null){
            return null;
        }

        ConfigDiscountDTO configDiscountDTO=new ConfigDiscountDTO();
        configDiscountDTO.setDisNo(config_discount.getDisno());
        configDiscountDTO.setFamilyNo(config_discount.getFamilyno());
        configDiscountDTO.setDisPosName(config_discount.getDisposname());
        configDiscountDTO.setDisType(config_discount.getDistype());
        configDiscountDTO.setDisPercentage(config_discount.getDispercentage());
        configDiscountDTO.setDisValue(config_discount.getDisvalue());
        configDiscountDTO.setIsFamily(config_discount.getIsfamily());


        return configDiscountDTO;
    }

    public M_Restaurant_RoomsDTO buildResRooms(M_Restaurant_Room restaurantRoom){
        if(restaurantRoom==null){
            return null;
        }

        M_Restaurant_RoomsDTO roomsDTO=new M_Restaurant_RoomsDTO();
        roomsDTO.setId(restaurantRoom.getrNo());
        roomsDTO.setName(restaurantRoom.getrName());

        return roomsDTO;
    }

    public Item_GroupDTO buildMItemQuery(M_ItemEntity m_itemEntity){
        if (m_itemEntity ==null){
            return null;
        }


        Item_GroupDTO item_groupDTO = new Item_GroupDTO();
        item_groupDTO.setIid(m_itemEntity.getItem_code());
        item_groupDTO.setName(m_itemEntity.getItem_name());
        item_groupDTO.setPrice(m_itemEntity.getRoundprice());
        item_groupDTO.setTaxPrice(m_itemEntity.getRoundprice());
        item_groupDTO.setBarCode(m_itemEntity.getBarCode());
        item_groupDTO.setUberPickmePrice(m_itemEntity.getUberPickmePrice());



        return item_groupDTO;

    }




}
