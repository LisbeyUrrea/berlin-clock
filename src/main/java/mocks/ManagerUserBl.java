package mocks;

import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.List;

public class ManagerUserBl {

    public static final boolean TRUE = true;
    public static final boolean FALSE = false;
    public static  final String REGULAR_EXPRESSION_ONLY_NUMBERS = "^[0-9]*$";

    private IUserConfigRepository userConfigRepository;

    public ManagerUserBl(IUserConfigRepository userConfigRepository) {
        this.userConfigRepository = userConfigRepository;
    }

    public List<UserManager> findUsers() {
        return userConfigRepository.findAll();
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
        if(param == null) return FALSE;
        if(param.equals("")) return FALSE;

        return TRUE;
    }


    public boolean isNumber(String number) {
        return number.matches(REGULAR_EXPRESSION_ONLY_NUMBERS);
    }

    public String registerUser(UserManager user) {
        try {

            return isValidUser(user) ? userConfigRepository.registerUser(user) : "";

        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }


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

        return TRUE;

    }

    public UserManager findUserById(Integer idUser) {
        UserManager user = null;
       try {
           if(idUser == null) throw new IllegalArgumentException("El Id no puede ser nulo");
            user = userConfigRepository.findUser(idUser);
            if(user==null) throw new IllegalArgumentException("no existe un usuario con el id "+idUser);

        }catch (IllegalArgumentException e){
           throw new IllegalArgumentException(e.getMessage());

       }

        return user;
    }
}
