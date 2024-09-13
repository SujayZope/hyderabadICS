export class MasterGroupDTO {
  mfNo: number;
  mNo: number;
  maNo: number;
  name: string;


  constructor(mfNo: number, mNo: number, maNo: number, name: string) {
    this.mfNo = mfNo;
    this.mNo = mNo;
    this.maNo = maNo;
    this.name = name;
  }
}
