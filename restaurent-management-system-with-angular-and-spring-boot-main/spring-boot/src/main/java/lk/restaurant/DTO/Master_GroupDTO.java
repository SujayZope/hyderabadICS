package lk.restaurant.DTO;

public class Master_GroupDTO {

    private Integer maNo;
    private Integer mfNo;
    private Integer mNo;
    private String name;

    public Master_GroupDTO(Integer maNo, Integer mfNo, Integer mNo, String name) {
        this.maNo = maNo;
        this.mfNo = mfNo;
        this.mNo = mNo;
        this.name = name;
    }

    public Integer getMaNo() {
        return maNo;
    }

    public void setMaNo(Integer maNo) {
        this.maNo = maNo;
    }

    public Integer getMfNo() {
        return mfNo;
    }

    public void setMfNo(Integer mfNo) {
        this.mfNo = mfNo;
    }

    public Integer getmNo() {
        return mNo;
    }

    public void setmNo(Integer mNo) {
        this.mNo = mNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
