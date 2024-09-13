package lk.restaurant.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "front_kot_bot_item_void")
public class Front_kot_bot_item_void {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Front_voidid;
    private Integer Kotno;
    private Integer Userid;
    private Integer Resturentid;
    private Integer Itemno;
    private Integer Qty;
    private Integer Voidno;
    private Date Systemdate;

    public Integer getFront_voidid() {
        return Front_voidid;
    }

    public void setFront_voidid(Integer front_voidid) {
        Front_voidid = front_voidid;
    }

    public Integer getKotno() {
        return Kotno;
    }

    public void setKotno(Integer kotno) {
        Kotno = kotno;
    }

    public Integer getUserid() {
        return Userid;
    }

    public void setUserid(Integer userid) {
        Userid = userid;
    }

    public Integer getResturentid() {
        return Resturentid;
    }

    public void setResturentid(Integer resturentid) {
        Resturentid = resturentid;
    }

    public Integer getItemno() {
        return Itemno;
    }

    public void setItemno(Integer itemno) {
        Itemno = itemno;
    }

    public Integer getQty() {
        return Qty;
    }

    public void setQty(Integer qty) {
        Qty = qty;
    }

    public Integer getVoidno() {
        return Voidno;
    }

    public void setVoidno(Integer voidno) {
        Voidno = voidno;
    }

    public Date getSystemdate() {
        return Systemdate;
    }

    public void setSystemdate(Date systemdate) {
        Systemdate = systemdate;
    }
}
