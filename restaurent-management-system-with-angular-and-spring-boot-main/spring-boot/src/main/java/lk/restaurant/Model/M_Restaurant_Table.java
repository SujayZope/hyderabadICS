package lk.restaurant.Model;

import javax.persistence.*;

@Entity
@Table(name = "m_restaurant_table")
public class M_Restaurant_Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Table_id;
    private Integer ResturentId;
    private String Table_name;

    public Integer getTable_id() {
        return Table_id;
    }

    public void setTable_id(Integer table_id) {
        Table_id = table_id;
    }

    public Integer getResturentId() {
        return ResturentId;
    }

    public void setResturentId(Integer resturentId) {
        ResturentId = resturentId;
    }

    public String getTable_name() {
        return Table_name;
    }

    public void setTable_name(String table_name) {
        Table_name = table_name;
    }
}
