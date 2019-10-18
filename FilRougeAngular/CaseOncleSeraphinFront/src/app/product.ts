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
listCommandLines: LinkedList<CommandLine>;
  constructor(id: number, name: string, description: string, image: string, company: string, price: number, stockQuantity: number) {
    this.id = id;
		this.name= name;
		this.description = description;
		this.image = image;
		this.company = company;
		this.price = price;
    this.stockQuantity = stockQuantity;
  }
}
