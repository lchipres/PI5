package UCHub.Controllers;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import UCHub.Models.RecursoModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


// UCHub.Models
import UCHub.Models.*;
import UCHub.Repositories.*;

@Controller
@RequestMapping(path="/recursos")
public class RecursoController {
    @Autowired

    private RecursoRepository recursoRepository;

    @PostMapping(path="/add")
    public @ResponseBody RecursoModel addNewRecurso(@RequestBody Map<String, String> body){

        RecursoModel r = new RecursoModel(0, 0, body.get("categoria"),
                body.get("formato"), body.get("nombre"), body.get("autor"), body.get("edicion"),
                body.get("etiquetas"), body.get("descripcion"));
        recursoRepository.save(r);
        return r;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<RecursoModel> getAllRecursos(){
        return recursoRepository.findAll();
    }
    /**
     * Get all the resources
     */
    @RequestMapping(path = "/recursos", method = RequestMethod.POST)
    public RecursoModel postRecurso(){
        return new RecursoModel();

    }
//    public RecursoModel RecursoModel( @RequestParam( value = "numLikes") int numLikes,
//                            @RequestParam( value = "numConsultas") int numConsultas,
//                            @RequestParam( value = "categoria") String categoria,
//                            @RequestParam( value = "formato") String formato,
//                            @RequestParam( value = "nombre") String nombre ,
//                            @RequestParam( value = "autor") String autor ,
//                            @RequestParam( value = "edicion") String edicion,
//                            @RequestParam( value = "etiquetas") String etiquetas,
//                            @RequestParam( value = "descripcion") String descripcion){
//        return new RecursoModel(counter.incrementAndGet(), numLikes, numConsultas, categoria, formato, nombre, autor,
//                            edicion, etiquetas, descripcion );
//        //return new RecursoModel(counter.incrementAndGet(),String.format(template, nombre));
//    }



}
