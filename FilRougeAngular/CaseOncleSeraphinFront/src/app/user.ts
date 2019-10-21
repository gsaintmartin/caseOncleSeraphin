

import { Role } from './role';
import { LinkedList } from 'ngx-bootstrap/utils/public_api';
import { Command } from 'selenium-webdriver';
import { Contact } from './contact';

export class User {
  id: number;
  name: string;
  firstName: string;
  userName: string;
  email: string;
  adress: string;
  phone: string;
  password: string;
  creationDate: Date;
  status: string;
  role: Role;

listCommands: LinkedList<Command>;
listContacts: LinkedList<Contact>;
  // tslint:disable-next-line: max-line-length
  User(name: string, firstName: string, userName: string, email: string, adress: string, phone: string, password: string, creationDate: Date, role: Role) {
  this.name = name;
  this.firstName = firstName;
  this.userName = userName;
  this.email = email;
  this.adress = adress;
  this.phone = phone;
  this.password = password;
  this.creationDate = creationDate;
  this.role = role;
}
<<<<<<< HEAD
<<<<<<< HEAD
   constructor() {}

=======
>>>>>>> Pierre
}
=======

>>>>>>> 83e7af14352a95348eeb3f0ceb66a481e01d604f
