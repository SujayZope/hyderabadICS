import {Injectable, Input, Component, HostListener, ErrorHandler} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, map} from 'rxjs/operators';
import {FamilyGroupDTO} from '../dto/FamilyGroupDTO';
import {MasterGroupDTO} from '../dto/Master_GroupDTO';
import {ItemGroupDTO} from '../dto/Item_GroupDTO';
import {MainReservationDTO} from '../dto/Main_ReservationDTO';
import {ViewOrderDTO} from '../dto/ViewOrderDTO';
import {MVoidReasonDTO} from '../dto/M_void_reasonDTO';
import {FrontKotBotItemVoidDTO} from '../dto/Front_kot_bot_item_voidDTO';
import {DiscountDTO} from '../dto/DiscountDTO';
import {AddedDiscountDTO} from '../dto/AddedDiscountDTO';
import { MItemDTO } from '../dto/MItemDTO';
import {RestaurantDTO} from '../dto/RestaurantDTO';
import {ResponsDTO} from '../dto/ResponsDTO';

const MAIN_URL = 'http://10.1.1.2:8090';
// const MAIN_URL = 'http://220.247.236.134:8080';
// const MAIN_URL = 'http://localhost:8090';
// const URL = '/Hotel/api';
const URL = '/api';



















@Injectable({
  providedIn: 'root'
})
export class FoodItemService {
  private params: HttpParams;

  constructor(private http: HttpClient) {
  }



  getMainItemCategories(rNo: number): Observable<Array<FamilyGroupDTO>> {
    return this.http.get<Array<FamilyGroupDTO>>(MAIN_URL + URL + '/familyGroup/' + rNo)
      .pipe(catchError(this.errorHandler));
  }

  getSubItemCategorie(data: HttpParams): Observable<Array<MasterGroupDTO>> {
    return this.http.post<Array<MasterGroupDTO>>(MAIN_URL + URL + '/masterGroup/', data)
      .pipe(catchError(this.errorHandler));
  }
  getRestaurantsList(): Observable<Array<RestaurantDTO>> {
    return this.http.get<Array<RestaurantDTO>>(MAIN_URL + URL + '/restaurant')
      .pipe(catchError(this.errorHandler));
  }
  getItems(data: HttpParams): Observable<Array<ItemGroupDTO>> {
    return this.http.post<Array<ItemGroupDTO>>(MAIN_URL + URL + '/itemGroup/', data)
      .pipe(catchError(this.errorHandler));
  }
  getAllItems(data: HttpParams): Observable<Array<ItemGroupDTO>> {
    return this.http.post<Array<ItemGroupDTO>>(MAIN_URL + URL + '/getAllPosItems/', data)
      .pipe(catchError(this.errorHandler));
  }

  submitOrder(submit: MainReservationDTO): Observable<ResponsDTO> {
    return this.http.post<ResponsDTO>(MAIN_URL + URL + '/mainReservation/add', submit)
      .pipe(catchError(this.errorHandler));

  }


  viewOrderDetails(params: HttpParams): Observable<Array<ViewOrderDTO>> {
    return this.http.post<Array<ViewOrderDTO>>(MAIN_URL + URL + '/getAllItems/', params)
      .pipe(catchError(this.errorHandler));
  }

  updateOrder(mainReservationDTO: MainReservationDTO): Observable<number> {
    return this.http.put<number>(MAIN_URL + URL + '/mainReservation/update', mainReservationDTO)
      .pipe(catchError(this.errorHandler));
  }

  loadRemoveReasons(): Observable<Array<MVoidReasonDTO>> {
    return this.http.get<Array<MVoidReasonDTO>>(MAIN_URL + URL + '/reasons')
      .pipe(catchError(this.errorHandler));
  }

  saveReasonforVoidItem(frontKotBotItemVoidDTO: FrontKotBotItemVoidDTO): Observable<boolean> {
    return this.http.post<boolean>(MAIN_URL + URL + '/add', frontKotBotItemVoidDTO)
      .pipe(catchError(this.errorHandler));
  }

  removeVoidItem(params: HttpParams): Observable<boolean> {
    return this.http.delete<boolean>(MAIN_URL + URL + '/mainReservation/delete?' + params)
      .pipe(catchError(this.errorHandler));
  }
  getDiscountList(mainListNumber: Array<number>): Observable<Array<Array<DiscountDTO>>> {
    return this.http.post<Array<Array<DiscountDTO>>>(MAIN_URL + URL + '/discount', mainListNumber)
      .pipe(catchError(this.errorHandler));
  }

  getFamilyGroupIds(discountNameList: any[]): Observable<Array<number>> {
    return this.http.post<Array<number>>(MAIN_URL + URL + '/getAllGroups', discountNameList)
      .pipe(catchError(this.errorHandler));
  }


  getAddedDiscount(params: HttpParams): Observable<Array<AddedDiscountDTO>> {
    return this.http.post<Array<AddedDiscountDTO>>(MAIN_URL + URL + '/getAllAddedDiscount/', params)
      .pipe(catchError(this.errorHandler));
  }

  printBill(par:HttpParams): Observable<boolean> {
    console.log('this is kot ............ /')
    console.log(par.get('KotNo'));
    return this.http.post<boolean>(MAIN_URL + URL + '/printInvoice/',par)
      .pipe(catchError(this.errorHandler));
  }

  errorHandler(error) {
    return throwError(error.message);
  }


  getRate(): Observable<number> {
    return this.http.get<number>(MAIN_URL + URL + '/mainReservation/getRate')
      .pipe(catchError(this.errorHandler));
  }

  invoicePrint() {

  }
}
