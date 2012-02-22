package pl.ldworski.modules.tutorial.dao;

public class LdapAuthenticationDao implements AuthenticationDao {

    @Override
    public boolean authenticate(String login, String password) {
        // connect to LDAP and check credentials
        return true;
    }
}
