package qotd

import grails.gorm.transactions.Transactional


import org.grails.orm.hibernate.HibernateDatastore
import org.springframework.test.annotation.Rollback
import org.springframework.transaction.PlatformTransactionManager
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification
import spock.lang.AutoCleanup
import spock.lang.Shared

@Transactional
class QuoteServiceSpec extends Specification implements ServiceUnitTest<QuoteService>{

    @Shared 
    QuoteService quoteService

    @Shared 
    @AutoCleanup 
    HibernateDatastore hibernateDatastore

    @Shared 
    PlatformTransactionManager transactionManager

    void setupSpec() {
        hibernateDatastore = new HibernateDatastore(Quote) 
        transactionManager = hibernateDatastore.getTransactionManager() 
        // quoteService = this.hibernateDatastore.getService(QuoteService)
    }

    @Rollback
    void "static quote service alwasys returns quiche quote"() {
        // expect:"fix me"
        //     true == false

        expect:
        service.staticQuote.author == "Anonymous"
        service.staticQuote.content == "Real Programmers Don't eat much quicheQuiche"
    }
}
