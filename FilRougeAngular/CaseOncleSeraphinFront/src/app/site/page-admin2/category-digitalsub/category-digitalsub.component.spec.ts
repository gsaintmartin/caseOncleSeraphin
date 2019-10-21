import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CategoryDigitalsubComponent } from './category-digitalsub.component';

describe('CategoryDigitalsubComponent', () => {
  let component: CategoryDigitalsubComponent;
  let fixture: ComponentFixture<CategoryDigitalsubComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CategoryDigitalsubComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CategoryDigitalsubComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
