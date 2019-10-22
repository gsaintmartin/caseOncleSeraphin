import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LogoutService {
   private logout = 'http://localhost:8080/caseOncleSeraphin/logout/';
  static httpClient: any;

  constructor(private httpClient: HttpClient) { }


   static logoutBack() {
    const headers: HttpHeaders = new HttpHeaders().set('Accept', 'application/json');
    return this.httpClient;
  }



}
