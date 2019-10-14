import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryAgricolesComponent } from './category-agricoles.component';

describe('CategoryAgricolesComponent', () => {
  let component: CategoryAgricolesComponent;
  let fixture: ComponentFixture<CategoryAgricolesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CategoryAgricolesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoryAgricolesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
