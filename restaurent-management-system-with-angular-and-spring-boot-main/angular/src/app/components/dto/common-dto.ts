import {ItemGroupDTO} from './Item_GroupDTO';


export class CommonDto {
  adult: number;
  child: number;
  familyId: number;
  item: ItemGroupDTO = new ItemGroupDTO();
  numbersOfItems: number;
  updateStatus: boolean;
}
