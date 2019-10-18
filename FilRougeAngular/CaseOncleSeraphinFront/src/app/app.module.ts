import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
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

import { AnimateComponentComponent } from './animate-component/animate-component.component';
import { ProductSliderComponent } from './product-slider/product-slider.component';

import { AuthGuardService} from './service/auth-guard.service';

import { AddDigitalProductComponent } from './site/page-admin2/add-digital-product/add-digital-product.component';
import { AddProductComponent } from './site/page-admin2/add-product/add-product.component';
import { CategoryComponent } from './site/page-admin2/category/category.component';
import { CategoryDigitalComponent } from './site/page-admin2/category-digital/category-digital.component';
import { CategoryDigitalsubComponent } from './site/page-admin2/category-digitalsub/category-digitalsub.component';
import { CouponCreateComponent } from './site/page-admin2/coupon-create/coupon-create.component';
import { CouponListComponent } from './site/page-admin2/coupon-list/coupon-list.component';
import { CreateMenuComponent } from './site/page-admin2/create-menu/create-menu.component';
import { CreateUserComponent } from './site/page-admin2/create-user/create-user.component';
import { CreateVendorsComponent } from './site/page-admin2/create-vendors/create-vendors.component';
import { CurrencyRatesComponent } from './site/page-admin2/currency-rates/currency-rates.component';
import { InvoiceComponent } from './site/page-admin2/invoice/invoice.component';
import { MediaComponent } from './site/page-admin2/media/media.component';
import { OrderComponent } from './site/page-admin2/order/order.component';
import { PageCreateComponent } from './site/page-admin2/page-create/page-create.component';
import { PagesListComponent } from './site/page-admin2/pages-list/pages-list.component';
import { ProductDetailComponent } from './site/page-admin2/product-detail/product-detail.component';
import { ProductListComponent } from './site/page-admin2/product-list/product-list.component';
import { ProductListdigitalComponent } from './site/page-admin2/product-listdigital/product-listdigital.component';
import { ProfileComponent } from './site/page-admin2/profile/profile.component';
import { ReportsComponent } from './site/page-admin2/reports/reports.component';
import { TaxesComponent } from './site/page-admin2/taxes/taxes.component';
import { TransactionsComponent } from './site/page-admin2/transactions/transactions.component';
import { TranslationsComponent } from './site/page-admin2/translations/translations.component';
import { UserListComponent } from './site/page-admin2/user-list/user-list.component';
import { IndexComponent } from './site/page-admin2/index/index.component';


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
  { path: 'page_admin', canActivate: [AuthGuardService], component: PageAdminComponent },
  { path: 'product', component: ProductComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent },
  { path: 'add_digital_product', component: AddDigitalProductComponent },
  { path: 'add_product', component: AddProductComponent },
  { path: 'category', component: CategoryComponent },
  { path: 'category_digital', component: CategoryDigitalComponent },
  { path: 'category_digitalsub', component: CategoryDigitalsubComponent },
  { path: 'coupon_list', component: CouponListComponent },
  { path: 'create_menu', component: CreateMenuComponent },
  { path: 'create_user', component: CreateUserComponent },
  { path: 'create_vendors', component: CreateVendorsComponent },
  { path: 'invoice', component: InvoiceComponent },
  { path: 'media', component: MediaComponent },
  { path: 'page_create', component: PageCreateComponent },
  { path: 'pages_list', component: PagesListComponent },
  { path: 'product_detail', component: ProductDetailComponent },
  { path: 'product_list', component: ProductListComponent },
  { path: 'product_listdigital', component: ProductListdigitalComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'reports', component: ReportsComponent },
  { path: 'taxes', component: TaxesComponent },
  { path: 'transactions', component: TransactionsComponent },
  { path: 'translations', component: TranslationsComponent },
  { path: 'user_list', component: UserListComponent },
  { path: 'index', component: IndexComponent },


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

    AnimateComponentComponent,
    ProductSliderComponent,

     AddDigitalProductComponent,
     AnimateComponentComponent,
     AddProductComponent,
     ProductSliderComponent,
     CategoryComponent,
     CategoryDigitalComponent,
     CategoryDigitalsubComponent,
     CouponCreateComponent,
     CouponListComponent,
     CreateMenuComponent,
     CreateUserComponent,
     CreateVendorsComponent,
     CurrencyRatesComponent,
     InvoiceComponent,
     MediaComponent,
     OrderComponent,
     PageCreateComponent,
     PagesListComponent,
     ProductDetailComponent,
     ProductListComponent,
     ProductListdigitalComponent,
     ProfileComponent,
     ReportsComponent,
     TaxesComponent,
     TransactionsComponent,
     TranslationsComponent,
     UserListComponent,
     IndexComponent,

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
