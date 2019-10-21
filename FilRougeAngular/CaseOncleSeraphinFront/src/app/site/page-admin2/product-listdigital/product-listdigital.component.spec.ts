import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductListdigitalComponent } from './product-listdigital.component';

describe('ProductListdigitalComponent', () => {
  let component: ProductListdigitalComponent;
  let fixture: ComponentFixture<ProductListdigitalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductListdigitalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductListdigitalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
