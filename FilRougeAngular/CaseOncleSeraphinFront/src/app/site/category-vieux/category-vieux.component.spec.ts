import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryVieuxComponent } from './category-vieux.component';

describe('CategoryVieuxComponent', () => {
  let component: CategoryVieuxComponent;
  let fixture: ComponentFixture<CategoryVieuxComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CategoryVieuxComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoryVieuxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
