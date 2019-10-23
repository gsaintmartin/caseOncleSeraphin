import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateproductComponent } from './update-product.component';

describe('UpdateproductComponent', () => {
  let component: UpdateproductComponent;
  let fixture: ComponentFixture<UpdateproductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateproductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateproductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
