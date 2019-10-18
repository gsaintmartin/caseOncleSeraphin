import { Right } from './right';
import { LinkedList } from 'ngx-bootstrap/utils/public_api';


export class Role {

 id: number;
 name: string;
 rights: LinkedList<Right>;
 constructor(name: string) {
   this.name = name;
 }
}
