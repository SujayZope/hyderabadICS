package lk.restaurant.Model;

import javax.persistence.*;

@Entity
@Table(name = "tax")
public class Tax {

    @Id
    Integer Taxno;
    String Taxname;
    Integer Rate;
    Double taxcalculatevalue;

    public Integer getTaxno() {
        return Taxno;
    }

    public void setTaxno(Integer taxno) {
        Taxno = taxno;
    }

    public String getTaxname() {
        return Taxname;
    }

    public void setTaxname(String taxname) {
        Taxname = taxname;
    }

    public Integer getRate() {
        return Rate;
    }

    public void setRate(Integer rate) {
        Rate = rate;
    }

    public Double getTaxcalculatevalue() {
        return taxcalculatevalue;
    }

    public void setTaxcalculatevalue(Double taxcalculatevalue) {
        this.taxcalculatevalue = taxcalculatevalue;
    }
}
