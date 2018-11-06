package UCHub.Controllers;

import UCHub.Models.EtiquetaModel;
import UCHub.Repositories.EtiquetasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@CrossOrigin(origins = "httpp://localhost:8080")
@RequestMapping(path="/etiquetas")
public class EtiquetasController {
    @Autowired
    private EtiquetasRepository etiquetasRepository;

    //    GET all the labels
    @GetMapping(path="/")
    public @ResponseBody Iterable<EtiquetaModel> getAllLabels(){
        return etiquetasRepository.findAll();
    }

    //    GET ALL BY NAME
    @GetMapping(path="/{name}")
    public @ResponseBody Optional<EtiquetaModel> getByName(@PathVariable(value = "name") String name){
        return etiquetasRepository.getAllByNombreContaining(name);
    }

    //    POST A NEW LABEL
    @PostMapping(path="/")
    public @ResponseBody EtiquetaModel newLabel(@RequestBody Map<String, String> body){
        EtiquetaModel e = new EtiquetaModel(body.get("nombre"));

        etiquetasRepository.save(e);

        return e;
    }


}


