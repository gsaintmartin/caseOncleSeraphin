import { Injectable } from '@angular/core';
import { Product } from '../product';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/caseOncleSeraphin/api/';

  constructor(private httpClient: HttpClient) { }

  getAll(): Observable<Product[]> {
    const headers: HttpHeaders = new HttpHeaders().set('Accept', 'application/json');

    return this.httpClient.get<Product[]>(this.baseUrl + 'products', { headers });
  }

  addProductToCart(product: any) {
    localStorage.setItem('product', JSON.stringify(product));
  }


  getProductFromCart(): Product[] {
    return JSON.parse(localStorage.getItem('product'));
  }

  removeAllProductFromCart() {
    return localStorage.removeItem('product');
  }

}
