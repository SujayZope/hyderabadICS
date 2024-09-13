package lk.restaurant.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = " front_posguest")
public class Front_posguest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer posguestNo;
    private Integer table_no;
    private Integer waiter_no;
    private String first_name;
    private String last_name;
    private Integer adult;
    private Integer children;
    private Date tabledate;
    private String remrk;
    private Integer states;
    private Date Systemdate;
    private Date strart_time;
    private Date end_time;
    private String Transactionno;
    private Integer istax;
    private String Roomno;
    private Integer Confno;
    private Integer mealcheck;
    private Integer mealno;
    private Integer walkingguest;
    private Integer minibar;
    private Integer Guest_states;
    private Integer House_no;
    private String Package;

    public Integer getPosguestNo() {
        return posguestNo;
    }

    public void setPosguestNo(Integer posguestNo) {
        this.posguestNo = posguestNo;
    }

    public Integer getTable_no() {
        return table_no;
    }

    public void setTable_no(Integer table_no) {
        this.table_no = table_no;
    }

    public Integer getWaiter_no() {
        return waiter_no;
    }

    public void setWaiter_no(Integer waiter_no) {
        this.waiter_no = waiter_no;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Integer getAdult() {
        return adult;
    }

    public void setAdult(Integer adult) {
        this.adult = adult;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Date getTabledate() {
        return tabledate;
    }

    public void setTabledate(Date tabledate) {
        this.tabledate = tabledate;
    }

    public String getRemrk() {
        return remrk;
    }

    public void setRemrk(String remrk) {
        this.remrk = remrk;
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }

    public Date getSystemdate() {
        return Systemdate;
    }

    public void setSystemdate(Date systemdate) {
        Systemdate = systemdate;
    }

    public Date getStrart_time() {
        return strart_time;
    }

    public void setStrart_time(Date strart_time) {
        this.strart_time = strart_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getTransactionno() {
        return Transactionno;
    }

    public void setTransactionno(String transactionno) {
        Transactionno = transactionno;
    }

    public Integer getIstax() {
        return istax;
    }

    public void setIstax(Integer istax) {
        this.istax = istax;
    }

    public String getRoomno() {
        return Roomno;
    }

    public void setRoomno(String roomno) {
        Roomno = roomno;
    }

    public Integer getConfno() {
        return Confno;
    }

    public void setConfno(Integer confno) {
        Confno = confno;
    }

    public Integer getMealcheck() {
        return mealcheck;
    }

    public void setMealcheck(Integer mealcheck) {
        this.mealcheck = mealcheck;
    }

    public Integer getMealno() {
        return mealno;
    }

    public void setMealno(Integer mealno) {
        this.mealno = mealno;
    }

    public Integer getWalkingguest() {
        return walkingguest;
    }

    public void setWalkingguest(Integer walkingguest) {
        this.walkingguest = walkingguest;
    }

    public Integer getMinibar() {
        return minibar;
    }

    public void setMinibar(Integer minibar) {
        this.minibar = minibar;
    }

    public Integer getGuest_states() {
        return Guest_states;
    }

    public void setGuest_states(Integer guest_states) {
        Guest_states = guest_states;
    }

    public Integer getHouse_no() {
        return House_no;
    }

    public void setHouse_no(Integer house_no) {
        House_no = house_no;
    }

    public String getPackage() {
        return Package;
    }

    public void setPackage(String aPackage) {
        Package = aPackage;
    }
}
