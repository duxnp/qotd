package qotd

import grails.gorm.transactions.*
import grails.testing.services.ServiceUnitTest
import org.springframework.transaction.PlatformTransactionManager
import spock.lang.Specification

class HelperServiceSpec extends Specification implements ServiceUnitTest<HelperService>{

    @Shared PlatformTransactionManager transactionManager 

    void setupSpec() {
        // hibernateDatastore = new HibernateDatastore(Person)
        transactionManager = hibernateDatastore.getTransactionManager() 
    }

    @Transactional
    def setup() {
    }

    def cleanup() {
    }

    @Rollback
    void "test retrieving a property"() {
        expect:
        service.magicNumber == 42
    }
}
