import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';


import {Observable, throwError} from 'rxjs';
import {UserLoginDTO} from '../dto/UserLoginDTO';
import {MainDTO} from '../dto/MainDTO';
import {catchError} from 'rxjs/operators';
import {RestaurantDTO} from '../dto/RestaurantDTO';



const MAIN_URL = 'http://10.1.1.2:8090';
// const MAIN_URL = 'http://220.247.236.134:8080';
// const MAIN_URL = 'http://localhost:8090';
// const URL = '/Hotel/api';
const URL = '/api';


@Injectable({
  providedIn: 'root'
})

export class LoginService {
  constructor(private http: HttpClient) {
  }

  loginUser(userLogin: UserLoginDTO): Observable<MainDTO> {
    return this.http.post<MainDTO>(MAIN_URL + URL + '/login', userLogin)
      .pipe(catchError(this.errorHandler));
  }

  getRestaurantsList(): Observable<Array<RestaurantDTO>> {
    return this.http.get<Array<RestaurantDTO>>(MAIN_URL + URL + '/restaurant')
      .pipe(catchError(this.errorHandler));
  }

  errorHandler(error) {
    return throwError(error);
  }
}
