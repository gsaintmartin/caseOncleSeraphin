
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

  updateproduct() {
    this.productService.updateProduct(this.id, this.product)
      .subscribe(data => console.log(data), error => console.log(error));
    this.product = new Product();
    this.gotoList();
  }

  onSubmit() {
    this.updateproduct();
  }

  gotoList() {
    this.router.navigate(['/products']);
  }



}
