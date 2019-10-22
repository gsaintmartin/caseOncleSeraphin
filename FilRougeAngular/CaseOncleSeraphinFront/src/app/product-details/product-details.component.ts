import { Product } from '../Product';
import { Component, OnInit, Input } from '@angular/core';

import { ProductListComponent } from '../Product-list/Product-list.component';
import { Router, ActivatedRoute } from '@angular/router';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './Product-details.component.html',
  styleUrls: ['./Product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  id: number;
  Product: Product;

  constructor(private route: ActivatedRoute,private router: Router,
    private productService: ProductService) { }

  ngOnInit() {
    this.Product = new Product();

    this.id = this.route.snapshot.params['id'];

    this.productService.getProduct(this.id)
      .subscribe(data => {
        console.log(data)
        this.Product = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['Products']);
  }
}
