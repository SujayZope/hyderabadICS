package lk.restaurant.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "front_payment")
public class Front_Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer PaymentId;
    Integer PaymentType;
    Date Paymentdate;
    Double PaymentAmount;
    Integer Kot_No;
    Integer stat;
    Integer Void;
    Integer userid;
    String Accountno;
    Integer Discountno;
    Integer Resturentid;
    Integer revenuetype;
    Integer Itemno;
    Integer fromPms;
    Integer subBillno;
    Integer discountType;
    Integer fbsId;


    public Integer getPaymentId() {
        return PaymentId;
    }

    public void setPaymentId(Integer paymentId) {
        PaymentId = paymentId;
    }

    public Integer getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(Integer paymentType) {
        PaymentType = paymentType;
    }

    public Date getPaymentdate() {
        return Paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        Paymentdate = paymentdate;
    }

    public Double getPaymentAmount() {
        return PaymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        PaymentAmount = paymentAmount;
    }

    public Integer getKot_No() {
        return Kot_No;
    }

    public void setKot_No(Integer kot_No) {
        Kot_No = kot_No;
    }

    public Integer getStat() {
        return stat;
    }

    public void setStat(Integer stat) {
        this.stat = stat;
    }

    public Integer getVoid() {
        return Void;
    }

    public void setVoid(Integer aVoid) {
        Void = aVoid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getAccountno() {
        return Accountno;
    }

    public void setAccountno(String accountno) {
        Accountno = accountno;
    }

    public Integer getDiscountno() {
        return Discountno;
    }

    public void setDiscountno(Integer discountno) {
        Discountno = discountno;
    }

    public Integer getResturentid() {
        return Resturentid;
    }

    public void setResturentid(Integer resturentid) {
        Resturentid = resturentid;
    }

    public Integer getRevenuetype() {
        return revenuetype;
    }

    public void setRevenuetype(Integer revenuetype) {
        this.revenuetype = revenuetype;
    }

    public Integer getItemno() {
        return Itemno;
    }

    public void setItemno(Integer itemno) {
        Itemno = itemno;
    }

    public Integer getFromPms() {
        return fromPms;
    }

    public void setFromPms(Integer fromPms) {
        this.fromPms = fromPms;
    }

    public Integer getSubBillno() {
        return subBillno;
    }

    public void setSubBillno(Integer subBillno) {
        this.subBillno = subBillno;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public Integer getFbsId() {
        return fbsId;
    }

    public void setFbsId(Integer fbsId) {
        this.fbsId = fbsId;
    }
}
