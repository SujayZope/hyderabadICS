package lk.restaurant.DTO;

public class Family_GroupDTO {

    private Integer fNo;
    private Integer fmNo;
    private String fName;

    public Family_GroupDTO(Integer fNo,Integer fmNo, String fName) {
        this.fNo = fNo;
        this.fmNo=fmNo;
        this.fName = fName;
    }

    public Integer getfNo() {
        return fNo;
    }

    public void setfNo(Integer fNo) {
        this.fNo = fNo;
    }

    public Integer getFmNo() {
        return fmNo;
    }

    public void setFmNo(Integer fmNo) {
        this.fmNo = fmNo;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
}
