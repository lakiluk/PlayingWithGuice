package pl.ldworski.modules.tutorial.dao;

public class SqlAuthentictionDao implements AuthenticationDao{
    @Override
    public boolean authenticate(String login, String password) {
        // connects to sql database and resolve authentication
        return true;
    }
}
