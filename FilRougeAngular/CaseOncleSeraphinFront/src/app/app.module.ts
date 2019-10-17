import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';

import { CartComponent } from './site/cart/cart.component';
import { CategoryAgricolesComponent } from './site/category-agricoles/category-agricoles.component';
import { CategoryAllComponent } from './site/category-all/category-all.component';
import { CategoryBlancsComponent } from './site/category-blancs/category-blancs.component';
import { CategoryVieuxComponent } from './site/category-vieux/category-vieux.component';
import { CheckoutComponent } from './site/checkout/checkout.component';
import { ContactComponent } from './site/contact/contact.component';
import { PageAdminComponent } from './site/page-admin/page-admin.component';
import { ProductComponent } from './site/product/product.component';
import { RegisterComponent } from './site/register/register.component';
import { TemplateViergeComponent } from './site/template-vierge/template-vierge.component';
import { FooterComponent } from './layout/footer/footer.component';
import { NavbarCustomerComponent } from './layout/navbar-customer/navbar-customer.component';
import { Routes, RouterModule } from '@angular/router';
import { Erreur404Component } from './site/erreur404/erreur404.component';
import { APP_BASE_HREF } from '@angular/common';
import { HomeComponent } from './site/home/home.component';
import { CarouselComponent } from './carousel/carousel.component';
import { CarouselModule } from 'ngx-bootstrap/carousel';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';

const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'index', component: HomeComponent },
  { path: 'cart', component: CartComponent },
  { path: 'category_agricoles', component: CategoryAgricolesComponent },
  { path: 'category_all', component: CategoryAllComponent },
  { path: 'category_blancs', component: CategoryBlancsComponent },
  { path: 'category_vieux', component: CategoryVieuxComponent },
  { path: 'checkout', component: CheckoutComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'page_admin', component: PageAdminComponent },
  { path: 'product', component: ProductComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
  // { path: 'auth', component: AuthComponent },
  // { path: 'appareils/:id', canActivate : [AuthGuard], component: SingleAppareilComponent },
  { path: 'not-found', component: Erreur404Component },
  { path: '**', redirectTo: '/not-found' }
];

@NgModule({
  declarations: [
    AppComponent,
    CartComponent,
    CategoryAgricolesComponent,
    CategoryAllComponent,
    CategoryBlancsComponent,
    CategoryVieuxComponent,
    CheckoutComponent,
    ContactComponent,
    PageAdminComponent,
    ProductComponent,
    RegisterComponent,
    TemplateViergeComponent,
    FooterComponent,
    NavbarCustomerComponent,
    Erreur404Component,
    HomeComponent,
    CarouselComponent,
    LoginComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    NgbModule,

    CarouselModule.forRoot(),
    NgbModule,
    FormsModule
  ],
  providers: [
    {
      provide: APP_BASE_HREF, useValue: '/'
    }
  ],
  bootstrap: [
    AppComponent
  ],
  entryComponents: [NavbarCustomerComponent]
})
export class AppModule { }
