package qotd

class QuoteController {

    // In previous versions of Grails, I think this was done like "static scaffold = true"
    static scaffold = Quote
    static defaultAction = "home"
    // Grails Inversion of Control / dependency injection to the rescue!
    def quoteService

    def home() {
        render "<h1>Real Programmers do not eat Quiche</h1>"
    }

    def random() {
        // new Quote(author: 'Larry Wall', content: 'There is more than one method to our madness.').save()
        // new Quote(author: 'Chuck Norris Facts', content: 'Chuck Norris always uses his own design patterns, and his favorite is the Roundhouse Kick.').save()
        // new Quote(author: 'Eric Raymond', content: 'Being a social outcast helps you stay concentrated on the really important things, like thinking and hacking.').save()

        def randomQuote = quoteService.getRandomQuote()
        [ quote : randomQuote ]
    }
}
