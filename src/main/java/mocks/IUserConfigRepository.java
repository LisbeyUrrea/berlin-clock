package mocks;

public interface IUserConfigRepository {

    String passwordRegExp();

    String emailRegExp();

    String nickNameRegExp();

    String registerUser(UserManager userManager);
}
