package lk.restaurant.Model;

import javax.persistence.*;

@Entity
@Table(name = "m_item_rate")
public class M_Item_Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Pk_No;
    private Integer Item_No;
    private Integer Rate_No;
    private Double Rate_Value;
    private Double roundprice;
    private Integer taxclass;
    private Integer currencyid;

    public Integer getPk_No() {
        return Pk_No;
    }

    public void setPk_No(Integer pk_No) {
        Pk_No = pk_No;
    }

    public Integer getItem_No() {
        return Item_No;
    }

    public void setItem_No(Integer item_No) {
        Item_No = item_No;
    }

    public Integer getRate_No() {
        return Rate_No;
    }

    public void setRate_No(Integer rate_No) {
        Rate_No = rate_No;
    }

    public Double getRate_Value() {
        return Rate_Value;
    }

    public void setRate_Value(Double rate_Value) {
        Rate_Value = rate_Value;
    }

    public Double getRoundprice() {
        return roundprice;
    }

    public void setRoundprice(Double roundprice) {
        this.roundprice = roundprice;
    }

    public Integer getTaxclass() {
        return taxclass;
    }

    public void setTaxclass(Integer taxclass) {
        this.taxclass = taxclass;
    }

    public Integer getCurrencyid() {
        return currencyid;
    }

    public void setCurrencyid(Integer currencyid) {
        this.currencyid = currencyid;
    }
}
