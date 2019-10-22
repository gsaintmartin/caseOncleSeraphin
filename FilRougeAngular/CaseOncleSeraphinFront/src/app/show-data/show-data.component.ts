import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductService } from '../service/product.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-show-data',
  templateUrl: './show-data.component.html',
  styleUrls: ['./show-data.component.css']
})
export class ShowDataComponent implements OnInit {

  private product = new Product();
  private data;

  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.getData(this.product);
  }

  // form = new FormGroup({
  //   name : new FormControl()
  // });


  getData(product)
  {
      this.productService.getData(product).subscribe(
        response => {
         console.log(this.data);
        },
        error => {
          console.log('error while getting user Details');
        }
      );
  }

  searchForm(searchInfo)
  {
        this.product.category = this.Category.value;
        this.product.name = this.Name.value;
        this.getData(this.product);
  }

  get Name()
  {
    return this.form.get('name');
  }

  get Category()
  {
    return this.form.get('category');
  }


}
