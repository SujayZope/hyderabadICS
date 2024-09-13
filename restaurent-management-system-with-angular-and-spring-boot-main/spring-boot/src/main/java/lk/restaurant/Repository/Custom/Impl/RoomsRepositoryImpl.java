package lk.restaurant.Repository.Custom.Impl;

import lk.restaurant.DBConnection.ReservationStatement;
import lk.restaurant.Model.Rooms;
import lk.restaurant.Repository.RoomsRepository;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public  class RoomsRepositoryImpl implements RoomsRepository {


    @Override
    public List<Rooms> getAll() throws Exception {
        ResultSet rst= ReservationStatement.executeQuery("SELECT F_Name,L_Name,guest.Guest_No,Conf_No,GuestStatus," +
                "RoomNo,No_of_adults,isTax,Package,resevation_No,No_of_children,ExtraBed_Adults,Market_Category " +
                "FROM reservation_conf,reservation_temp,guest WHERE reservation_conf.resevation_No=reservation_temp.ReservationNo " +
                "AND reservation_conf.Guest_No=guest.Guest_No AND reservation_conf.GuestStatus='1' AND RoomNo LIKE '%' ORDER BY RoomNo");
        List<Rooms>result=new ArrayList<>();

        while(rst.next()){


            result.add(new Rooms(rst.getString(1),rst.getString(2),
                    rst.getInt(3),rst.getInt(4),rst.getInt(5),
                    rst.getString(6),rst.getInt(7),rst.getInt(8),
                    rst.getString(9),rst.getInt(10),rst.getInt(11),
                    rst.getInt(12),rst.getString(13)));

        }

        return result;
    }
}
