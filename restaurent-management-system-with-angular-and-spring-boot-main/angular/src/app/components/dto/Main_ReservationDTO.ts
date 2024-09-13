import {FrontKotBotItemDTO} from './Front_kot_bot_itemDTO';
import {FrontKotBotMainDTO} from './Front_kot_bot_mainDTO';
import {FrontPosGuestDTO} from './Front_pos_guestDTO';


export class MainReservationDTO {
  frontKotBotItemDTO: Array<FrontKotBotItemDTO>;
  frontKotBotMainDTO: FrontKotBotMainDTO;
  frontPosGuestDTO: FrontPosGuestDTO;
}
