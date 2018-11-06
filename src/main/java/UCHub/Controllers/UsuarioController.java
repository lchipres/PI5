package UCHub.Controllers;

import java.util.Map;
import java.util.Optional;
import java.util.Random;

import UCHub.Models.UsuarioModel;
import UCHub.helpers.Auth;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import UCHub.Repositories.*;

@Controller
@RequestMapping(path="/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private static Random r = new Random();

//    GET all users
    @GetMapping(path="/")
    public @ResponseBody Iterable<UsuarioModel> getAllUsers(){
        return usuarioRepository.findAll();
    }

//    GET user by cuenta
    @GetMapping(path="/{cuenta}")
    public @ResponseBody UsuarioModel getUser(@PathVariable(value = "cuenta") String cuenta){
        return  usuarioRepository.findByCuenta(Long.parseLong(cuenta)).get();
    }

    @PostMapping(path="/{cuenta}/login/")
    public @ResponseBody UsuarioModel login(@PathVariable(value="cuenta") String cuenta,
                                       @RequestBody Map<String, String> body){
        Optional<UsuarioModel> user = usuarioRepository.findByCuenta(Long.parseLong(cuenta));

        if(!user.isPresent())
            return new UsuarioModel();

        if( Auth.authUser(user.get(), body.get("cuenta"), body.get("password")) )
            return user.get();
        else
            return new UsuarioModel();
    }

//    POST a new Usuario
    @PostMapping(path="/")
    public @ResponseBody UsuarioModel addNewUsuario(@RequestBody Map<String, String> body){
        UsuarioModel newU = new UsuarioModel(Long.parseLong(body.get("cuenta")), body.get("name"), body.get("career"), body.get("email"),
                                            body.get("user"), body.get("password"), body.get("type"));
        usuarioRepository.save(newU);
        return newU;
    }

//    PUT an user
    @PutMapping(path="/{cuenta}")
    public @ResponseBody UsuarioModel updateUser(@RequestBody Map<String, String> body,
                                                 @PathVariable(value = "cuenta") String cuenta){
        Optional<UsuarioModel> u = usuarioRepository.findByCuenta(Long.parseLong(cuenta));

        if (!u.isPresent())
            return new UsuarioModel();

        u.get().setCarrera(body.get("career"));
        u.get().setNombre(body.get("name"));
        u.get().setCorreo(body.get("email"));
        u.get().setUsuario(body.get("user"));
        u.get().setContrasena(body.get("password"));

        usuarioRepository.save(u.get());

        return u.get();
    }
}
