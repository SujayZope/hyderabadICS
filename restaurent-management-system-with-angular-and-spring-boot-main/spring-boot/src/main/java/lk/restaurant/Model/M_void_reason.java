package lk.restaurant.Model;

import javax.persistence.*;

@Entity
@Table(name = "m_void_reason")
public class M_void_reason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkno;
    private String Reason;

    public Integer getPkno() {
        return pkno;
    }

    public void setPkno(Integer pkno) {
        this.pkno = pkno;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }
}
