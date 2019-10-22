import { ProductDetailsComponent } from '../site/admin/admin-product/product-details/product-details.component';
import { Observable } from 'rxjs';
import { ProductService } from '../site/admin/admin-product/product.service';
import { Product } from '../product';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Observable<Product[]>;

  constructor(private productService: ProductService,
              private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.products = this.productService.getProductsList();
  }

  deleteproduct(id: number) {
  }

  productDetails(id: number) {
    this.router.navigate(['details', id]);
  }
}
