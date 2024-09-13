package lk.restaurant.DTO;

public class RoomsDTO {

    private String fName;
    private String lName;
    private int guestNo;
    private int confNo;
    private int guestStatus;
    private String roomNo;
    private int noAdult;
    private int isTax;
    private String pakage;
    private int resNo;
    private int noChild;
    private int exBedAdult;
    private String marketCate;

    public RoomsDTO(String fName, String lName, int guestNo, int confNo, int guestStatus, String roomNo, int noAdult, int isTax, String pakage, int resNo, int noChild, int exBedAdult, String marketCate) {
        this.fName = fName;
        this.lName = lName;
        this.guestNo = guestNo;
        this.confNo = confNo;
        this.guestStatus = guestStatus;
        this.roomNo = roomNo;
        this.noAdult = noAdult;
        this.isTax = isTax;
        this.pakage = pakage;
        this.resNo = resNo;
        this.noChild = noChild;
        this.exBedAdult = exBedAdult;
        this.marketCate = marketCate;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getGuestNo() {
        return guestNo;
    }

    public void setGuestNo(int guestNo) {
        this.guestNo = guestNo;
    }

    public int getConfNo() {
        return confNo;
    }

    public void setConfNo(int confNo) {
        this.confNo = confNo;
    }

    public int getGuestStatus() {
        return guestStatus;
    }

    public void setGuestStatus(int guestStatus) {
        this.guestStatus = guestStatus;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getNoAdult() {
        return noAdult;
    }

    public void setNoAdult(int noAdult) {
        this.noAdult = noAdult;
    }

    public int getIsTax() {
        return isTax;
    }

    public void setIsTax(int isTax) {
        this.isTax = isTax;
    }

    public String getPakage() {
        return pakage;
    }

    public void setPakage(String pakage) {
        this.pakage = pakage;
    }

    public int getResNo() {
        return resNo;
    }

    public void setResNo(int resNo) {
        this.resNo = resNo;
    }

    public int getNoChild() {
        return noChild;
    }

    public void setNoChild(int noChild) {
        this.noChild = noChild;
    }

    public int getExBedAdult() {
        return exBedAdult;
    }

    public void setExBedAdult(int exBedAdult) {
        this.exBedAdult = exBedAdult;
    }

    public String getMarketCate() {
        return marketCate;
    }

    public void setMarketCate(String marketCate) {
        this.marketCate = marketCate;
    }
}
