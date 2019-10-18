import { LinkedList } from 'ngx-bootstrap/utils/public_api';
import { Product } from './product';

export class Category {
  id: number;
  categoryName: string;
  listProducts: LinkedList<Product>;
   constructor(categoryName: string) {
    this.categoryName = categoryName;
  }
}
