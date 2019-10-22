import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateVendorsComponent } from './create-vendors.component';

describe('CreateVendorsComponent', () => {
  let component: CreateVendorsComponent;
  let fixture: ComponentFixture<CreateVendorsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateVendorsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateVendorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});