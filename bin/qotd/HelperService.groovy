package qotd

import grails.gorm.transactions.Transactional

@Transactional
class HelperService {

    def getMagicNumber() {
        42
    }
}
