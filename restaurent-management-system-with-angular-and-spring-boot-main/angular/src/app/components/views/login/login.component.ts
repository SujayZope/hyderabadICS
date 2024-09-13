import {Component, OnInit, NgZone, Inject} from '@angular/core';

import {LoginService} from '../../services/login.service';
import {Router} from '@angular/router';
import {UserLoginDTO} from '../../dto/UserLoginDTO';
import {ToastrService} from 'ngx-toastr';
import {DOCUMENT} from '@angular/common';
import {RestaurantDTO} from '../../dto/RestaurantDTO';
import {GlobalErrorHandler} from '../../errorHandler/GlobalErrorHandler';

declare var device;


declare global {
  interface Window {
    RTCPeerConnection: RTCPeerConnection;
    mozRTCPeerConnection: RTCPeerConnection;
    webkitRTCPeerConnection: RTCPeerConnection;
  }
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new UserLoginDTO();
  name = 'Angular';
  Restaurant = [];
  RestaurantId: number;
  userType: string;
  elem;

  constructor(
    @Inject(DOCUMENT) private document: any,
    private userService: LoginService,
    private router: Router,
    private zone: NgZone,
    private toastra: ToastrService,
    private errorHandler: GlobalErrorHandler) {
  }

  ngOnInit() {
    this.RestaurantId = null;
    this.elem = document.documentElement;
    this.getRestaurantList();
    // this.openFullscreen();
    this.removeStorage();
    //  this.disableButton();
  }

  login(res: RestaurantDTO) {
    this.getRestaurantList();
    this.RestaurantId = res.restaurantId;
    if (this.RestaurantId != null) {
      this.userService.loginUser(this.user).subscribe(Object => {
        console.log(Object);
        localStorage.setItem('userType', String(Object.userType));
        localStorage.setItem('restaurantName', res.rName);
        localStorage.setItem('restaurantId', String(this.RestaurantId));
        localStorage.setItem('userid', String(Object.uId));
        localStorage.setItem('userName', this.user.userName);
        console.log('User id is : ' + Object.uId);
        if (Object.uId !== 0 && Object.uId !== 3) {
          this.errorHandler.systemMessages('Welcome ' + this.user.userName, 'Successfully login', 'success', 5000);
          this.openFullscreen();
          sessionStorage.setItem('token', '1');
          this.router.navigate(['/menu/']);
        } else if (Object.uId !== 0 && Object.uId === 3) {
          this.errorHandler.systemMessages('Welcome ' + this.user.userName, 'Successfully login', 'success', 5000);
          this.openFullscreen();
          sessionStorage.setItem('token', '1');
          this.router.navigate(['/cashier/']);
        } else {
          this.errorHandler.systemMessages('Wrong UserName / Password', 'Try Again', 'error', 3500);
          sessionStorage.setItem('token', '0');
          this.router.navigate(['/login']);
        }
      }, error => {
        this.errorHandler.handleError(error);
      });
    } else {
      this.errorHandler.systemMessages('Please Select Restaurant', 'Try Again', 'warning', 7000);
    }
  }

  // --------------------------------------------------------------------- get Restaurant List --------------------------------------------
  getRestaurantList() {
    this.userService.getRestaurantsList().subscribe(data => {
      this.Restaurant = data;
    }, error => {
      this.errorHandler.handleError(error);
    });
  }

  openFullscreen() {
    if (this.elem.requestFullscreen) {
      this.elem.requestFullscreen();
    } else if (this.elem.mozRequestFullScreen) {
      /* Firefox */
      this.elem.mozRequestFullScreen();
    } else if (this.elem.webkitRequestFullscreen) {
      /* Chrome, Safari and Opera */
      this.elem.webkitRequestFullscreen();
    } else if (this.elem.msRequestFullscreen) {
      /* IE/Edge */
      this.elem.msRequestFullscreen();
    }
  }

  private removeStorage() {
    sessionStorage.removeItem('token');
    localStorage.clear();
  }

  private disableButton() {
    document.addEventListener('deviceready', onDeviceReady, false);

    function onDeviceReady() {
      console.log(device);
      if (device.platform === 'android' || device.platform === 'Android') {
        document.addEventListener('backbutton', onBackKeyDown, false);
      }

      function onBackKeyDown() {
        console.log('Does nothing');
      }
    }
  }
}
