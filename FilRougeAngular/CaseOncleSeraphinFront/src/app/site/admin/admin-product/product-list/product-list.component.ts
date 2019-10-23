//import { ProductDetailsComponent } from '../product-details/product-details.component';
import { Observable } from 'rxjs';
<<<<<<< HEAD:FilRougeAngular/CaseOncleSeraphinFront/src/app/product-list/product-list.component.ts
<<<<<<< HEAD
import { ProductService } from '../service/product.service';
=======
//import { ProductService } from '../site/admin/admin-product/product.service';
>>>>>>> c727b0416e8854a0e588f031e2822ca858c1fbd9
import { Product } from '../product';
=======

>>>>>>> master:FilRougeAngular/CaseOncleSeraphinFront/src/app/site/admin/admin-product/product-list/product-list.component.ts
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/service/product.service';
import { Product } from 'src/app/product';


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
  deleteProduct(id: number) {
    this.productService.deleteProduct(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }


  productDetails(id: number) {
    this.router.navigate(['details', id]);

  }
}
