import { of, until } from './fizz-buzz';
import { expect } from 'chai';
import 'mocha';

describe('FizzBuzz', () => {

  it('1 should return 1', () => {
    const result = of(1);
    expect(result).to.equal('1');
  });

  it('2 should return 2', () => {
    const result = of(2);
    expect(result).to.equal('2');
  });

  it('3 should return Fizz', () => {
    const result = of(3);
    expect(result).to.equal('Fizz');
  });

  it('5 should return Buzz', () => {
    const result = of(5);
    expect(result).to.equal('Buzz');
  });

  it('6 should return Fizz', () => {
    const result = of(6);
    expect(result).to.equal('Fizz');
  });

  it('10 should return Buzz', () => {
    const result = of(10);
    expect(result).to.equal('Buzz');
  });

  it('15 should return FizzBuzz', () => {
    const result = of(15);
    expect(result).to.equal('FizzBuzz');
  });

  it('30 should return FizzBuzz', () => {
    const result = of(30);
    expect(result).to.equal('FizzBuzz');
  });

  it('FizzBuzz from 0 to 15', () => {
    const result = until(15);
    expect(result).to.equal('1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz');
  });

});
