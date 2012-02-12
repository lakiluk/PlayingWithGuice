package pl.ldworski.modules.tutorial.service;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import pl.ldworski.modules.tutorial.dao.AuthenticationDao;

public class LoginService {

    private AuthenticationDao authentincationDao;

    @Inject
    LoginService(@Named("Ldap") AuthenticationDao authentincationDao) {
        this.authentincationDao = authentincationDao;
    }

    public AuthenticationDao getAuthentincationDao() {
        return authentincationDao;
    }
}
