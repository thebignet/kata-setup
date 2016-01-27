var expect = require('chai').expect;

describe('Roulette', function() {
    var Roulette = require('../src/Roulette');

    describe('play()', function() {

        it('returns after 20s', function(done) {
            this.timeout(21000)
            var roulette = new Roulette();

            var timeb4 = new Date();
            roulette.play(resultCallback);

            function resultCallback() {
                var timeAfter = new Date();
                expect(timeAfter - timeb4).to.be.within(20000, 20100);
                done();
            }
        });
    });
});