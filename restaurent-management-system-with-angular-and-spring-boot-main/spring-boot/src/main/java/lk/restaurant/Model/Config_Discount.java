package lk.restaurant.Model;

import javax.persistence.*;

@Entity
@Table(name = "config_discount")
public class Config_Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer disno;
    private Integer familyno;
    private String disposname;
    private String disbillname;
    private Integer distype;
    private Double dispercentage;
    private Double disvalue;
    private String accountno;
    private Integer isfamily;

    public Integer getDisno() {
        return disno;
    }

    public void setDisno(Integer disno) {
        this.disno = disno;
    }

    public Integer getFamilyno() {
        return familyno;
    }

    public void setFamilyno(Integer familyno) {
        this.familyno = familyno;
    }

    public String getDisposname() {
        return disposname;
    }

    public void setDisposname(String disposname) {
        this.disposname = disposname;
    }

    public String getDisbillname() {
        return disbillname;
    }

    public void setDisbillname(String disbillname) {
        this.disbillname = disbillname;
    }

    public Integer getDistype() {
        return distype;
    }

    public void setDistype(Integer distype) {
        this.distype = distype;
    }

    public Double getDispercentage() {
        return dispercentage;
    }

    public void setDispercentage(Double dispercentage) {
        this.dispercentage = dispercentage;
    }

    public Double getDisvalue() {
        return disvalue;
    }

    public void setDisvalue(Double disvalue) {
        this.disvalue = disvalue;
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }

    public Integer getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(Integer isfamily) {
        this.isfamily = isfamily;
    }
}
