package lk.restaurant.Exception;

public class ApiRuleViolationException extends RuntimeException {
    private int  code;

    private String message;

    public ApiRuleViolationException(){
        super("massage");

    }

    public ApiRuleViolationException(String message) {
        super(message);

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
