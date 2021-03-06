import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { CartComponent } from './cart/cart.component';
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

import { AnimateComponentComponent } from './animate-component/animate-component.component';
import { ProductSliderComponent } from './product-slider/product-slider.component';
import { AuthGuardService } from './service/auth-guard.service';
import { ShowDataComponent } from './show-data/show-data.component';
import { Product2CriteresService } from './service/product2-criteres.service';





import { ProductDetailsComponent } from './site/admin/admin-product/product-details/product-details.component';
import { ProductListComponent } from './site/admin/admin-product/product-list/product-list.component';
import { UpdateproductComponent } from './site/admin/admin-product/update-product/update-product.component';


import { CategoryDetailsComponent } from './site/admin/admin-category/category-details/category-details.component';
import { CategoryListComponent } from './site/admin/admin-category/category-list/category-list.component';

import { UserListComponent } from './site/admin/admin-user/user-list/user-list.component';
import { UserDetailsComponent } from './site/admin/admin-user/user-details/user-details.component';

import { CreateproductComponent } from './site/admin/admin-product/create-product/create-product.component';
import { CreatecategoryComponent } from './site/admin/admin-category/create-category/create-category.component';
import { CreateuserComponent } from './site/admin/admin-user/create-user/create-user.component';








const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'index', component: HomeComponent },
  { path: 'cart', canActivate: [AuthGuardService], component: CartComponent },
  { path: 'category_agricoles', component: CategoryAgricolesComponent },
  { path: 'category_all', component: CategoryAllComponent },
  { path: 'category_blancs', component: CategoryBlancsComponent },
  { path: 'category_vieux', component: CategoryVieuxComponent },
  { path: 'checkout', component: CheckoutComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'page_admin', /*canActivate: [AuthGuardService],*/ component: PageAdminComponent },
  { path: 'product', component: ProductComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },


  { path: 'create_category', component: CreatecategoryComponent },
 { path: 'create_user', component: CreateuserComponent },
  { path: 'create_product', component: CreateproductComponent },

  { path: 'product_list', component: ProductListComponent },
  { path: 'user_list', component: UserListComponent },
  { path: 'category_list', component: CategoryListComponent },
  { path: 'product_details', component: ProductDetailsComponent },
  { path: 'user_details', component: UserDetailsComponent },
  { path: 'category_details', component: CategoryDetailsComponent },
  { path: 'update_product/:id', component: UpdateproductComponent },

  { path: 'not-found', component: Erreur404Component },
  { path: '**', redirectTo: '/not-found' },
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
    LogoutComponent,

    ShowDataComponent,
    AnimateComponentComponent,
    ProductSliderComponent,
    CreateuserComponent,
    UserListComponent,
    UserDetailsComponent,
    ProductListComponent,
    ProductDetailsComponent,
    CreateproductComponent,
    UpdateproductComponent,
    CategoryListComponent,
    CreatecategoryComponent,
    CategoryDetailsComponent,




  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    NgbModule,
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    CarouselModule.forRoot(),
    NgbModule,
    FormsModule,


  ],
  providers: [Product2CriteresService,
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
