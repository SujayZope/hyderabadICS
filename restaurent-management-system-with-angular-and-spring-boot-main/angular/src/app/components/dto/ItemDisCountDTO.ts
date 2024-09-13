import {ItemGroupDTO} from './Item_GroupDTO';

export class ItemDisCountDTO {

  fNo: number;
  ItemGroupDTO: ItemGroupDTO;

  constructor(MainItemIDForDiscount: number, foods: ItemGroupDTO) {
    this.fNo = MainItemIDForDiscount;
    this.ItemGroupDTO = foods;
  }
}
