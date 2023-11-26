import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupdocteurComponent } from './signupdocteur.component';

describe('SignupdocteurComponent', () => {
  let component: SignupdocteurComponent;
  let fixture: ComponentFixture<SignupdocteurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SignupdocteurComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SignupdocteurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
