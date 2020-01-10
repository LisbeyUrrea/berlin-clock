package mocks;

public class ManagerUserBl {

    private IUserConfigRepository userConfigRepository;

    public ManagerUserBl(IUserConfigRepository userConfigRepository) {
        this.userConfigRepository = userConfigRepository;
    }

    public boolean validatePassword(String password) {

        String regExp = userConfigRepository.passwordRegExp();

        return password.matches(regExp);
    }
}
