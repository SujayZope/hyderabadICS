package lk.restaurant.Model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "front_kot_bot_main")
public class Front_kot_bot_main {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kotNo;
    private Integer Pos_Guest_no;
    private Integer resturent_id;
    private Integer tableno;
    private String remark;
    private Integer meal_period;
    private Date Currentdate;
    private Integer Userid;
    private Integer state;
    private Integer viewuser;
    private Integer loguserID;
    private String Billno;
    private Integer Intbillno;
    private Integer isenter;
    private Integer resroom;
    private Time print_time;
    private Integer print_user;
    private Integer hassplit;
    private Integer hasmergeId;
    private String merge_bill_no;
    private Integer int_merge_bill_no;
    private Integer open_in_table;
    private Date nightdate;
    @Column(columnDefinition = "int default 0")
    private Integer tableStatus;

    public Integer getKotNo() {
        return kotNo;
    }

    public void setKotNo(Integer kotNo) {
        this.kotNo = kotNo;
    }

    public Integer getPos_Guest_no() {
        return Pos_Guest_no;
    }

    public void setPos_Guest_no(Integer pos_Guest_no) {
        Pos_Guest_no = pos_Guest_no;
    }

    public Integer getResturent_id() {
        return resturent_id;
    }

    public void setResturent_id(Integer resturent_id) {
        this.resturent_id = resturent_id;
    }

    public Integer getTableno() {
        return tableno;
    }

    public void setTableno(Integer tableno) {
        this.tableno = tableno;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getMeal_period() {
        return meal_period;
    }

    public void setMeal_period(Integer meal_period) {
        this.meal_period = meal_period;
    }

    public Date getCurrentdate() {
        return Currentdate;
    }

    public void setCurrentdate(Date currentdate) {
        Currentdate = currentdate;
    }

    public Integer getUserid() {
        return Userid;
    }

    public void setUserid(Integer userid) {
        Userid = userid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getViewuser() {
        return viewuser;
    }

    public void setViewuser(Integer viewuser) {
        this.viewuser = viewuser;
    }

    public Integer getLoguserID() {
        return loguserID;
    }

    public void setLoguserID(Integer loguserID) {
        this.loguserID = loguserID;
    }

    public String getBillno() {
        return Billno;
    }

    public void setBillno(String billno) {
        Billno = billno;
    }

    public Integer getIntbillno() {
        return Intbillno;
    }

    public void setIntbillno(Integer intbillno) {
        Intbillno = intbillno;
    }

    public Integer getIsenter() {
        return isenter;
    }

    public void setIsenter(Integer isenter) {
        this.isenter = isenter;
    }

    public Integer getResroom() {
        return resroom;
    }

    public void setResroom(Integer resroom) {
        this.resroom = resroom;
    }

    public Time getPrint_time() {
        return print_time;
    }

    public void setPrint_time(Time print_time) {
        this.print_time = print_time;
    }

    public Integer getPrint_user() {
        return print_user;
    }

    public void setPrint_user(Integer print_user) {
        this.print_user = print_user;
    }

    public Integer getHassplit() {
        return hassplit;
    }

    public void setHassplit(Integer hassplit) {
        this.hassplit = hassplit;
    }

    public Integer getHasmergeId() {
        return hasmergeId;
    }

    public void setHasmergeId(Integer hasmergeId) {
        this.hasmergeId = hasmergeId;
    }

    public String getMerge_bill_no() {
        return merge_bill_no;
    }

    public void setMerge_bill_no(String merge_bill_no) {
        this.merge_bill_no = merge_bill_no;
    }

    public Integer getInt_merge_bill_no() {
        return int_merge_bill_no;
    }

    public void setInt_merge_bill_no(Integer int_merge_bill_no) {
        this.int_merge_bill_no = int_merge_bill_no;
    }

    public Integer getOpen_in_table() {
        return open_in_table;
    }

    public void setOpen_in_table(Integer open_in_table) {
        this.open_in_table = open_in_table;
    }

    public Date getNightdate() {
        return nightdate;
    }

    public void setNightdate(Date nightdate) {
        this.nightdate = nightdate;
    }

    public Integer getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Integer tableStatus) {
        this.tableStatus = tableStatus;
    }
}
