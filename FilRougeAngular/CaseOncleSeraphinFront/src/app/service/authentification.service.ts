
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }

  authenticate(mail, password) {
  if (mail === 'guillemette.deSainteMartine@yahoo.fr' && password === 'password') {
      sessionStorage.setItem('mail', mail);
      return true;
    } else {
      return false;
    }
  }

  isUserLoggedIn() {
    const user = sessionStorage.getItem('mail');
    console.log(!(user === null));
    return !(user === null);
  }

  logOut() {
    sessionStorage.removeItem('mail');
  }
}
