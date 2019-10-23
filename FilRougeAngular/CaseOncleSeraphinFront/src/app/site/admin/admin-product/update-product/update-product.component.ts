<<<<<<< HEAD
import { OnInit, Component } from '@angular/core';
=======
import {  OnInit, Component } from '@angular/core';
import { Product } from '../../../../product';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../../../../service/product.service';


>>>>>>> 58f3699155e14dcf05ae36f2599a009edf72c81c

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
