import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class Product2CriteresService {

  private baseUrl = 'http://localhost:8080/caseOncleSeraphin/api/';

  constructor(private httpClient: HttpClient) { }


  getData(product2CriteresService: Product2CriteresService)
  {
    const url = this.baseUrl + 'search';
    return  this.httpClient.post(url , product2CriteresService);
  }
}
