package pl.ldworski.modules.tutorial.container;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import pl.ldworski.modules.tutorial.dao.AuthenticationDao;
import pl.ldworski.modules.tutorial.dao.LdapAuthenticationDao;
import pl.ldworski.modules.tutorial.dao.SqlAuthentictionDao;
import pl.ldworski.modules.tutorial.service.MailService;
import pl.ldworski.modules.tutorial.util.MailServerProperties;

import javax.inject.Singleton;

public class TutorialModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(AuthenticationDao.class).annotatedWith(Names.named("Ldap")).
                to(LdapAuthenticationDao.class).in(Singleton.class);
        bind(AuthenticationDao.class).annotatedWith(Names.named("Sql")).to(SqlAuthentictionDao.class).in(Singleton.class);
    }

    @Provides
    public MailService getMailingService() {
        return new MailService(MailServerProperties.MAIL_SERVER_ADDRES,
                MailServerProperties.USER_NAME, MailServerProperties.MAIL_SERVER_PASSWORD);
    }
}
