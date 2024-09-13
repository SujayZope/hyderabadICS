import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpParams} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import { ItemGroupDTO } from '../dto/Item_GroupDTO';

const MAIN_URL = 'http://10.1.1.2:8090';
// const MAIN_URL = 'http://220.247.236.134:8080';
// const MAIN_URL = 'http://localhost:8090';
// const URL = '/Hotel/api';
const URL = '/api';







@Injectable({
  providedIn: 'root'
})

export class SearchService {
  private params: HttpParams;
  constructor(private http: HttpClient){
  }
searchItems(data: HttpParams): Observable<Array<ItemGroupDTO>> {
 return this.http.post<Array<ItemGroupDTO>>(MAIN_URL+URL+'/', data).pipe(catchError(this.errorHandler));
}
  errorHandler(error) {
    return throwError(error.message);
  }
}
export interface searchItems{
  iid: number;
  name: string;
  price: number;
  taxPrice: number;
}
