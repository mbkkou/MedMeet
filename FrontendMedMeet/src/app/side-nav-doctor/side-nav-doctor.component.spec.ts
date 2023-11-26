import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SideNavDoctorComponent } from './side-nav-doctor.component';

describe('SideNavDoctorComponent', () => {
  let component: SideNavDoctorComponent;
  let fixture: ComponentFixture<SideNavDoctorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SideNavDoctorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SideNavDoctorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
