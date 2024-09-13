package lk.restaurant.Model;

import javax.persistence.*;

@Entity
@Table(name = "m_group_family")
public class M_Group_Family {

    @Id
    private Integer F_no;
    private Integer F_M_no;
    private String F_name;

    public Integer getF_no() {
        return F_no;
    }

    public void setF_no(Integer f_no) {
        F_no = f_no;
    }

    public Integer getF_M_no() {
        return F_M_no;
    }

    public void setF_M_no(Integer f_M_no) {
        F_M_no = f_M_no;
    }

    public String getF_name() {
        return F_name;
    }

    public void setF_name(String f_name) {
        F_name = f_name;
    }
}
