import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Product2Citeres } from '../product2-citeres';
import { Product } from '../product';

@Injectable({
  providedIn: 'root'
})
export class Product2CriteresService {

  private baseUrl = 'http://localhost:8080/caseOncleSeraphin/api/';

  constructor(private httpClient: HttpClient) { }


  getData(product2Critere: Product2Citeres)
  {
    const url = this.baseUrl + 'products/search';
    const params = new  HttpParams()
      .set('name', product2Critere.name);
      //.set('category', product2Critere.categoryId);
    return  this.httpClient.get<Product[]>(url, { params });
  }
}
