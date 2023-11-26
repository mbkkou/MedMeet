import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MediFolderComponent } from './medi-folder.component';

describe('MediFolderComponent', () => {
  let component: MediFolderComponent;
  let fixture: ComponentFixture<MediFolderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MediFolderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MediFolderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
