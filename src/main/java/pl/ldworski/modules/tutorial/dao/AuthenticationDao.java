package pl.ldworski.modules.tutorial.dao;

public interface AuthenticationDao {
    
    public boolean authenticate(String login, String password);
}
