package lk.restaurant.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_group_master")
public class M_Group_Master {

    @Id
    private Integer Master_no;
    private Integer Master_m_no;
    private Integer Master_f_no;
    private String Master_name;

    public Integer getMaster_no() {
        return Master_no;
    }

    public void setMaster_no(Integer master_no) {
        Master_no = master_no;
    }

    public Integer getMaster_m_no() {
        return Master_m_no;
    }

    public void setMaster_m_no(Integer master_m_no) {
        Master_m_no = master_m_no;
    }

    public Integer getMaster_f_no() {
        return Master_f_no;
    }

    public void setMaster_f_no(Integer master_f_no) {
        Master_f_no = master_f_no;
    }

    public String getMaster_name() {
        return Master_name;
    }

    public void setMaster_name(String master_name) {
        Master_name = master_name;
    }
}
