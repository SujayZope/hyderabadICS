package lk.restaurant.Repository.Custom;

import lk.restaurant.Model.Front_kot_item_temp;

import java.sql.ResultSet;

public interface Front_kot_item_temp_Custom {

    boolean saveTemp(Front_kot_item_temp temp)throws Exception;

    boolean updateItemTemp(Front_kot_item_temp temp)throws Exception;

    boolean deleteItemTemp(Integer kot,Integer itemCode)throws Exception;

    ResultSet getRateForPickMeAndUber()throws Exception;

    ResultSet getLastOrderDetails(Integer integer)throws Exception;
}
