import { Component, OnInit } from '@angular/core';
import html2canvas from 'html2canvas';
import jspdf from 'jspdf';
import { CommonDto } from '../../dto/common-dto';
import { MenuComponent } from '../menu/menu.component';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {

  selectCardTypePrimary: string;
   selectCardTypeSecondary: string;
   calcSecondaryPayAmount: number;
   primaryPayAmount: number;
   itemQu2: Array<CommonDto> = new Array<CommonDto>();
   netAmount2: number;

  

  constructor() { }

  ngOnInit() {
    // this.initializeTheVariables();
    // this.printBill();
  }

  printBill(){
    var element = document.getElementById('table')
    

    html2canvas(element).then((canvas) => {

      // console.log(canvas);

      var imgData = canvas.toDataURL('image/png')

      var doc = new jspdf();


      var imgHeight = canvas.height * 100/ canvas.width;

      doc.addImage(imgData,0,0,100,imgHeight)

      
      
      
      window.open(doc.output('datauristring')).print();
   })
    
  }





}
