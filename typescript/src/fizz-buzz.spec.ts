import { of } from './fizz-buzz';
import { expect } from 'chai';
import 'mocha';

describe('FizzBuzz', () => {

  it('1 should return 1', () => {
    const result = of(1);
    expect(result).to.equal('1');
  });

});
