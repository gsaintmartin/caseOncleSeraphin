import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TemplateViergeComponent } from './template-vierge.component';

describe('TemplateViergeComponent', () => {
  let component: TemplateViergeComponent;
  let fixture: ComponentFixture<TemplateViergeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TemplateViergeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TemplateViergeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
