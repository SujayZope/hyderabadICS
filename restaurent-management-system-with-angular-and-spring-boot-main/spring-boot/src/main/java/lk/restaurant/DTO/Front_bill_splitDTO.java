package lk.restaurant.DTO;

import java.sql.Date;

public class Front_bill_splitDTO {

    private Integer fbs_id;
    private Integer kot_no;
    private String bill_no;
    private Date bill_time;
    private Integer int_bill_no;
    private Integer ispaid;
    private Integer payment_id;
    private String Room_no;

    public Integer getFbs_id() {
        return fbs_id;
    }

    public void setFbs_id(Integer fbs_id) {
        this.fbs_id = fbs_id;
    }

    public Integer getKot_no() {
        return kot_no;
    }

    public void setKot_no(Integer kot_no) {
        this.kot_no = kot_no;
    }

    public String getBill_no() {
        return bill_no;
    }

    public void setBill_no(String bill_no) {
        this.bill_no = bill_no;
    }

    public Date getBill_time() {
        return bill_time;
    }

    public void setBill_time(Date bill_time) {
        this.bill_time = bill_time;
    }

    public Integer getInt_bill_no() {
        return int_bill_no;
    }

    public void setInt_bill_no(Integer int_bill_no) {
        this.int_bill_no = int_bill_no;
    }

    public Integer getIspaid() {
        return ispaid;
    }

    public void setIspaid(Integer ispaid) {
        this.ispaid = ispaid;
    }

    public Integer getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Integer payment_id) {
        this.payment_id = payment_id;
    }

    public String getRoom_no() {
        return Room_no;
    }

    public void setRoom_no(String room_no) {
        Room_no = room_no;
    }
}
