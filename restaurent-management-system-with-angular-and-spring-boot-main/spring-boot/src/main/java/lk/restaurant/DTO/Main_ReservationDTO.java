package lk.restaurant.DTO;

import java.util.List;

public class Main_ReservationDTO {

    private Front_pos_guestDTO frontPosGuestDTO;
    private Front_kot_bot_mainDTO frontKotBotMainDTO;
    private List<Front_kot_bot_itemDTO> frontKotBotItemDTO;

    public Front_pos_guestDTO getFrontPosGuestDTO() {
        return frontPosGuestDTO;
    }

    public void setFrontPosGuestDTO(Front_pos_guestDTO frontPosGuestDTO) {
        this.frontPosGuestDTO = frontPosGuestDTO;
    }

    public Front_kot_bot_mainDTO getFrontKotBotMainDTO() {
        return frontKotBotMainDTO;
    }

    public void setFrontKotBotMainDTO(Front_kot_bot_mainDTO frontKotBotMainDTO) {
        this.frontKotBotMainDTO = frontKotBotMainDTO;
    }

    public List<Front_kot_bot_itemDTO> getFrontKotBotItemDTO() {
        return frontKotBotItemDTO;
    }

    public void setFrontKotBotItemDTO(List<Front_kot_bot_itemDTO> frontKotBotItemDTO) {
        this.frontKotBotItemDTO = frontKotBotItemDTO;
    }

}
