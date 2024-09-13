import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from './components/views/login/login.component';
import {AuthGuard} from './components/authServices/AuthGuard';
import {DashboardComponent} from './components/views/dashboard/dashboard.component';
import {MenuComponent} from './components/views/menu/menu.component';
import {TablesComponent} from './components/views/tables/tables.component';
import {CashierComponent} from './components/views/cashier/cashier.component';
import {CommonModule} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import { InvoiceComponent } from './components/views/invoice/invoice.component';


const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'menu',
    component: MenuComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'tables',
    component: TablesComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'cashier',
    component: CashierComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'invoice',
    component: InvoiceComponent
  }

];

@NgModule({
  imports: [CommonModule, BrowserModule, RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
