import { Injectable } from '@angular/core';
import { Product } from '../product';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

<<<<<<< HEAD

  private baseUrl = 'http://localhost:8080/caseOncleSeraphin/api/products/';
=======
  private baseUrl = 'http://localhost:8080/caseOncleSeraphin/api/';

>>>>>>> 6d895475ba30605fbb94505e375e6ea3527f3e4d

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Product[]> {
    const headers: HttpHeaders = new HttpHeaders().set('Accept', 'application/json');

    return this.httpClient.get<Product[]>(this.baseUrl + 'products', { headers });
  }

  getData(product: Product)
  {
    const url = this.baseUrl + 'search';
    return  this.httpClient.post(url , product);
  }


  addProductToCart(product: any) {
    localStorage.setItem("product", JSON.stringify(product));
  }

<<<<<<< HEAD
  addProductToCart(product: any) {
    localStorage.setItem("product", JSON.stringify(product));
  }

=======
>>>>>>> 6d895475ba30605fbb94505e375e6ea3527f3e4d
  getProductFromCart(): Product[] {
    return JSON.parse(localStorage.getItem('product'));
  }

  removeAllProductFromCart() {
    return localStorage.removeItem("product");
  }

<<<<<<< HEAD
=======

>>>>>>> 6d895475ba30605fbb94505e375e6ea3527f3e4d
}
