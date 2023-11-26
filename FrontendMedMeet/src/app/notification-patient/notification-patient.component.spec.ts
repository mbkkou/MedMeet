import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotificationPatientComponent } from './notification-patient.component';

describe('NotificationPatientComponent', () => {
  let component: NotificationPatientComponent;
  let fixture: ComponentFixture<NotificationPatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NotificationPatientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NotificationPatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
