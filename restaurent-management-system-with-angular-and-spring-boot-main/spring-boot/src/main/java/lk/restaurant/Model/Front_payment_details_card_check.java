package lk.restaurant.Model;

import javax.persistence.*;
import java.util.Date;

//@Entity
//@Table(name = "front_payment_details_card_check")
public class Front_payment_details_card_check {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer DetailId;
    Integer PaymentId;
    String Cardcheck_no;
    Date Valid_date;
    String Athorize_no;
    String Account_no;
    String Bank_name;
    Integer mAcCreditcard;

    public Integer getDetailId() {
        return DetailId;
    }

    public void setDetailId(Integer detailId) {
        DetailId = detailId;
    }

    public Integer getPaymentId() {
        return PaymentId;
    }

    public void setPaymentId(Integer paymentId) {
        PaymentId = paymentId;
    }

    public String getCardcheck_no() {
        return Cardcheck_no;
    }

    public void setCardcheck_no(String cardcheck_no) {
        Cardcheck_no = cardcheck_no;
    }

    public Date getValid_date() {
        return Valid_date;
    }

    public void setValid_date(Date valid_date) {
        Valid_date = valid_date;
    }

    public String getAthorize_no() {
        return Athorize_no;
    }

    public void setAthorize_no(String athorize_no) {
        Athorize_no = athorize_no;
    }

    public String getAccount_no() {
        return Account_no;
    }

    public void setAccount_no(String account_no) {
        Account_no = account_no;
    }

    public String getBank_name() {
        return Bank_name;
    }

    public void setBank_name(String bank_name) {
        Bank_name = bank_name;
    }

    public Integer getmAcCreditcard() {
        return mAcCreditcard;
    }

    public void setmAcCreditcard(Integer mAcCreditcard) {
        this.mAcCreditcard = mAcCreditcard;
    }
}
