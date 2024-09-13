import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {SaveTableDto} from '../dto/save-table-dto';
import {Observable, throwError} from 'rxjs';
import {RestaurantTablesDTO} from '../dto/RestaurantTablesDTO';
import {ViewOrderDTO} from '../dto/ViewOrderDTO';
import {RoomsDTO} from '../dto/RoomsDTO';
import {catchError} from 'rxjs/operators';
import {FrontKotBotMainDTO} from '../dto/Front_kot_bot_mainDTO';
import {ManagersDTO} from '../dto/ManagersDTO';
import {MRestaurantRoomsDTO} from '../dto/M_Restaurant_RoomsDTO';

const MAIN_URL = 'http://10.1.1.2:8090';
// const MAIN_URL = 'http://220.247.236.134:8080';
// const MAIN_URL = 'http://localhost:8090';
// const URL = '/Hotel/api';
const URL = '/api';



@Injectable({
  providedIn: 'root'
})
export class BookTablesService {

  savetable: SaveTableDto = new SaveTableDto();

  constructor(private http: HttpClient) {
  }

  saveAdultAndChild(saveTable: SaveTableDto): Observable<boolean> {
    return this.http.post<boolean>(MAIN_URL + URL + '/', this.savetable)
      .pipe(catchError(this.errorHandler));
  }

  getMainRestaurantRooms(res: number): Observable<Array<MRestaurantRoomsDTO>> {
    return this.http.get<Array<MRestaurantRoomsDTO>>(MAIN_URL + URL + '/numberOfRooms/' + res);
  }

  getNumberOfTables(res: number): Observable<Array<RestaurantTablesDTO>> {
    return this.http.get<Array<RestaurantTablesDTO>>(MAIN_URL + URL + '/numberOfTables/' + res)
      .pipe(catchError(this.errorHandler));
  }

  getOpenTables(params: HttpParams): Observable<Array<FrontKotBotMainDTO>> {
    return this.http.post<Array<FrontKotBotMainDTO>>(MAIN_URL + URL + '/getOpenTables/', params)
      .pipe(catchError(this.errorHandler));
  }

  viewThisTable(params: HttpParams): Observable<Array<FrontKotBotMainDTO>> {
    return this.http.post<Array<FrontKotBotMainDTO>>(MAIN_URL + URL + '/getOrderTables/', params)
      .pipe(catchError(this.errorHandler));
  }

  closeThisTable(orderNumber: number): Observable<number> {
    return this.http.get<number>(MAIN_URL + URL + '/closeTable/' + orderNumber)
      .pipe(catchError(this.errorHandler));
  }

  viewOrderDetails(params: HttpParams): Observable<Array<ViewOrderDTO>> {
    return this.http.post<Array<ViewOrderDTO>>(MAIN_URL + URL + '/getAllItems/', params)
      .pipe(catchError(this.errorHandler));
  }

  getAllOrdersNumbers(params: HttpParams): Observable<Array<ViewOrderDTO>> {
    return this.http.post<Array<ViewOrderDTO>>(MAIN_URL + URL + '/getBill/', params)
      .pipe(catchError(this.errorHandler));
  }

  getInHouseList(): Observable<Array<RoomsDTO>> {
    return this.http.get<Array<RoomsDTO>>(MAIN_URL + URL + '/rooms')
      .pipe(catchError(this.errorHandler));
  }

  getManagerList(): Observable<Array<ManagersDTO>> {
    return this.http.get<Array<ManagersDTO>>(MAIN_URL + URL + '/managers')
      .pipe(catchError(this.errorHandler));
  }

  errorHandler(error) {
    return throwError(error);
  }

  sendOrderNumber(params: HttpParams): Observable<boolean> {
    return this.http.post<boolean>(MAIN_URL + URL + '/kotTransfer/', params)
      .pipe(catchError(this.errorHandler));
  }
}
