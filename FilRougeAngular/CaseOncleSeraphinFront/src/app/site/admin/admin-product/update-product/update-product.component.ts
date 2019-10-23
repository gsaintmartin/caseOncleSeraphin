
import {  OnInit, Component } from '@angular/core';
import { Product } from '../../../../product';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from '../../../../service/product.service';


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
