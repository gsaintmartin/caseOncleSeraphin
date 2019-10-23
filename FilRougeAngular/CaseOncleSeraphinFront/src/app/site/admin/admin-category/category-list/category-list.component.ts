import { CategoryDetailsComponent } from '../category-details/category-details.component';
import { Observable } from 'rxjs';
import { CategoryService } from '../../../../service/category.service';
<<<<<<< HEAD
// tslint:disable-next-line: max-line-length
import { Category } from 'C:/Users/formation/Desktop/caseOncleSeraphin/caseOncleSeraphin/FilRougeAngular/CaseOncleSeraphinFront/src/app/category';
=======
// tslint:disable-next-line: max-line-length;
>>>>>>> 83fc68575d203433ec895006d3ccd08b1ff96869
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/category';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {
  categorys: Observable<Category[]>;

  constructor(private categoryService: CategoryService,
              private router: Router) {}

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.categorys = this.categoryService.getCategorysList();
  }

  deleteCategory(id: number) {
    this.categoryService.deleteCategory(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  categoryDetails(id: number) {
    this.router.navigate(['details', id]);
  }
}
