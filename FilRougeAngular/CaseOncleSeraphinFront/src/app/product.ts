import { Category } from './category';


export class Product {
  id: number;
  name: string;
  description: string;
  image: string;
  company: string;
  price: number;
  stockQuantity: number;
  category: Category;
  // listCommandLines: LinkedList<CommandLine>;
}
