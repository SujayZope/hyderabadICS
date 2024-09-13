package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.DBConnection.ReservationStatement;
import lk.restaurant.Model.House_Account;
import lk.restaurant.Repository.HouseAccountRepository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HouseAccountRepositoryImpl implements HouseAccountRepository {

    @Override
    public List<House_Account> getAll() throws Exception {
        ResultSet rst= ReservationStatement.executeQuery("SELECT H_Account_ID,Account_No,EmployeeName FROM house_account WHERE Acitve=1");

        List<House_Account>result=new ArrayList<>();
        while(rst.next()){
            result.add(new House_Account(rst.getInt(1),rst.getString(2),rst.getString(3)));
        }
        return result;
    }
}
