package lk.restaurant.DTO;

public class Front_PaymentDTO {



    Integer paymentType;
    Double amount;
    Integer kotNo;
    Integer userId;
    Integer resturentId;
    String accountNo;
    Integer discountNo;
    Integer from_pms;
    Integer sub_billNo;
    Integer discount_type;
    Integer fbs_id;

    public Front_PaymentDTO() {
    }

    public Front_PaymentDTO(Integer paymentType, Double amount, Integer kotNo, Integer userId, Integer resturentId, String accountNo, Integer discountNo, Integer from_pms, Integer sub_billNo, Integer discount_type, Integer fbs_id) {
        this.paymentType = paymentType;
        this.amount = amount;
        this.kotNo = kotNo;
        this.userId = userId;
        this.resturentId = resturentId;
        this.accountNo = accountNo;
        this.discountNo = discountNo;
        this.from_pms = from_pms;
        this.sub_billNo = sub_billNo;
        this.discount_type = discount_type;
        this.fbs_id = fbs_id;
    }


    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getKotNo() {
        return kotNo;
    }

    public void setKotNo(Integer kotNo) {
        this.kotNo = kotNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getResturentId() {
        return resturentId;
    }

    public void setResturentId(Integer resturentId) {
        this.resturentId = resturentId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Integer getDiscountNo() {
        return discountNo;
    }

    public void setDiscountNo(Integer discountNo) {
        this.discountNo = discountNo;
    }

    public Integer getFrom_pms() {
        return from_pms;
    }

    public void setFrom_pms(Integer from_pms) {
        this.from_pms = from_pms;
    }

    public Integer getSub_billNo() {
        return sub_billNo;
    }

    public void setSub_billNo(Integer sub_billNo) {
        this.sub_billNo = sub_billNo;
    }

    public Integer getDiscount_type() {
        return discount_type;
    }

    public void setDiscount_type(Integer discount_type) {
        this.discount_type = discount_type;
    }

    public Integer getFbs_id() {
        return fbs_id;
    }

    public void setFbs_id(Integer fbs_id) {
        this.fbs_id = fbs_id;
    }
}
