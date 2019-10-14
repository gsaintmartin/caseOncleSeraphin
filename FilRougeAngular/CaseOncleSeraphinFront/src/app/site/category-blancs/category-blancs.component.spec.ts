import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryBlancsComponent } from './category-blancs.component';

describe('CategoryBlancsComponent', () => {
  let component: CategoryBlancsComponent;
  let fixture: ComponentFixture<CategoryBlancsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CategoryBlancsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoryBlancsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
