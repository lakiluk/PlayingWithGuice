package pl.ldworski.modules.tutorial.service;

public class MailService {

    private String mailServerAddress;
    private String login;
    private String mailServerPassword;

    public MailService(String mailServerAddress, String login, String mailServerPassword) {
        this.mailServerAddress = mailServerAddress;
        this.login = login;
        this.mailServerPassword = mailServerPassword;
    }

    public String getMailServerAddress() {
        return mailServerAddress;
    }

    public String getLogin() {
        return login;
    }

    public String getMailServerPassword() {
        return mailServerPassword;
    }
}
