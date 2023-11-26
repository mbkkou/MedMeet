import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogindocteurComponent } from './logindocteur.component';

describe('LogindocteurComponent', () => {
  let component: LogindocteurComponent;
  let fixture: ComponentFixture<LogindocteurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LogindocteurComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LogindocteurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
