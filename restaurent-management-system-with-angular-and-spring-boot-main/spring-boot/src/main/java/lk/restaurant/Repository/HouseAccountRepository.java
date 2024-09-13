package lk.restaurant.Repository;

import lk.restaurant.Model.House_Account;

import java.util.List;

public interface HouseAccountRepository {

    List<House_Account>getAll()throws Exception;
}
