package mocks;

import java.util.List;

public interface IUserConfigRepository {

    String passwordRegExp();

    String emailRegExp();

    String nickNameRegExp();

    String registerUser(UserManager userManager);

    List<UserManager> findAll();

    UserManager findUser(Integer idUser);
}
