import { Category } from './category';
import { LinkedList } from 'ngx-bootstrap/utils/public_api';
import { CommandLine } from './command-line';

export class Product {
  id: number;
  name: string;
  description: string;
  image: string;
  company: string;
  price: number;
  stockQuantity: number;
  category: Category;
  //listCommandLines: LinkedList<CommandLine>;
}
