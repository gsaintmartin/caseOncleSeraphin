import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnimateComponentComponent } from './animate-component.component';

describe('AnimateComponentComponent', () => {
  let component: AnimateComponentComponent;
  let fixture: ComponentFixture<AnimateComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnimateComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnimateComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
