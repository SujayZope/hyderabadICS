package lk.restaurant.DTO.Commen;

public class ResponsDTO {

    private final Integer id;
    private final int status;
    private final String message;

    public ResponsDTO(Integer id, int status, String message) {
        this.id = id;
        this.status = status;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
