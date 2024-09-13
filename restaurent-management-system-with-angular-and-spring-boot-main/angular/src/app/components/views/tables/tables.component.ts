import {Component, HostListener, OnInit} from '@angular/core';

import {SaveTableDto} from '../../dto/save-table-dto';
import {BookTablesService} from '../../services/book-tables.service';
import {CommonDto} from '../../dto/common-dto';
import {LoginService} from '../../services/login.service';
import {ActivatedRoute, Router} from '@angular/router';
import {SetOpenTableDTO} from '../../dto/SetOpenTableDTO';
import {ViewOrderDTO} from '../../dto/ViewOrderDTO';
import {RoomsDTO} from '../../dto/RoomsDTO';
import {ToastrService} from 'ngx-toastr';
import {GlobalErrorHandler} from '../../errorHandler/GlobalErrorHandler';
import {HttpParams} from '@angular/common/http';
import {FrontKotBotMainDTO} from '../../dto/Front_kot_bot_mainDTO';
import {interval} from 'rxjs';
import {ManagersDTO} from '../../dto/ManagersDTO';
import {MRestaurantRoomsDTO} from '../../dto/M_Restaurant_RoomsDTO';
import {RestaurantTablesDTO} from '../../dto/RestaurantTablesDTO';


@Component({
  selector: 'app-tables',
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.css']
})
export class TablesComponent implements OnInit {

  tableNumber: number;
  numberOfTables: number;
  adult: number;
  resNo: number;
  orderUserName: string;
  child: number;
  kotNumber: number;
  roomId: number;
  totalPrice: number;
  btnEditAndClose: boolean;
  userID: number;
  btnSubmitUpdateStatus: boolean;
  updateStatus: boolean;
  saveTable: SaveTableDto = new SaveTableDto();
  tables: Array<RestaurantTablesDTO> = new Array<RestaurantTablesDTO>();
  openTables = [];
  closeTableList: Array<FrontKotBotMainDTO> = new Array<FrontKotBotMainDTO>();
  mainResRoomsList: Array<MRestaurantRoomsDTO> = new Array<MRestaurantRoomsDTO>();
  setOpenAndNormalTables: Array<SetOpenTableDTO> = new Array<SetOpenTableDTO>();
  takeAway: SetOpenTableDTO = new SetOpenTableDTO();
  OrderDetails: Array<ViewOrderDTO> = new Array<ViewOrderDTO>();
  managerList: Array<ManagersDTO> = new Array<ManagersDTO>();
  inHouseList: Array<RoomsDTO> = new Array<RoomsDTO>();
  commondto: CommonDto = new CommonDto();
  private message: string;
  transferTableNumber: number;


  constructor( private bookTableService: BookTablesService,
              private userService: LoginService,
              private route: ActivatedRoute,
              private routers: Router,
              private toastra: ToastrService,
              private errorHandler: GlobalErrorHandler) {
    this.commondto.adult = 1;
    this.commondto.child = 0;
  }


  ngOnInit() {
    this.userID = Number(localStorage.getItem('userid'));
    this.getMainRestaurantRooms();
    this.getRestaurantId();
    this.setLocalStorage();
    const secondsCounter = interval(10000);
    secondsCounter.subscribe(n => this.getRestaurantId());

  }

  editOrderPage() {
    localStorage.setItem('EditKotNumber', String(this.kotNumber));
    localStorage.setItem('submitStatus', 'update');
    if (this.kotNumber != null) {
      if (Number(localStorage.getItem('userType')) === 1 || localStorage.getItem('userName').toUpperCase()
        === localStorage.getItem('OrderUserName').toUpperCase()) {
        this.routers.navigate(['/menu/']);
      } else {
        this.errorHandler.systemMessages('You Can Not Edit This Order',
          'This Order Added By ' + localStorage.getItem('OrderUserName'), 'error', 4000);
      }
    } else {
      this.errorHandler.systemMessages('Empty Order Number', 'Please Select A Order Number', 'error', 5000);
    }
  }

  setTableNumber(tableNumber: number) {
    this.closeTableList = [];
    localStorage.setItem('tableNumber', String(tableNumber));
  }

