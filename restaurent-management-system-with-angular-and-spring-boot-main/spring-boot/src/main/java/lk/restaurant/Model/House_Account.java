package lk.restaurant.Model;

public class House_Account {

    private Integer h_account_id;
    private String Account_number;
    private String Employee_name;

    public House_Account(Integer h_account_id, String account_number, String employee_name) {
        this.h_account_id = h_account_id;
        Account_number = account_number;
        Employee_name = employee_name;
    }

    public Integer getH_account_id() {
        return h_account_id;
    }

    public void setH_account_id(Integer h_account_id) {
        this.h_account_id = h_account_id;
    }

    public String getAccount_number() {
        return Account_number;
    }

    public void setAccount_number(String account_number) {
        Account_number = account_number;
    }

    public String getEmployee_name() {
        return Employee_name;
    }

    public void setEmployee_name(String employee_name) {
        Employee_name = employee_name;
    }
}
