package lk.restaurant.DTO;

public class M_void_reasonDTO {

    private Integer pkNo;
    private String Reason;

    public M_void_reasonDTO(Integer pkNo, String reason) {
        this.pkNo = pkNo;
        Reason = reason;
    }

    public Integer getPkNo() {
        return pkNo;
    }

    public void setPkno(Integer pkNo) {
        this.pkNo = pkNo;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }
}
