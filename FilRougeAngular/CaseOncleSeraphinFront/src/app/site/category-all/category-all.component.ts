import { Component, OnInit, Output } from '@angular/core';
import { ProductService } from 'src/app/service/product.service';
import { Product } from 'src/app/product';

@Component({
  selector: 'app-category-all',
  templateUrl: './category-all.component.html',
  styleUrls: ['./category-all.component.css']
})
export class CategoryAllComponent implements OnInit {

  products: Product[];

  @Output() numberProducts;

  constructor(private productService: ProductService) {

  }

  ngOnInit() {
    this.productService.getAllProducts().subscribe(result => {
      this.products = result;
      return;
    });
  }

  addProductCart() {

    this.numberProducts += 1;

  }


}
