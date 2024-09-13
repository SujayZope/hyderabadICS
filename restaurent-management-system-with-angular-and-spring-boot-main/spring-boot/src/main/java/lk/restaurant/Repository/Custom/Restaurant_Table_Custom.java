package lk.restaurant.Repository.Custom;

import lk.restaurant.Model.M_Restaurant_Table;

import java.util.List;

public interface Restaurant_Table_Custom {

    List<M_Restaurant_Table> getAllTables(Integer id);
}
