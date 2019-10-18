import { Product } from './product';
import { Command } from './command';

export class CommandLine {
id: number;
quantity: number;
product: Product;
command: Command;

public CommandLine(quantity: number) {
  this.quantity = quantity;
}
}
