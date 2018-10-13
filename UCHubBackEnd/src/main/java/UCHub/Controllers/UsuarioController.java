package UCHub.Controllers;

import java.util.Map;
import java.util.Random;

import UCHub.Models.UsuarioModel;
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
        return  usuarioRepository.findByCuenta(Long.parseLong(cuenta));
    }

//    POST a new Usuario
    @PostMapping(path="/")
    public @ResponseBody UsuarioModel addNewUsuario(@RequestBody Map<String, String> body){
        long cuenta = r.nextInt((99999999 - 10000000)+ 1) + 10000000;

        UsuarioModel u = usuarioRepository.findByCuenta(cuenta);
        if(u != null)
            cuenta =  r.nextInt((99999999 - 10000000)+ 1) + 10000000;

        UsuarioModel newU = new UsuarioModel(cuenta, body.get("name"), body.get("career"), body.get("email"),
                                            body.get("user"), body.get("password"), body.get("type"));
        usuarioRepository.save(newU);
        return newU;
    }

//    PUT an user
    @PutMapping(path="/{cuenta}")
    public @ResponseBody UsuarioModel updateUser(@RequestBody Map<String, String> body,
                                                 @PathVariable(value = "cuenta") String cuenta){
        UsuarioModel u = usuarioRepository.findByCuenta(Long.parseLong(cuenta));

        u.setCarrera(body.get("career"));
        u.setNombre(body.get("name"));
        u.setCorreo(body.get("email"));
        u.setUsuario(body.get("user"));
        u.setContrasena(body.get("password"));

        usuarioRepository.save(u);

        return u;
    }
}
