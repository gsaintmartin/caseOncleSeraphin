import { TestBed } from '@angular/core/testing';

import { Product2CriteresService } from './product2-criteres.service';

describe('Product2CriteresService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Product2CriteresService = TestBed.get(Product2CriteresService);
    expect(service).toBeTruthy();
  });
});
