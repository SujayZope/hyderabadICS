import {Component, OnInit, HostListener, Inject, ViewChild, ElementRef, ViewChildren} from '@angular/core';
import {FoodItemService} from '../../services/food-item.service';

import {HttpParams} from '@angular/common/http';


import {CommonDto} from '../../dto/common-dto';
import {ActivatedRoute, Router} from '@angular/router';

import {ToastrService} from 'ngx-toastr';
import {GlobalErrorHandler} from '../../errorHandler/GlobalErrorHandler';
import {MVoidReasonDTO} from '../../dto/M_void_reasonDTO';
import {FrontKotBotItemDTO} from '../../dto/Front_kot_bot_itemDTO';
import {ConsolidateDetailDTO} from '../../dto/Consolidate_detailDTO';
import {FamilyGroupDTO} from '../../dto/FamilyGroupDTO';
import {MasterGroupDTO} from '../../dto/Master_GroupDTO';
import {ItemGroupDTO} from '../../dto/Item_GroupDTO';
import {MainReservationDTO} from '../../dto/Main_ReservationDTO';
import {FrontPosGuestDTO} from '../../dto/Front_pos_guestDTO';
import {FrontKotBotMainDTO} from '../../dto/Front_kot_bot_mainDTO';
import {FrontKotBotItemVoidDTO} from '../../dto/Front_kot_bot_item_voidDTO';
import {ItemDisCountDTO} from '../../dto/ItemDisCountDTO';
import {DiscountDTO} from '../../dto/DiscountDTO';
import {AddedDiscountDTO} from '../../dto/AddedDiscountDTO';
import {error, log} from 'util';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
// import { MItemDTO } from '../../dto/MItemDTO';
import {ViewOrderDTO} from '../../dto/ViewOrderDTO';
import {conditionallyCreateMapObjectLiteral} from '@angular/compiler/src/render3/view/util';
import {SearchService} from '../../services/search-searvice';
import * as jspdf from 'jspdf';
import html2canvas from 'html2canvas';
import {BookTablesService} from '../../services/book-tables.service';
import {TempDataDTO} from '../../dto/TempDataDTO';
import {MRestaurantRoomsDTO} from '../../dto/M_Restaurant_RoomsDTO';
import {RestaurantDTO} from '../../dto/RestaurantDTO';
import {ResponsDTO} from '../../dto/ResponsDTO';


