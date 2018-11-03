package UCHub.Controllers;

import UCHub.Models.CategoriaModel;
import UCHub.Repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping(path="/categorias")
public class CategoriaController {
    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping(path="/")
    public @ResponseBody Iterable<CategoriaModel> getallCategories(){
        return categoriaRepository.findAll();
    }

    @PostMapping(path="/")
    public @ResponseBody CategoriaModel addNewCategoria(@RequestBody Map<String, String> body){
        CategoriaModel cat = new CategoriaModel(body.get("nombre"));
        categoriaRepository.save(cat);
        return cat;
    }

}