  viewThisTable(tableNumber: number) {
    this.transferTableNumber = tableNumber;
    this.orderUserName = '';
    this.btnEditAndClose = false;
    this.kotNumber = null;
    this.totalPrice = null;
    this.OrderDetails = new Array<ViewOrderDTO>();
    localStorage.setItem('tableNumber', String(tableNumber));
    let params = new HttpParams();
    params = params.append('taId', String(tableNumber));
    params = params.append('reId', String(localStorage.getItem('restaurantId')));
    this.bookTableService.viewThisTable(params).subscribe(Object => {
      this.closeTableList = Object;
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  viewOrderDetails(kotNumber: number) {
    this.btnEditAndClose = true;
    this.totalPrice = 0;
    let params = new HttpParams();
    params = params.append('kot', String(kotNumber));
    params = params.append('userId', localStorage.getItem('userid'));
    params = params.append('userType', localStorage.getItem('userType'));

    this.bookTableService.viewOrderDetails(params).subscribe(Details => {
      this.kotNumber = kotNumber;
      this.OrderDetails = Details;
      this.orderUserName = this.OrderDetails[0].userName;
      for (const Object of this.OrderDetails) {
        this.totalPrice = this.totalPrice + Object.price * Object.qty;
      }
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  getAllOrderNumbers(kotNumber: number) {
    this.btnEditAndClose = true;
    this.totalPrice = 0;
    let params = new HttpParams();
    params = params.append('kot', String(kotNumber));
    this.bookTableService.getAllOrdersNumbers(params).subscribe(Object => {
      localStorage.setItem('OrderUserName', Object[0].userName);
      this.kotNumber = kotNumber;
      this.OrderDetails = Object;
      this.orderUserName = this.OrderDetails[0].userName;
      for (const Objects of this.OrderDetails) {
        this.totalPrice = this.totalPrice + Objects.price * Objects.qty;
      }
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  closeThisTable() {
    this.bookTableService.closeThisTable(this.kotNumber).subscribe(data => {
      this.setOpenAndNormalTables.length = 0;
      this.errorHandler.systemMessages('Close By : ' + localStorage.getItem('userName'),
        'Close Order No : ' + this.kotNumber, 'success', 2000);
      this.tables = [];
      this.openTables = [];
      this.getRestaurantId();
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  selectInHour(data: RoomsDTO) {
    localStorage.removeItem('EditKotNumber');
    localStorage.setItem('submitStatus', 'submit');
    localStorage.setItem('adult', String(data.noAdult));
    localStorage.setItem('child', String(data.noChild));
    localStorage.setItem('roomNo', String(data.roomNo));
    localStorage.setItem('submitStatus', 'newOrder');
    this.routers.navigate(['/menu']);
  }

  getInHouseList() {
    this.bookTableService.getInHouseList().subscribe(data => {
      this.inHouseList = data;
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  setOpenTablesAndNormalTables() {
    console.log('num');
    console.log(this.tables);
    console.log(this.openTables);
    if (this.setOpenAndNormalTables.length === 0) {
      for (const normal of this.tables) {
        let isDone = false;
        for (const open of this.openTables) {
          if (normal.tableId === open.tableId && isDone === false) {
            isDone = true;
          }
        }
        const setOpenTableDTO = new SetOpenTableDTO();
        if (isDone) {
          setOpenTableDTO.tableNumber = normal.tableId;
          setOpenTableDTO.open = isDone;
          setOpenTableDTO.roomId = normal.roomId;
          this.setOpenAndNormalTables.push(setOpenTableDTO);
        } else {
          setOpenTableDTO.tableNumber = normal.tableId;
          setOpenTableDTO.open = isDone;
          setOpenTableDTO.roomId = normal.roomId;
          this.setOpenAndNormalTables.push(setOpenTableDTO);
        }
      }
    } else {
      for (const normal of this.tables) {
        let isDone = false;
        for (const open of this.openTables) {
          if (normal.tableId === open.tableId && isDone === false) {
            isDone = true;
          }
        }
        const setOpenTableDTO = new SetOpenTableDTO();
        if (isDone) {
          setOpenTableDTO.tableNumber = normal.tableId;
          setOpenTableDTO.open = isDone;
          setOpenTableDTO.roomId = normal.roomId;

          for (let i = 0; i < this.setOpenAndNormalTables.length; i++) {
            if (this.setOpenAndNormalTables[i].tableNumber === setOpenTableDTO.tableNumber) {
              this.setOpenAndNormalTables[i].open = isDone;
            }
          }
        } else {
          setOpenTableDTO.tableNumber = normal.tableId;
          setOpenTableDTO.open = isDone;
          setOpenTableDTO.roomId = normal.roomId;

          for (let i = 0; i < this.setOpenAndNormalTables.length; i++) {
            if (this.setOpenAndNormalTables[i].tableNumber === setOpenTableDTO.tableNumber) {
              this.setOpenAndNormalTables[i].open = isDone;
            }
          }
        }
      }
      console.log('full');
      console.log(this.setOpenAndNormalTables);
    }
  }

  setAdultAndChild() {
    localStorage.setItem('adult', String(this.commondto.adult));
    localStorage.setItem('child', String(this.commondto.child));
    localStorage.setItem('tableNo', String(this.tableNumber));
    localStorage.setItem('orderType', '1');
    localStorage.setItem('submitStatus', 'newOrder');
    localStorage.removeItem('EditKotNumber');
    if (this.commondto.adult > 0 || this.commondto.child > 0) {
      this.routers.navigate(['/menu']);
    } else {
      this.errorHandler.systemMessages('Info', 'Please Enter Adult & Child', 'warning', 5000);
      this.message = 'Please Enter Adult And Child';
    }
  }

  getRestaurantId() {
    this.resNo = Number(localStorage.getItem('restaurantId'));
    this.set_tables(Number(localStorage.getItem('roomId')));
  }

  set_tables(roomId: number) {
    this.roomId = roomId;
    localStorage.setItem('roomId', String(roomId));
    this.tables = [];
    this.bookTableService.getNumberOfTables(Number(localStorage.getItem('restaurantId'))).subscribe(Object => {
      this.tables = Object;
      if (this.roomId == null) {
        localStorage.setItem('roomId', String(Object[0].roomId));
        this.roomId = Object[0].roomId;
      }
      this.getOpenTable();
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  getOpenTable() {
    this.openTables = [];
    let params = new HttpParams();
    params = params.append('reId', String(localStorage.getItem('restaurantId')));
    this.bookTableService.getOpenTables(params).subscribe(tables => {
      for (let i = 0; i < tables.length; i++) {
        this.openTables[i] = tables[i];
      }
      this.setOpenTablesAndNormalTables();
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  // ------------------------------------------------------------- get main categories------------------------------------------------------
  getFamilyGroup() {
    this.route.paramMap.subscribe(params => {
      this.resNo = Number(params.get('id'));
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  saveChildAndAdult() {
    this.bookTableService.saveAdultAndChild(this.saveTable).subscribe(data => {
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  // increment and set numbers one by one for adult input field
  incrementAdultOneByOne() {
    if (this.commondto.adult >= 0) {
      this.commondto.adult = this.commondto.adult + 1;
    }
  }

  // decrement and set numbers one by one for adult input field
  decrementAdultOneByOne() {
    if (this.commondto.adult >= 1) {
      this.commondto.adult = this.commondto.adult - 1;
    }
  }

  // increment and set numbers one by one for Child input field
  incrementChildOneByOne() {
    if (this.commondto.child >= 0) {
      this.commondto.child = this.commondto.child + 1;
    }
  }

  // decrement and set numbers one by one for Child input field
  decrementChildOneByOne() {
    if (this.commondto.child >= 1) {
      this.commondto.child = this.commondto.child - 1;
    }
  }

  private clearAllData() {
    this.tables = [];
    this.openTables = [];
    this.closeTableList = [];

  }

  private setLocalStorage() {
    this.totalPrice = null;
    localStorage.setItem('view', '0');
    localStorage.removeItem('tableNumber');
    localStorage.removeItem('adult');
    localStorage.removeItem('child');
    localStorage.removeItem('submitStatus');
  }

  getManagerList() {
    this.bookTableService.getManagerList().subscribe(Object => {
      this.managerList = Object;
    });
  }

  selectManager(Object: ManagersDTO) {
    localStorage.setItem('orderType', '4');
    localStorage.setItem('submitStatus', 'newOrder');
    this.routers.navigate(['menu']);
  }

  getMenuPageForTakeAWay() {
    localStorage.setItem('orderType', '5');
    localStorage.setItem('submitStatus', 'newOrder');
    this.routers.navigate(['menu']);
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

  getAllTables() {
  }

  sendToOrder(tableNumber: number) {
    let params = new HttpParams();
    params = params.append('kot', String(this.kotNumber));
    params = params.append('tableId', String(tableNumber));
    this.bookTableService.sendOrderNumber(params).subscribe(Object => {
      this.getRestaurantId();
      console.log(Object);
    });
  }
}
