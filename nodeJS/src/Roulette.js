function Roulette(delay) {
    this.delay = delay || 20000;

}

Roulette.prototype = {
    play: function (resultCallback) {
        var result = 35;
        setTimeout(
            function () {
                resultCallback(result)
            },
            this.delay)
    }
}

module.exports = Roulette;
