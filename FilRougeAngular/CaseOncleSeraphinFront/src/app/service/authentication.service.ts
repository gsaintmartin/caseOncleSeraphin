import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor( private httpClient: HttpClient) { }

  authenticate(username, password): Observable<User> {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.httpClient.get<User>('http://localhost:8080/caseOncleSeraphin/api/users/authenticate', { headers }).pipe(
      map(
        userData => {
          sessionStorage.setItem('username', username);
          const authString = 'Basic ' + btoa(username + ':' + password);
          sessionStorage.setItem('basicauth', authString);
          console.log(userData);
          return userData;
        }
      )
    );
  }

  // subscribe() {
  //   // tslint:disable-next-line: no-unused-expression
  //   (response) => {
  //     sessionStorage.setItem('username', username);
  //     const authString = 'Basic ' + btoa(username + ':' + password);
  //     sessionStorage.setItem('basicauth', authString);
  //     console.log(response);
  //     return response;
  //   },
  //   (error) => {
  //     errorCallback();
  //   }
  // };

  isUserLoggedIn() {
    const user = sessionStorage.getItem('username');
    console.log(!(user === null));
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem('username');
  }
}
