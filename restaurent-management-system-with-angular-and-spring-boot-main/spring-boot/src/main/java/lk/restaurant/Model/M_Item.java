package lk.restaurant.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "m_item")
public class M_Item {

    @Id
    private Integer item_code;
    private Integer familyGno;
    private String item_name;
    private Double roundprice;
    private Double txtwithtax;
    private Integer taxCalssid;
    private Double cost;

    public Integer getItem_code() {
        return item_code;
    }

    public void setItem_code(Integer item_code) {
        this.item_code = item_code;
    }

    public Integer getFamilyGno() {
        return familyGno;
    }

    public void setFamilyGno(Integer familyGno) {
        this.familyGno = familyGno;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public Double getRoundprice() {
        return roundprice;
    }

    public void setRoundprice(Double roundprice) {
        this.roundprice = roundprice;
    }

    public Double getTxtwithtax() {
        return txtwithtax;
    }

    public void setTxtwithtax(Double txtwithtax) {
        this.txtwithtax = txtwithtax;
    }

    public Integer getTaxCalssid() {
        return taxCalssid;
    }

    public void setTaxCalssid(Integer taxCalssid) {
        this.taxCalssid = taxCalssid;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
