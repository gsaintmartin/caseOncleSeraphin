import { Injectable } from '@angular/core';
<<<<<<< HEAD
<<<<<<< HEAD
import { Product } from 'src/app/product';
import { Observable } from 'rxjs';
=======
import { Product } from '../product';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
>>>>>>> c727b0416e8854a0e588f031e2822ca858c1fbd9
=======
import { Product } from '../product';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

>>>>>>> master

// Gipsy style
import { catchError, tap, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
<<<<<<< HEAD
<<<<<<< HEAD
  deleteProduct(id: number)  {
    throw new Error("Method not implemented.");
=======
=======

<<<<<<< HEAD
>>>>>>> master

  private baseUrl = 'http://localhost:8080/caseOncleSeraphin/api/';
=======
  private baseUrl = 'http://localhost:8080/caseOncleSeraphin/api/product';
>>>>>>> 58f3699155e14dcf05ae36f2599a009edf72c81c

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  /*
    company: string;
    price: number;
    stockQuantity: number;
    category: Category;
  */


  constructor(private httpClient: HttpClient) { }

  updateProduct(id, product: Product): Observable<any> {
    const url = `${this.baseUrl}/${id}`;
    return this.httpClient.put(url, product, this.httpOptions).pipe(
      tap(_ => console.log(`updated product id=${id}`)),
      catchError(this.handleError<any>('updateProduct'))
    );
  }


  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }


  getProduct(id: number): Observable<Product> {
    const url = `${this.baseUrl}/${id}`;
    return this.httpClient.get<Product>(url).pipe(
      tap(_ => console.log(`fetched product id=${id}`)),
      catchError(this.handleError<Product>(`getProduct id=${id}`))
    );
  }

  getProductsList(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.baseUrl)
      .pipe(
        tap(heroes => console.log('fetched products')),
        catchError(this.handleError('getProducts', []))
      );
  }

  createProduct(product: Product): Observable<Product> {
    return this.httpClient.post<Product>(this.baseUrl + 'products', product, this.httpOptions).pipe(
      // tslint:disable-next-line: no-shadowed-variable
      tap((product: Product) => console.log(`added product w/ id=${product.id}`)),
      catchError(this.handleError<Product>('addProduct'))
    );
  }

  deleteProduct(id): Observable<Product> {
    const url = `${this.baseUrl}/${id}`;

    return this.httpClient.delete<Product>(url, this.httpOptions).pipe(
      tap(_ => console.log(`deleted product id=${id}`)),
      catchError(this.handleError<Product>('deleteProduct'))
    );
  }

  getAllProducts(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.baseUrl)
<<<<<<< HEAD
    .pipe(
      tap(heroes => console.log('fetched products')),
      catchError(this.handleError('getProducts', []))
    );
>>>>>>> c727b0416e8854a0e588f031e2822ca858c1fbd9
  }
  getProductsList(): Observable<Product[]> {
    throw new Error("Method not implemented.");
  }
=======
      .pipe(
        tap(heroes => console.log('fetched products')),
        catchError(this.handleError('getProducts', []))
      );
>>>>>>> master

      }

<<<<<<< HEAD
  createProduct(product: Product): Observable<Product> {
    return;
  }
<<<<<<< HEAD
=======
  getProductsList(): Observable<any[]> {
    throw new Error("Method not implemented.");
  }
>>>>>>> c727b0416e8854a0e588f031e2822ca858c1fbd9
=======
>>>>>>> master
}
