package lk.restaurant.DTO;

public class ManagersDTO {

    private Integer accountId;
    private String accountNumber;
    private String employeeName;

    public ManagersDTO(Integer accountId, String accountNumber, String employeeName) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.employeeName = employeeName;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
