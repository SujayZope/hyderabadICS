import {Component, OnInit} from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-cashier',
  templateUrl: './cashier.component.html',
  styleUrls: ['./cashier.component.css']
})
export class CashierComponent implements OnInit {

  constructor(private route: ActivatedRoute) {
  }

  ngOnInit() {
 //   this.setLocalStorage();
  }
  private setLocalStorage() {
    localStorage.setItem('view', '1');
  }
}
