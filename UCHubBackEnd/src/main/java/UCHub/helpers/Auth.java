package UCHub.helpers;

// Models
import UCHub.Models.*;

public class Auth {
    public static Boolean authUser(UsuarioModel logged, UsuarioModel fromDB){
        return (logged.getUsuario().equals(fromDB.getUsuario()) && logged.getContrasena().equals(fromDB.getContrasena()));
    }

    public static Boolean authUser(UsuarioModel logged, String account, String password){
        return (logged.getCuenta() == Long.parseLong(account) && logged.getContrasena().equals(password));
    }

    public static Boolean canModifyResource(UsuarioModel logged, UsuarioModel fromDB) {
        return (logged.getUsuario().equals(fromDB.getUsuario()) &&
                logged.getContrasena().equals(fromDB.getContrasena()) &&
                logged.getTipo().equals("BIBLIOTECARIO"));
    }
}
