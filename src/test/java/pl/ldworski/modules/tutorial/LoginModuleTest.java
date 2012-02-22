package pl.ldworski.modules.tutorial;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.BeforeClass;
import org.junit.Test;
import pl.ldworski.modules.tutorial.container.TutorialModule;
import pl.ldworski.modules.tutorial.dao.LdapAuthenticationDao;
import pl.ldworski.modules.tutorial.service.LoginService;
import pl.ldworski.modules.tutorial.service.MailService;
import pl.ldworski.modules.tutorial.util.MailServerProperties;

import static org.junit.Assert.*;

public class LoginModuleTest {

    static Injector injector;

    @BeforeClass
    public static void setUp() {
        injector = Guice.createInjector(new TutorialModule());
    }

    @Test
    public void shouldLoginServiceBeCreatedWithGuice() throws Exception {
        // given
        // when
        LoginService loginService = injector.getInstance(LoginService.class);
        // then
        assertNotNull(loginService);
        assertNotNull(loginService.getAuthentincationDao());
        assertTrue(loginService.getAuthentincationDao() instanceof LdapAuthenticationDao);
    }

    @Test
    public void shouldGetMailingServiceWithFieldsSet() throws Exception {
        // given
        // when
        MailService mailingService = injector.getInstance(MailService.class);
        // then
        assertNotNull(mailingService);
        assertEquals(MailServerProperties.USER_NAME, mailingService.getLogin());
        assertEquals(MailServerProperties.MAIL_SERVER_ADDRES, mailingService.getMailServerAddress());
        assertEquals(MailServerProperties.MAIL_SERVER_PASSWORD, mailingService.getMailServerPassword());
    }

    @Test
    public void shouldReturnNewInstancesOfLoginService() throws Exception {
        // given
        // when
        LoginService firstInstance = injector.getInstance(LoginService.class);
        LoginService secondInstance = injector.getInstance(LoginService.class);
        // then
        assertFalse(firstInstance == secondInstance);
    }

    @Test
    public void shouldAuthenticationDaoBeInSingletonScope() throws Exception {
        // given
        // when
        LoginService firstInstance = injector.getInstance(LoginService.class);
        LoginService secondInstance = injector.getInstance(LoginService.class);
        // then
        assertTrue(firstInstance.getAuthentincationDao()==secondInstance.getAuthentincationDao());
    }
}
