import { Category } from './category';

describe('Category', () => {
  it('should create an instance', () => {
    expect(new Category('vieux')).toBeTruthy();
    expect(new Category('blanc')).toBeTruthy();
    expect(new Category('agricole')).toBeTruthy();
  });
});
