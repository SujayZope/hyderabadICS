package lk.restaurant.Model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "front_kot_bot_print_no")
public class Front_kot_bot_print_no {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer printkbid;
    private Date nightdate;
    private Integer kot_no;
    private Integer printerid;
    private Integer printkbno;
    private Time actiontime;
    private Integer User_id;

    public Integer getPrintkbid() {
        return printkbid;
    }

    public void setPrintkbid(Integer printkbid) {
        this.printkbid = printkbid;
    }

    public Date getNightdate() {
        return nightdate;
    }

    public void setNightdate(Date nightdate) {
        this.nightdate = nightdate;
    }

    public Integer getKot_no() {
        return kot_no;
    }

    public void setKot_no(Integer kot_no) {
        this.kot_no = kot_no;
    }

    public Integer getPrinterid() {
        return printerid;
    }

    public void setPrinterid(Integer printerid) {
        this.printerid = printerid;
    }

    public Integer getPrintkbno() {
        return printkbno;
    }

    public void setPrintkbno(Integer printkbno) {
        this.printkbno = printkbno;
    }

    public Time getActiontime() {
        return actiontime;
    }

    public void setActiontime(Time actiontime) {
        this.actiontime = actiontime;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }
}
