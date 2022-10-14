package qotd

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class QuoteServiceSpec extends Specification implements ServiceUnitTest<QuoteService>{

    def setup() {
    }

    def cleanup() {
    }

    void "static quote service alwasys returns quiche quote"() {
        // expect:"fix me"
        //     true == false

        expect:
        service.staticQuote.author == "Anynymous"
        service.staticQuote.content == "Real Programmers Don't eat much quicheQuiche"
    }
}
