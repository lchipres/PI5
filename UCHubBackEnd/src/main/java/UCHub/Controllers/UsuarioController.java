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

//    POST a new Usuario
    @PostMapping(path="/")
    public @ResponseBody UsuarioModel addNewUsuario(@RequestBody Map<String, String> body){
        long cuenta = r.nextInt((99999999 - 10000000)+ 1) + 10000000;

//        UsuarioModel u = (usuarioRepository.findByCuenta(cuenta)).get(0);
//        if(u != null)
//            cuenta =  r.nextInt((99999999 - 10000000)+ 1) + 10000000;

        UsuarioModel newU = new UsuarioModel(cuenta, body.get("name"), body.get("career"), body.get("email"),
                                            body.get("user"), body.get("password"), body.get("type"));
        usuarioRepository.save(newU);
        return newU;
    }

}
