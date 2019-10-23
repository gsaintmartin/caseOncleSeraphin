import { Injectable } from '@angular/core';
import { Product } from '../product';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';


// Gipsy style
import { catchError, tap, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  addProductToCart(productAddedTocart: Product[]) {
    throw new Error("Method not implemented.");
  }
  removeAllProductFromCart() {
    throw new Error("Method not implemented.");
  }
  getProductFromCart(): Product[] {
    throw new Error("Method not implemented.");
  }


  private baseUrl = 'http://localhost:8080/caseOncleSeraphin/api/product';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin' : '*' })
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
      .pipe(
        tap(heroes => console.log('fetched products')),
        catchError(this.handleError('getProducts', []))
      );

      }

}
