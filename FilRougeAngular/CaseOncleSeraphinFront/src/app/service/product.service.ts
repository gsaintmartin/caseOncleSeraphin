import { Injectable } from '@angular/core';
import { Product } from 'src/app/product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  deleteProduct(id: number)  {
    throw new Error("Method not implemented.");
  }
  getProductsList(): Observable<Product[]> {
    throw new Error("Method not implemented.");
  }

  constructor() { }

  createProduct(product: Product): Observable<Product> {
    return;
  }
}
