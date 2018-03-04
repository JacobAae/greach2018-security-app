package net.grydeske.security

import grails.gorm.transactions.Transactional

@Transactional
class OtherLoginService {

    boolean isAllowedAccess(String username, String password) {
        String query = "from MyUser as U where U.username = '${username}' and U.password = '${password}'"
        def results = MyUser.findAll(query)

        return results.size() > 0
    }
}
