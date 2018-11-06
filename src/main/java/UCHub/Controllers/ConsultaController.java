package UCHub.Controllers;

import UCHub.Models.ConsultaModelo;
import UCHub.Models.RecursoModel;
import UCHub.Models.UsuarioModel;
import UCHub.Repositories.ConsultaRepository;
import UCHub.Repositories.RecursoRepository;
import UCHub.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;


@Controller
@RequestMapping(path="/consultas")
public class ConsultaController {
    @Autowired
    ConsultaRepository consultaRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    RecursoRepository recursoRepository;

//    GET ALL CONSULTAS
    @GetMapping("/")
    public @ResponseBody Iterable<ConsultaModelo> getAllConsultas(){
        return consultaRepository.findAll();
    }

//    POST a new CONSULTA
    @PostMapping("/")
    public @ResponseBody ConsultaModelo newConsulta(@RequestBody Map<String, String> body){
        Optional<UsuarioModel> user = usuarioRepository.findByCuenta(Long.parseLong(body.get("usuario")));
        Optional<RecursoModel> recurso = recursoRepository.findById(Long.parseLong(body.get("recurso")));

        if(!user.isPresent() || !recurso.isPresent())
            return new ConsultaModelo();


        ConsultaModelo c = new ConsultaModelo(recurso.get(), user.get());

        consultaRepository.save(c);

        return c;
    }


}
