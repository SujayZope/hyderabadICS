package lk.restaurant.DTO;

import java.sql.Date;

public class Consolidate_detailDTO {
    private Integer id;
    private Integer Kot_no;
    private String rst_name;
    private String F_name;
    private Date payment_date;
    private Integer item_no;
    private Integer item_code;
    private Integer qty;
    private Double unit_prices;
    private Double ttlvalue;
    private Integer family_gno;
    private Double service_charge;
    private Double tax;
    private Double item_discount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKot_no() {
        return Kot_no;
    }

    public void setKot_no(Integer kot_no) {
        Kot_no = kot_no;
    }

    public String getRst_name() {
        return rst_name;
    }

    public void setRst_name(String rst_name) {
        this.rst_name = rst_name;
    }

    public String getF_name() {
        return F_name;
    }

    public void setF_name(String f_name) {
        F_name = f_name;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public Integer getItem_no() {
        return item_no;
    }

    public void setItem_no(Integer item_no) {
        this.item_no = item_no;
    }

    public Integer getItem_code() {
        return item_code;
    }

    public void setItem_code(Integer item_code) {
        this.item_code = item_code;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getUnit_prices() {
        return unit_prices;
    }

    public void setUnit_prices(Double unit_prices) {
        this.unit_prices = unit_prices;
    }

    public Double getTtlvalue() {
        return ttlvalue;
    }

    public void setTtlvalue(Double ttlvalue) {
        this.ttlvalue = ttlvalue;
    }

    public Integer getFamily_gno() {
        return family_gno;
    }

    public void setFamily_gno(Integer family_gno) {
        this.family_gno = family_gno;
    }

    public Double getService_charge() {
        return service_charge;
    }

    public void setService_charge(Double service_charge) {
        this.service_charge = service_charge;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getItem_discount() {
        return item_discount;
    }

    public void setItem_discount(Double item_discount) {
        this.item_discount = item_discount;
    }
}
