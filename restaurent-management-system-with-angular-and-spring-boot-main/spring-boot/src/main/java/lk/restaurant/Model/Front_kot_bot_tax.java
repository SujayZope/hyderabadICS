package lk.restaurant.Model;

import javax.persistence.*;

@Entity
@Table(name = "front_kot_bot_tax")
public class Front_kot_bot_tax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Kb_taxno;
    private Integer Kb_itemno;
    private Integer Taxno;
    private Double Taxamount;

    public Integer getKb_taxno() {
        return Kb_taxno;
    }

    public void setKb_taxno(Integer kb_taxno) {
        Kb_taxno = kb_taxno;
    }

    public Integer getKb_itemno() {
        return Kb_itemno;
    }

    public void setKb_itemno(Integer kb_itemno) {
        Kb_itemno = kb_itemno;
    }

    public Integer getTaxno() {
        return Taxno;
    }

    public void setTaxno(Integer taxno) {
        Taxno = taxno;
    }

    public Double getTaxamount() {
        return Taxamount;
    }

    public void setTaxamount(Double taxamount) {
        Taxamount = taxamount;
    }
}
