import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CouponCreateComponent } from './coupon-create.component';

describe('CouponCreateComponent', () => {
  let component: CouponCreateComponent;
  let fixture: ComponentFixture<CouponCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CouponCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CouponCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
