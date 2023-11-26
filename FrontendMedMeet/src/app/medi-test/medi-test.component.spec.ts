import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MediTestComponent } from './medi-test.component';

describe('MediTestComponent', () => {
  let component: MediTestComponent;
  let fixture: ComponentFixture<MediTestComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MediTestComponent]
    });
    fixture = TestBed.createComponent(MediTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
