import { User } from './user';

export class Contact {
  id: number;
  user: User;
  message: string;

  constructor(id: number, message: string){
    this.id = id;
    this.message = message;
  }
}
