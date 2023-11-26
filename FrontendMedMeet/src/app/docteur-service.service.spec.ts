import { TestBed } from '@angular/core/testing';

import { DocteurServiceService } from './docteur-service.service';

describe('DocteurServiceService', () => {
  let service: DocteurServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DocteurServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
