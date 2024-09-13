package lk.restaurant.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "m_restaurant_room")
public class M_Restaurant_Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rNo;
    private Integer ResNo;
    private String rName;
    private Integer NoOfTables;
    private Integer User_id;
    private Date Curr_date;
    private String description;

    public Integer getrNo() {
        return rNo;
    }

    public void setrNo(Integer rNo) {
        this.rNo = rNo;
    }

    public Integer getResNo() {
        return ResNo;
    }

    public void setResNo(Integer resNo) {
        ResNo = resNo;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public Integer getNoOfTables() {
        return NoOfTables;
    }

    public void setNoOfTables(Integer noOfTables) {
        NoOfTables = noOfTables;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public Date getCurr_date() {
        return Curr_date;
    }

    public void setCurr_date(Date curr_date) {
        Curr_date = curr_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
