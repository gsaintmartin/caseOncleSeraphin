import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../service/product.service';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  defaultQuantity: number = 1;
  productAddedTocart: Product[];
  allTotal: number;

  deliveryForm: FormGroup;

  constructor(private productService:ProductService
  ) {}

  ngOnInit() {

}

onAddQuantity(product: Product) {
  //Get Product
  this.productAddedTocart = this.productService.getProductFromCart();
  this.productAddedTocart.find(p => p.id === product.id).stockQuantity = product.stockQuantity + 1;
  //Find produc for which we want to update the quantity

 //Push the product for cart
 // this.productAddedTocart.push(tempProd);
  this.productService.removeAllProductFromCart();
  this.productService.addProductToCart(this.productAddedTocart);
  this.calculteAllTotal(this.productAddedTocart);
  this.deliveryForm.controls['Amount'].setValue(this.allTotal);

}

calculteAllTotal(allItems: Product[])
  {
    let total = 0;
    for (let i in allItems) {
      total = total + (allItems[i].stockQuantity *allItems[i].price);
   }
    this.allTotal = total;
  }
}
