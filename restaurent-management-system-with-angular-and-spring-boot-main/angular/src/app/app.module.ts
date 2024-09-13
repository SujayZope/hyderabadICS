import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CashierComponent} from './components/views/cashier/cashier.component';
import {DashboardComponent} from './components/views/dashboard/dashboard.component';
import {LoginComponent} from './components/views/login/login.component';
import {MenuComponent} from './components/views/menu/menu.component';
import {TablesComponent} from './components/views/tables/tables.component';
import {NavbarComponent} from './components/views/navbar/navbar.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {ToastrModule} from 'ngx-toastr';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AuthService} from './components/authServices/AuthService';
import {AuthGuard} from './components/authServices/AuthGuard';
import {GlobalErrorHandler} from './components/errorHandler/GlobalErrorHandler';
import {RouterModule, Routes} from '@angular/router';
import { SearchComponent } from './components/search/search.component';
import { InvoiceComponent } from './components/views/invoice/invoice.component';
import {Ng2SearchPipeModule} from 'ng2-search-filter';
import {NgxPrintModule} from 'ngx-print';



@NgModule({
  declarations: [
    AppComponent,
    CashierComponent,
    DashboardComponent,
    LoginComponent,
    MenuComponent,
    TablesComponent,
    NavbarComponent,
    SearchComponent,
    InvoiceComponent,

  ],
  exports: [LoginComponent, NavbarComponent,InvoiceComponent],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    ReactiveFormsModule,
    HttpClientModule,
    Ng2SearchPipeModule,
    NgxPrintModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({
      timeOut: 2500,
      progressAnimation: 'increasing',

    })
  ],
  providers: [AuthService, AuthGuard, GlobalErrorHandler],
  bootstrap: [AppComponent]
})
export class AppModule {
}