// @ts-ignore
// @ts-ignore
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  isMethod: string;
  isVisible = true;
  isVisible2 = false;
  isVisible3 = false;
  isAdded = false;
  printInvoices:boolean;
  numbersOfItems: number;
  totalPrice: number;
  firstCategories: string;
  btnSubmitAndUpdateOrder: string;
  updateButton: boolean;
  private printInvoice: HttpParams;
  isExist: boolean;
  mVoidReasonDTO: MVoidReasonDTO = new MVoidReasonDTO();
  responsDTO:ResponsDTO =new ResponsDTO();
  familyNo: number;
  disPercentage = 0;
  TotalAmount: number;
  frontKotBotList: Array<FrontKotBotItemDTO> = new Array<FrontKotBotItemDTO>();
  frontKotBotDiscountList: Array<FrontKotBotItemDTO> = new Array<FrontKotBotItemDTO>();
  fontKotBotDiscount: FrontKotBotItemDTO = null;
  tempAddedDisDTO: AddedDiscountDTO = null;
  totalPrice2: number;
  consolidateDetailDTOS: Array<ConsolidateDetailDTO> = new Array<ConsolidateDetailDTO>();
  list: Array<FamilyGroupDTO> = new Array<FamilyGroupDTO>();
  MasterList: Array<MasterGroupDTO> = null;
  MasterList02: Array<MasterGroupDTO> = new Array<MasterGroupDTO>();
  KotNumberList: Array<FrontKotBotMainDTO> = new Array<FrontKotBotMainDTO>();
  ItemList: Array<ItemGroupDTO> = new Array<ItemGroupDTO>();
  AllItemList: Array<ItemGroupDTO> = new Array<ItemGroupDTO>();
  ReasonsList: Array<MVoidReasonDTO> = new Array<MVoidReasonDTO>();
  itemQu: Array<CommonDto> = new Array<CommonDto>();
  discountItemList: Array<ItemDisCountDTO> = new Array<ItemDisCountDTO>();
  disList: Array<AddedDiscountDTO> = new Array<AddedDiscountDTO>();
  TempDisCount: Array<AddedDiscountDTO> = new Array<AddedDiscountDTO>();
  TempDisCount2: Array<AddedDiscountDTO> = new Array<AddedDiscountDTO>();
  TempDisCount3: AddedDiscountDTO;
  viewDiscountList: Array<Array<DiscountDTO>>;
  discountNameList = [];
  mainListNumber: Array<number> = new Array<number>(); // this is return for get discount list
  mainItems = [];
  subItems = [];
  items = [];
  uberAndPickmerate: number;
  tempDto: CommonDto = new CommonDto();
  foods: ItemGroupDTO = new ItemGroupDTO();
  btnStatus: string;
  familyID: number;
  MainItemIDForDiscount: number;
  discountPrice = 0;
  taxWithPrice = 0;
  netAmount: number;
  masterGrpDTO: MasterGroupDTO;
  FamilyArray: Array<FamilyGroupDTO> = new Array<FamilyGroupDTO>();
  tempDataDTOArray: Array<TempDataDTO> = new Array<TempDataDTO>();
  MasterArray: Array<MasterGroupDTO> = new Array<MasterGroupDTO>();
  ItemArray: Observable<Array<ItemGroupDTO>> = new Observable<Array<ItemGroupDTO>>();
  ItemArray02: Array<ItemGroupDTO> = new Array<ItemGroupDTO>();
  MItemArray: Array<ItemGroupDTO> = new Array<ItemGroupDTO>();
  searchMItemArray: Array<ItemGroupDTO> = new Array<ItemGroupDTO>();


  selectCardTypePrimary: string;
  selectCardTypeSecondary: string;
  calcSecondaryPayAmount: number;
  primaryPayAmount: number;
  isOkayToPrint: boolean;
  time: any;
  CurrentTime: any;
  view: number;
  firstName: string;

  //selected card type taking into card input
  title = 'my-app';
  expression = false;
  nameBind: string;
  @ViewChildren('textField') nameInputRef: any;

  dropdownList: any = [

    {label: 'Less than 10', newAge: ''},
    {label: 'Greater than 10 and less than 80', newAge: 'Apple'},
    {label: 'Less than 80', newAge: 'Banana'}

  ];

  data: any = [

    {name: 'John', age: '1', newAge: '24'},
    {name: 'Jacky', age: '1', newAge: '4'},
    {name: 'Roy', age: '1', newAge: '34'}
  ];
  private resNo: number;
  private mainResRoomsList: Array<MRestaurantRoomsDTO>;
  private mainResRoomsList2: Array<RestaurantDTO>;
  private roomId: number;


  editAge(ee, i) {
    this.data[i].newAge = this.dropdownList[ee - 1].newAge;
  }

  constructor(private foodItemService: FoodItemService,
              private searchService: SearchService,
              private bookTableService: BookTablesService,
              private router: Router,
              private route: ActivatedRoute,
              private toastra: ToastrService,
              private errorHandler: GlobalErrorHandler) {
  }

  ngOnInit() {
    localStorage.setItem('tableNumber', String(3));
    localStorage.setItem('submitStatus', 'newOrder');
    localStorage.setItem('orderType', '1');
    this.numbersOfItems = 0;
    this.getMainItemCategories();
    this.getAllItems(5);
    this.getMainRestaurantRooms();
    if (localStorage.getItem('submitStatus') === 'update') {
      this.getEditOrderDetails();
    }

    this.setLocalStorage();
    this.loadRemoveReasons();
    this.checkSubmitStatus();
    this.setBtnStatusForSubmitAndUpdate();
    this.getRestaurantList();

    this.time = Date.now();
    setInterval(() => {
      this.CurrentTime = new Date().getHours() + ':' + new Date().getMinutes() + ':' + new Date().getSeconds();
      this.view = Number(localStorage.getItem('view'));
    }, 1);
  }

  setTableNumber() {
    localStorage.setItem('tableNumber', String(1));
  }

  // event handler for the credit card type selection
  selectChangedHandlerPri(event: any) {
    this.selectCardTypePrimary = event.target.value;
  }

  selectChangedHandlerSec(event: any) {
    this.selectCardTypeSecondary = event.target.value;
  }

  getRestaurantList() {
    this.foodItemService.getRestaurantsList().subscribe(data => {
      this.mainResRoomsList2 = data;
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  calculateSecondaryPayAmount(event: any) {
    let enteredAmount: string;
    let enteredAmntNumber: number;

    enteredAmount = event.target.value;
    this.calcSecondaryPayAmount = +enteredAmount;
    if (this.calcSecondaryPayAmount != this.netAmount) {
      this.calcSecondaryPayAmount = this.netAmount - this.calcSecondaryPayAmount;
      this.primaryPayAmount = event.target.value;
    }
  }

  viewThisTable(tableNumber: number) {
    localStorage.setItem('tableNumber', String(3));
    let params = new HttpParams();
    params = params.append('taId', String(tableNumber));
    params = params.append('reId', String(localStorage.getItem('restaurantId')));
    this.bookTableService.viewThisTable(params).subscribe(object => {
      console.log('---------------------------------------------------------------');
      this.KotNumberList = object;
      this.closeThisTable(this.KotNumberList[1].kotNo);
      console.log(this.KotNumberList[0].kotNo);
      console.log(this.KotNumberList[1].kotNo);
      console.log('--------------------' + this.KotNumberList.length);
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  closeThisTable(kot: number) {
    this.bookTableService.closeThisTable(kot).subscribe(data => {
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  set_tables(resid: number) {
    this.foodItemService.getRate().subscribe(Object => {
      for (let i = 0; i < this.itemQu.length; i++) {
       // this.itemQu[i].item.price = this.itemQu[i].item.getPrice() + Object * this.itemQu[i].numbersOfItems;
      }
    //  this.calculateTotalPrice();
    });
    localStorage.setItem('roomId', resid + '');
this.getAllItems(resid);
  }

  calculateTotalPrice() {
    console.log("EX................")
    this.netAmount = 0.0;
    for (let i = 0; i < this.itemQu.length; i++) {
      this.netAmount +=this.itemQu[i].item.price;
    }
    this.primaryPayAmount=0;
    for (let i = 0; i < this.itemQu.length; i++) {
      this.primaryPayAmount +=this.itemQu[i].item.price;
    }

  }

// Print bill / submit order / clear item q list
  printBill() {
    this.submitOrder();
    this.itemQu = new Array<CommonDto>();
    this.viewThisTable(3);
  }

  setReasonForTextArea(message: MVoidReasonDTO) {
    this.mVoidReasonDTO = message;
  }

  setTempDto(demo: CommonDto) {
    this.tempDto = demo;
  }

  getMainItemCategories() {
    this.foodItemService.getMainItemCategories(Number(localStorage.getItem('restaurantId'))).subscribe(Object => {
      this.list = Object;
      this.familyID = Object[0].fNo;
      this.isVisible2 = false;
      this.isVisible = true;
      let params = new HttpParams();
      params = params.append('rid', localStorage.getItem('restaurantId'));
      params = params.append('mid', String(this.list[0].fmNo));
      params = params.append('fid', String(this.list[0].fNo));
      params = params.append('family_no', String(this.list[0].fNo));
      this.foodItemService.getSubItemCategorie(params).subscribe(Objects => {
        this.MasterList = Objects;
        // tslint:disable-next-line:no-shadowed-variable
      }, error => {
        this.errorHandler.handleError(error);
      });
    });
    // this.InitializingAllItemArrays();
  }

  getSubItemCategories(data: FamilyGroupDTO) {
    this.familyID = data.fNo;
    this.MainItemIDForDiscount = data.fNo;
    this.isVisible2 = false;
    this.isVisible = true;
    let params = new HttpParams();
    let params2 = new HttpParams();
    params = params.append('rid', localStorage.getItem('restaurantId'));
    params = params.append('mid', String(data.fmNo));
    params = params.append('fid', String(data.fNo));
    params = params.append('family_no', String(data.fNo));
    this.foodItemService.getSubItemCategorie(params).subscribe(Object => {
      this.MasterList = Object;
      // tslint:disable-next-line:prefer-for-of
      for (let j = 0; j < this.MasterList.length; j++) {
        params2 = params2.append('rid', localStorage.getItem('restaurantId'));
        params2 = params2.append('fid', String(this.MasterList[j].mfNo));
        params2 = params2.append('mid', String(this.MasterList[j].mfNo));
        params2 = params2.append('maid', String(this.MasterList[j].mfNo));
        params2 = params2.append('rate', localStorage.getItem('orderType'));
      }
    });
  }

  getItems(data: MasterGroupDTO) {
    this.isVisible2 = true;
    this.isVisible = false;
    let params = new HttpParams();
    params = params.append('rid', localStorage.getItem('restaurantId'));
    params = params.append('fid', String(data.mfNo));
    params = params.append('mid', String(data.mNo));
    params = params.append('maid', String(data.maNo));
    params = params.append('rate', localStorage.getItem('orderType'));
    this.foodItemService.getItems(params).subscribe(Object => {
      this.ItemList = Object;

    }, error => {
      this.errorHandler.handleError(error);
    });
    console.log(localStorage.getItem('restaurantId'));
  }

  addNewItems(foods: ItemGroupDTO) {
    // this.itemQu = null;

    if (this.discountItemList.length === 0) {
      this.discountItemList.push(new ItemDisCountDTO(this.MainItemIDForDiscount, foods));

    } else {
      this.isExist = false;
      for (const Object of this.discountItemList) {
        if (this.MainItemIDForDiscount !== Object.fNo && this.isExist === false) {
          this.isExist = true;
        }
      }
      if (this.isExist) {
        this.discountItemList.push(new ItemDisCountDTO(this.MainItemIDForDiscount, foods));
      }
    }
    const Common = new CommonDto();
    const frontKotBotItemDTO = new FrontKotBotItemDTO();
    const consolidateDetailDTO = new ConsolidateDetailDTO();

    let num;
    let isBool = false;
    for (let i = 0; i < this.itemQu.length; i++) {
      if (this.itemQu[i].item.iid === foods.iid && this.frontKotBotList[i].itemCode === foods.iid && isBool === false) {
        this.errorHandler.systemMessages('Warning', 'This item already added ! ', 'warning', 1500);
        isBool = true;
        num = i;
      }
    }
    if (!isBool) {
      Common.item.iid = foods.iid;
      Common.item.name = foods.name;
      Common.item.price = foods.price;
      Common.item.taxPrice = foods.taxPrice;
      Common.familyId = this.familyID;
      Common.numbersOfItems = 1;
      Common.updateStatus = false;
      this.itemQu.push(Common);

      frontKotBotItemDTO.itemNo = 0;
      frontKotBotItemDTO.unitCost = 0;
      frontKotBotItemDTO.itemName = foods.name;
      frontKotBotItemDTO.qty = 1;
      frontKotBotItemDTO.unitPrices = foods.price;
      frontKotBotItemDTO.unitPricesWithTax = foods.taxPrice;
      frontKotBotItemDTO.discount = 0;
      frontKotBotItemDTO.itemCode = foods.iid;
      frontKotBotItemDTO.familyId = this.MainItemIDForDiscount;
      frontKotBotItemDTO.taxAmount = foods.taxPrice - foods.price;
      consolidateDetailDTO.familyGno = 1;
      this.consolidateDetailDTOS.push(consolidateDetailDTO);
      this.frontKotBotList.push(frontKotBotItemDTO);

    } else {
      this.itemQu[num].numbersOfItems = this.itemQu[num].numbersOfItems + this.numbersOfItems;
      this.frontKotBotList[num].qty = this.frontKotBotList[num].qty + this.numbersOfItems;
    }
    this.makeDiscountAndTotalAmount();
    if (this.itemQu.length === 0) {
      this.isOkayToPrint = false;
    } else {
      this.isOkayToPrint = true;
    }
    this.getEditOrderDetails();
  }

  submitOrder() {
    this.btnSubmitAndUpdateOrder = 'Waiting...';
    let mainReservationDTO = new MainReservationDTO();
    const frontPosGuestDTO = new FrontPosGuestDTO();
    const frontKotBotMainDTO = new FrontKotBotMainDTO();
    const consolidateDetailDTO = new ConsolidateDetailDTO();
    frontPosGuestDTO.adult = Number(localStorage.getItem('adult'));
    frontPosGuestDTO.children = Number(localStorage.getItem('child'));
    frontPosGuestDTO.tableNo = Number(localStorage.getItem('tableNumber'));
    frontKotBotMainDTO.restaurantId = Number(localStorage.getItem('restaurantId'));
    frontKotBotMainDTO.userId = Number(localStorage.getItem('userid'));
    frontKotBotMainDTO.userName = localStorage.getItem('userName');
    frontKotBotMainDTO.rate = Number(localStorage.getItem('orderType'));
    frontKotBotMainDTO.roomId = Number(localStorage.getItem('roomId'));
    consolidateDetailDTO.familyGno = this.familyNo;
    mainReservationDTO.frontPosGuestDTO = frontPosGuestDTO;
    mainReservationDTO.frontKotBotMainDTO = frontKotBotMainDTO;
    mainReservationDTO.frontKotBotItemDTO = this.frontKotBotList;
    console.log(mainReservationDTO);
    this.foodItemService.submitOrder(mainReservationDTO).subscribe(data => {
      const orderId: string = String(data);
      this.responsDTO = data;
      const tableNumber: string = String(localStorage.getItem('tableNumber'));
      localStorage.setItem('orderID ' + tableNumber, String(this.responsDTO.id));
      console.log("this is order ID.................")
      this.printInvoice=new HttpParams();
      this.printInvoice.append('KotNo',String(this.responsDTO.id));
      console.log('this is print bill area.....');
      console.log(this.printInvoice.get('KotNo'));
      this.errorHandler.systemMessages('Add New Order', 'Order Added By ! ' + localStorage.getItem('userName'), 'success', 3000);
   //   this.router.navigate(['/menu/']);
      // tslint:disable-next-line:no-shadowed-variable
      window.location.reload();
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  // ---------------------------------------------------------------------------------------------------------------------------------------

  // increment and set numbers of items one by one for input field
  incrementNumberOfItems() {
    if (this.numbersOfItems >= 0) {
      this.numbersOfItems = this.numbersOfItems + 1;

    }
  }

  // decrement and set numbers of items one by one for input field
  decrementNumberOfItems() {
    if (this.numbersOfItems >= 1) {
      this.numbersOfItems = this.numbersOfItems - 1;
    }
  }

  // ----------------------------list item increment and decrement (left side list (views))-------------------------------------------------
  // decrement and set numbers of items one by one for input field
  incrementAddedItem(data: CommonDto) {
    if (data.numbersOfItems >= 1) {
      for (const Object of this.frontKotBotList) {
        if (Object.itemCode === data.item.iid) {
          Object.qty = data.numbersOfItems + 1;
          this.totalPrice = this.totalPrice + data.item.price;
          this.taxWithPrice = this.taxWithPrice + data.item.taxPrice;
          this.totalPrice = Number(this.totalPrice.toFixed(2));
          this.taxWithPrice = Number(this.taxWithPrice.toFixed(2));
        }
      }
      data.numbersOfItems = data.numbersOfItems + 1;
      this.makeDiscountAndTotalAmount();
    }
  }

  // decrement and set numbers of items one by one for input field
  search: string;
  decrementAddedItem(data: CommonDto) {
    if (data.numbersOfItems >= 2) {
      for (const Object of this.frontKotBotList) {
        if (Object.itemCode === data.item.iid) {
          Object.qty = data.numbersOfItems - 1;
          this.totalPrice = this.totalPrice - data.item.price;
          this.taxWithPrice = this.taxWithPrice - data.item.taxPrice;
          this.totalPrice = Number(this.totalPrice.toFixed(2));
          this.taxWithPrice = Number(this.taxWithPrice.toFixed(2));
        }
      }
      data.numbersOfItems = data.numbersOfItems - 1;
      this.makeDiscountAndTotalAmount();
    }
    // this.setDiscountForSubmitOrder();
  }

  loadRemoveReasons() {
    this.foodItemService.loadRemoveReasons().subscribe(Object => {
      this.ReasonsList = Object;
      // tslint:disable-next-line:no-shadowed-variable
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  removeItem(data: CommonDto) {
    if (data.updateStatus === false) {
      for (let x = 0; x < this.frontKotBotList.length; x++) {
        if (this.frontKotBotList[x].itemCode === data.item.iid) {
          this.frontKotBotList.splice(x, 1);
          this.itemQu.splice(x, 1);
          this.totalPrice = this.totalPrice - (data.item.price * data.numbersOfItems);
          this.taxWithPrice = this.taxWithPrice - (data.item.taxPrice * data.numbersOfItems);
          this.totalPrice = Number(this.totalPrice.toFixed(2));
          this.taxWithPrice = Number(this.taxWithPrice.toFixed(2));
          this.errorHandler.systemMessages('Remove ', 'Remove ' + data.item.name, 'info', 2000);
          this.makeDiscountAndTotalAmount();
        }
      }
    }
    if (this.tempDto.updateStatus === true) {
      const frontKotBotItemVoidDTO = new FrontKotBotItemVoidDTO();
      frontKotBotItemVoidDTO.kotNo = Number(localStorage.getItem('EditKotNumber'));
      frontKotBotItemVoidDTO.userId = Number(localStorage.getItem('userid'));
      frontKotBotItemVoidDTO.restaurantId = Number(localStorage.getItem('restaurantId'));
      frontKotBotItemVoidDTO.itemNo = this.tempDto.item.iid;
      frontKotBotItemVoidDTO.qty = this.tempDto.numbersOfItems;
      frontKotBotItemVoidDTO.voidNo = this.mVoidReasonDTO.pkNo;
      this.foodItemService.saveReasonforVoidItem(frontKotBotItemVoidDTO).subscribe(isSave => {
        if (isSave) {
          for (let x = 0; x < this.frontKotBotList.length; x++) {
            if (this.frontKotBotList[x].itemCode === this.tempDto.item.iid) {
              let params = new HttpParams();
              params = params.append('kot', localStorage.getItem('EditKotNumber'));
              params = params.append('itemNo', String(this.frontKotBotList[x].itemNo));
              params = params.append('itemCode', String(this.frontKotBotList[x].itemCode));
              this.foodItemService.removeVoidItem(params).subscribe(isRemove => {
                if (isRemove) {
                  this.setDiscountForSubmitOrder();
                  this.errorHandler.systemMessages('Remove', 'Removed !' + data.item.name, 'success', 3000);
                  this.frontKotBotList.splice(x, 1);
                  this.itemQu.splice(x, 1);
                  this.taxWithPrice = this.taxWithPrice - (this.tempDto.item.taxPrice * this.tempDto.numbersOfItems);
                  this.totalPrice = this.totalPrice - (this.tempDto.item.price * this.tempDto.numbersOfItems);
                  this.makeDiscountAndTotalAmount();
                }
              }, error => {
                this.errorHandler.handleError(error);
              });
            }
          }
        } else {
          this.errorHandler.systemMessages('Info', 'Not Remove Item' + data.item.name, 'error', 1000);
        }
      }, error => {
        this.errorHandler.handleError(error);
      });
    }

    if (this.itemQu.length === 0) {
      this.isOkayToPrint = false;
    } else {
      this.isOkayToPrint = true;
    }
  }

  getAllItems(resId:number) {
    this.MItemArray=new Array<ItemGroupDTO>();
    console.log(resId);
    let params = new HttpParams();
    params = params.append('majer_gno', String(1));
    params = params.append('rId', localStorage.getItem('restaurantId'));
    this.foodItemService.getAllItems(params).subscribe(Object => {
      if(resId !==1 && resId !==3) {

        this.MItemArray = Object

      }else{
        for (let i=0;i<Object.length;i++){
          const itemGroupDTO = new ItemGroupDTO();
          itemGroupDTO.iid=Object[i].iid;
          itemGroupDTO.name=Object[i].name;
          itemGroupDTO.price=Object[i].uberPickmePrice;
          itemGroupDTO.taxPrice=Object[i].uberPickmePrice;
          this.MItemArray.push(itemGroupDTO);

        }
      }

      console.log(this.MItemArray);
      // tslint:disable-next-line:no-shadowed-variable
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  private getEditOrderDetails() {
    this.totalPrice = 0;
    let params = new HttpParams();
    params = params.append('kot', localStorage.getItem('EditKotNumber'));
    params = params.append('userId', localStorage.getItem('userid'));
    params = params.append('userType', localStorage.getItem('userType'));
    params = params.append('rId', localStorage.getItem('restaurantId'));
    const kotNumber = Number(localStorage.getItem('EditKotNumber'));
    if (kotNumber !== 0) {
      this.foodItemService.viewOrderDetails(params).subscribe(Objects => {
        for (const Object of Objects) {
          const frontKotBotItemDTO = new FrontKotBotItemDTO();
          const commonDto = new CommonDto();
          commonDto.numbersOfItems = Object.qty;
          commonDto.item.name = Object.itemName;
          commonDto.item.price = Object.price;
          commonDto.item.iid = Object.itemCode;
          commonDto.updateStatus = true;
          commonDto.item.taxPrice = Object.priceWithTax;
          commonDto.familyId = Object.familyId;

          frontKotBotItemDTO.qty = Object.qty;
          frontKotBotItemDTO.itemName = Object.itemName;
          frontKotBotItemDTO.unitPrices = Object.price;
          frontKotBotItemDTO.unitPricesWithTax = Object.priceWithTax;
          frontKotBotItemDTO.itemCode = Object.itemCode;
          frontKotBotItemDTO.itemNo = Object.itemNo;
          frontKotBotItemDTO.value = Object.disPercentage;
          frontKotBotItemDTO.familyId = Object.familyId;
          this.totalPrice = this.totalPrice + Object.price * Object.qty;
          this.frontKotBotList.push(frontKotBotItemDTO);
          this.itemQu.push(commonDto);

        }
        this.TempDisCount = new Array<AddedDiscountDTO>();
        this.foodItemService.getAddedDiscount(params).subscribe(Object => {
          this.disList = Object;
          for (let i = 0; i < this.disList.length; i++) {
            this.TempDisCount3 = new AddedDiscountDTO();
            this.TempDisCount3.fId = this.disList[i].fId;
            this.TempDisCount3.percentage = this.disList[i].percentage;
            this.TempDisCount3.disType = this.disList[i].disType;
            this.TempDisCount.push(this.TempDisCount3);
          }
          this.makeDiscountAndTotalAmount();
          for (const Obj of this.disList) {
            this.setDiscountForEditOrder(Obj);
          }

        });
        // tslint:disable-next-line:no-shadowed-variable
      }, error => {
        this.errorHandler.handleError(error);
      });
    }
    console.log('kot at getOrderDetails');
    console.log(kotNumber);
  }

  back() {
    this.router.navigate(['/dashboard/']);
  }

  updateOrder() {
    this.setDiscountForSubmitOrder();
    this.btnSubmitAndUpdateOrder = 'Waiting..';
    const mainReservationDTO = new MainReservationDTO();
    const frontKotBotMainDTO = new FrontKotBotMainDTO();
    mainReservationDTO.frontKotBotItemDTO = this.frontKotBotList;
    frontKotBotMainDTO.kotNo = Number(localStorage.getItem('EditKotNumber'));
    frontKotBotMainDTO.rate = Number(localStorage.getItem('orderType'));
    frontKotBotMainDTO.userName = localStorage.getItem('userName');
    mainReservationDTO.frontKotBotMainDTO = frontKotBotMainDTO;
    this.foodItemService.updateOrder(mainReservationDTO).subscribe(data => {
      this.errorHandler.systemMessages('Update', 'Successfully Updated', 'success', 5000);
      this.router.navigate(['/dashboard/']);
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  private checkSubmitStatus() {
    console.log(localStorage.getItem('submitStatus'));
    this.btnStatus = localStorage.getItem('submitStatus');
    console.log(this.btnStatus);
  }

  private setBtnStatusForSubmitAndUpdate() {
    if (this.btnStatus === 'newOrder') {
      this.btnSubmitAndUpdateOrder = 'Submit';
    }
    if (this.btnStatus === 'update') {
      this.btnSubmitAndUpdateOrder = 'Update';
    }
  }

  private setLocalStorage() {
    localStorage.setItem('view', '1');
  }

  getDiscount() {
    this.mainListNumber = new Array<number>();
    this.discountNameList = [];
    for (const Obj of this.itemQu) {
      this.discountNameList.push(Obj.item.iid);
    }
    this.foodItemService.getFamilyGroupIds(this.discountNameList).subscribe(Object => {
      this.mainListNumber = Object;
      this.foodItemService.getDiscountList(this.mainListNumber).subscribe(Obj => {
          this.viewDiscountList = Obj;
          this.discountNameList = [];
          if (this.TempDisCount.length !== 0) {
            for (let r = 0; r < this.TempDisCount.length; r++) {
              for (let x = 0; x < this.viewDiscountList.length; x++) {
                for (let o = 0; o < this.viewDiscountList[x].length; o++) {
                  if (this.viewDiscountList[x][o].familyNo === this.TempDisCount[r].fId) {
                    this.viewDiscountList[x][o].disValue = this.TempDisCount[r].percentage;
                  }
                }
              }
            }
          }
          for (const Objs of this.viewDiscountList) {
            if (Objs.length !== 0) {
              this.discountNameList.push(Objs[0].disPosName);
            }
          }
        }
      );
    });
  }

  makeDiscountAndTotalAmount() {
    this.discountPrice = 0;
    this.taxWithPrice = 0;
    this.totalPrice = 0;
    this.netAmount = 0;

    this.TempDisCount2 = new Array<AddedDiscountDTO>();
    if (this.TempDisCount.length === 0) {
      this.TempDisCount3 = new AddedDiscountDTO();
      this.TempDisCount3.fId = this.familyID;
      this.TempDisCount3.percentage = 0;
      this.TempDisCount2.push(this.TempDisCount3);
    }

    for (let z = 0; z < this.itemQu.length; z++) {
      for (let t = 0; t < this.TempDisCount.length; t++) {
        if (this.TempDisCount[t].fId === this.itemQu[z].familyId) {
          if (this.TempDisCount2.length !== 0) {
            for (let e = 0; e < this.TempDisCount2.length; e++) {
              if (this.TempDisCount2[e].fId !== this.TempDisCount[t].fId) {
                this.TempDisCount2.push(this.TempDisCount[t]);
              }
            }
          } else {
            this.TempDisCount2.push(this.TempDisCount[t]);
          }
        }
      }
    }
    for (let r = 0; r < this.TempDisCount2.length; r++) {
      for (let u = 0; u < this.itemQu.length; u++) {
        this.totalPrice = this.totalPrice + (this.itemQu[u].item.price * this.itemQu[u].numbersOfItems);
        this.taxWithPrice = this.taxWithPrice +
          (this.itemQu[u].item.taxPrice - this.itemQu[u].item.price) * this.itemQu[u].numbersOfItems;
        if (this.TempDisCount2[r].fId === this.itemQu[u].familyId) {
          this.discountPrice =
            this.discountPrice + (this.itemQu[u].item.price / 100) * this.itemQu[u].numbersOfItems * this.TempDisCount2[r].percentage;

        }
      }
    }
    this.netAmount = this.netAmount + (this.totalPrice + this.taxWithPrice) - this.discountPrice;
    this.primaryPayAmount = this.netAmount;
  }

  setDiscountForEditOrder(Obj: AddedDiscountDTO) {
    this.fontKotBotDiscount = new FrontKotBotItemDTO();
    this.fontKotBotDiscount.discountType = Obj.disType;
    this.fontKotBotDiscount.isFamily = Obj.fId;
    this.fontKotBotDiscount.value = Obj.percentage;
    this.frontKotBotDiscountList.push(this.fontKotBotDiscount);
    this.TempDisCount.push(Obj);
  }

  setDiscount(Obj: DiscountDTO) {
    if (this.disList.length !== 0) {
      for (let i = 0; i < this.disList.length; i++) {
        if (this.disList[i].fId === Obj.familyNo && this.isAdded === false) {
          this.disList[i].percentage = Obj.disPercentage;
          this.isAdded = true;
        }
      }
    }
    if (this.isAdded === false) {
      this.tempAddedDisDTO = new AddedDiscountDTO();
      this.tempAddedDisDTO.fId = Obj.familyNo;
      this.tempAddedDisDTO.disType = Obj.disType;
      this.tempAddedDisDTO.percentage = Obj.disPercentage;
      this.disList.push(this.tempAddedDisDTO);
    }
    this.isAdded = false;
    for (let i = 0; i < this.TempDisCount.length; i++) {
      if (Obj.familyNo === this.TempDisCount[i].fId && this.isAdded === false) {
        this.TempDisCount[i].percentage = Obj.disPercentage;
        this.isAdded = true;
      }
    }
    if (this.isAdded !== true) {
      this.tempAddedDisDTO = new AddedDiscountDTO();
      this.tempAddedDisDTO.fId = Obj.familyNo;
      this.tempAddedDisDTO.percentage = Obj.disPercentage;
      this.TempDisCount.push(this.tempAddedDisDTO);
    }
    this.fontKotBotDiscount = new FrontKotBotItemDTO();
    this.fontKotBotDiscount.discountType = Obj.disType;
    this.fontKotBotDiscount.isFamily = Obj.familyNo;
    this.fontKotBotDiscount.value = Obj.disPercentage;
    this.frontKotBotDiscountList.push(this.fontKotBotDiscount);

    console.log(this.viewDiscountList);
    console.log(this.disList);

    this.makeDiscountAndTotalAmount();
  }

  setDiscountForSubmitOrder() {
    for (const Object of this.frontKotBotDiscountList) {
      for (let x = 0; x < this.frontKotBotList.length; x++) {
        if (Object.isFamily === this.frontKotBotList[x].familyId) {
          this.frontKotBotList[x].isFamily = Object.isFamily;
          this.frontKotBotList[x].discountType = Object.discountType;
          this.frontKotBotList[x].value = Object.value;
          this.disPercentage = this.disPercentage + Object.value;
        }
      }
    }
  }

  selectPaymentMethod(eve: any) {
    let payMethod: string = '';

    payMethod += eve.target.value;
    if (payMethod === 'card') {
      this.isMethod === 'card';
      console.log('card');
    } else if (payMethod === 'cash') {
      this.isMethod === 'cash';
      console.log('cash');
    } else if (payMethod === 'cashAndCard') {
      this.isMethod === 'cashAndCard';
      console.log('cashAndCard');
    }
  }

  private getMainRestaurantRooms() {
    this.resNo = Number(localStorage.getItem('restaurantId'));
    this.bookTableService.getMainRestaurantRooms(this.resNo).subscribe(Object => {
      this.mainResRoomsList = Object;
      localStorage.setItem('roomId', String(Object[0].id));
      this.roomId = Object[0].id;
      // this.getRestaurantId();
    });
  }
}
