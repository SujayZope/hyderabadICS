package lk.restaurant.Model;

import javax.persistence.*;

@Entity
@Table(name = "config_restaurant_room_table")
public class Config_restaurant_room_table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer configid;
    Integer Restrauntid;
    Integer Room_id;
    Integer table_id;

    public Integer getConfigid() {
        return configid;
    }

    public void setConfigid(Integer configid) {
        this.configid = configid;
    }

    public Integer getRestrauntid() {
        return Restrauntid;
    }

    public void setRestrauntid(Integer restrauntid) {
        Restrauntid = restrauntid;
    }

    public Integer getRoom_id() {
        return Room_id;
    }

    public void setRoom_id(Integer room_id) {
        Room_id = room_id;
    }

    public Integer getTable_id() {
        return table_id;
    }

    public void setTable_id(Integer table_id) {
        this.table_id = table_id;
    }
}
