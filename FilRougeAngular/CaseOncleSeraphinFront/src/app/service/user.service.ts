import { Injectable } from '@angular/core';
import { User } from 'src/app/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  deleteUser(id: number): Observable<User> {
    throw new Error("Method not implemented.");
  }
  getUsersList(): Observable<any[]> {
    throw new Error("Method not implemented.");
  }
  createUser(user: User): Observable<User> {
    return;
  }

  constructor() { }
}

