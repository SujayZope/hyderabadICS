import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  userName: string;
  restaurantName: string;
  time: any;
  CurrentTime: any;
  userType: string;
  view: number;
  posAndCashier: string;
  constructor(private router: Router) {
  }

  ngOnInit() {
    this.posAndCashier = 'Go to Cashier';
    this.userName = localStorage.getItem('userName');
    this.restaurantName = localStorage.getItem('restaurantName');
    this.userType = localStorage.getItem('userType');
    this.time = Date.now();
    setInterval(() => {
      this.CurrentTime = new Date().getHours() + ':' + new Date().getMinutes() + ':' + new Date().getSeconds();
      this.view = Number(localStorage.getItem('view'));
    }, 1);
  }


  logout() {
    sessionStorage.removeItem('token');
    this.router.navigate(['/login']);
  }

  goToCashierAndGoToPos() {
    if (this.posAndCashier === 'Go to Cashier') {
      this.posAndCashier = 'Go to POS';
      this.router.navigate(['/cashier']);
    } else {
      this.router.navigate(['/dashboard']);
      this.posAndCashier = 'Go to Cashier';
    }
  }
}
