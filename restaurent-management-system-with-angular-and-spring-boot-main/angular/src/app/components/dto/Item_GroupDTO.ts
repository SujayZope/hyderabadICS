 export class ItemGroupDTO{

  public iid: number;
   public getIid(): number {
     return this.iid;
   }
   public setIid(value: number) {
     this.iid = value;
   }
   public name: string;
   public getName(): string {
     return this.name;
   }
   public setName(value: string) {
     this.name = value;
   }
   public price: number;
   public getPrice(): number {
     return this.price;
   }
   public setPrice(value: number) {
     this.price = value;
   }
   public taxPrice: number;
   public getTaxPrice(): number {
     return this.taxPrice;
   }
   public setTaxPrice(value: number) {
     this.taxPrice = value;
   }

   public barCode:string;
   public getbarCode(): string {
     return this.barCode;
   }

   public setbarCode(value: string) {
     this.barCode = value;
   }
   private _uberPickmePrice:number;

   get uberPickmePrice(): number {
     return this._uberPickmePrice;
   }

   set uberPickmePrice(value: number) {
     this._uberPickmePrice = value;
   }

   constructor(){

}


 }





