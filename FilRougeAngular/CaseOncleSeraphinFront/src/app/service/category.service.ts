import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Category } from 'src/app/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  createCategory(category: any): Observable<Category>  {
    throw new Error("Method not implemented.");
  }
  baseUrl = 'http://localhost:8080/api/categories/';

  constructor(private httpClient: HttpClient) { }

  getCategorysList(): Observable<any[]> {
    throw new Error("Method not implemented.");
  }
  deleteCategory(id: number) {
    return this.httpClient.delete(this.baseUrl + id);
  }
}
