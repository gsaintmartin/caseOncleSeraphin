import { Component, OnInit } from '@angular/core';
import { ProductService } from '../service/product.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Product2Citeres } from '../product2-citeres';
import { Product2CriteresService } from '../service/product2-criteres.service';

@Component({
  selector: 'app-show-data',
  templateUrl: './show-data.component.html',
  styleUrls: ['./show-data.component.css']
})
export class ShowDataComponent implements OnInit {

  constructor(private product2CritereService: Product2CriteresService) { }

  get Name()
  {
    return this.form.get('name');
  }

  get Category()
  {
    return this.form.get('category');
  }

  private product2Criteres = new Product2Citeres();
  private data;

  form = new FormGroup({
    name : new FormControl()
  });

  ngOnInit() {
    this.getData(this.product2Criteres);
  }


  getData(product2Criteres)
  {
      this.product2CritereService.getData(product2Criteres).subscribe(
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
        this.product2Criteres.categoryId = this.Category.value;
        this.product2Criteres.name = this.Name.value;
        this.getData(this.product2Criteres);
  }


}
