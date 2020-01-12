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

    public boolean validateEmail(String email) {
        String regExp = userConfigRepository.emailRegExp();
        return email.matches(regExp);
    }

    public boolean validateNickName(String nickName) {
        String regExp = userConfigRepository.nickNameRegExp();
        return nickName.matches(regExp);
    }

    public boolean validateNullOrEmpty(String param) {
        return param == null ? false:
                param.equals("") ? false: true;
    }


    public boolean isNumber(String number) {
        return number.matches("^[0-9]*$");
    }

    public String registerUser(UserManager user) {
        return isValidUser(user) ? userConfigRepository.registerUser(user) : "";

    }

    private boolean isValidUser(UserManager user) {

        if(!(validateNullOrEmpty(user.getName()) )) throw new IllegalArgumentException("El campo nombre es requerido.");
        if(!(validateNullOrEmpty(user.getLastName()))) throw new IllegalArgumentException("El campo apellido es requerido.");
        if(!(validateNullOrEmpty(user.getEmail()))) throw new IllegalArgumentException("El campo email es requerido.");
        if(!(validateNullOrEmpty(user.getPassword()))) throw new IllegalArgumentException("El campo contraseña es requerido.");
        if(!(validateNullOrEmpty(user.getMobile()))) throw new IllegalArgumentException("El campo celular es requerido.");
        if(!(validateNullOrEmpty(user.getNickname())))throw new IllegalArgumentException("El campo nick name es requerido.");

        if(!validateEmail(user.getEmail())) throw new IllegalArgumentException("El email enviado no tiene un formato valido.");
        if(!validatePassword(user.getPassword())) throw new IllegalArgumentException("La contraseña enviada no tiene un formato valido.");
        if(!validateNickName(user.getNickname())) throw new IllegalArgumentException("El nickName enviado no tiene un formato valido.");
        if(!isNumber(user.getMobile())) throw new IllegalArgumentException("El celular solo debe tener números.");

        return true;

    }
}
