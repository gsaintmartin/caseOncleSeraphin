import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDigitalProductComponent } from './add-digital-product.component';

describe('AddDigitalProductComponent', () => {
  let component: AddDigitalProductComponent;
  let fixture: ComponentFixture<AddDigitalProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddDigitalProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDigitalProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});