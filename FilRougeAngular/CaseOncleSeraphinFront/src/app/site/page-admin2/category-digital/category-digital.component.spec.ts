import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryDigitalComponent } from './category-digital.component';

describe('CategoryDigitalComponent', () => {
  let component: CategoryDigitalComponent;
  let fixture: ComponentFixture<CategoryDigitalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CategoryDigitalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoryDigitalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
