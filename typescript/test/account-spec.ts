
import * as chai from 'chai';

const expect = chai.expect;

class Account {

  public printStatement() {
    return;
  }

  public deposit(amount: number) {
    return;
  }

  public withdraw(amount: number) {
    return;
  }
}

describe('account', () => {
  it.skip('does something', () => {
    const account = new Account();
    account.deposit(500);
    account.withdraw(100);
    const statementString = account.printStatement();
    expect(statementString).to.equal(`
Date        Amount  Balance
24.12.2015   +500      500
23.8.2016    -100      400
    `);
  });

});
