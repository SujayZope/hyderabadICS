package lk.restaurant.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_restaurant")
public class M_Restaurant {

    @Id
    private Integer restrauntId;
    private String r_location;
    private String r_name;
    private Integer TableC;

    public Integer getRestrauntId() {
        return restrauntId;
    }

    public void setRestrauntId(Integer restrauntId) {
        this.restrauntId = restrauntId;
    }

    public String getR_location() {
        return r_location;
    }

    public void setR_location(String r_location) {
        this.r_location = r_location;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public Integer getTableC() {
        return TableC;
    }

    public void setTableC(Integer tableC) {
        TableC = tableC;
    }
}
