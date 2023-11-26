import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentpatientComponent } from './documentpatient.component';

describe('DocumentpatientComponent', () => {
  let component: DocumentpatientComponent;
  let fixture: ComponentFixture<DocumentpatientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentpatientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DocumentpatientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
