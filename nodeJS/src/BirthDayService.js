function BirthdayService(repository) {
    this.repository = repository;

}

BirthdayService.prototype = {
    greeting: function (name) {
        var greeting
        if (this.repository.isBirthdayTodayFor(name)) {
            greeting = "happy birtday " + name
        } else {
            greeting = "hello " + name
        }
        return greeting
    }
}

module.exports = BirthdayService;
