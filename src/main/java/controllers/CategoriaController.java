package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import models.CategoriaModel;
import services.CategoriaService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    private ResponseEntity<List<CategoriaModel>> getAll (){
		return ResponseEntity.ok(categoriaService.findAll());
	}

    @PostMapping()
    public CategoriaModel guardarCategoria(@RequestBody CategoriaModel categoria){
        return this.categoriaService.guardarCategoria(categoria);
    }

    @GetMapping( path = "/{id}")
    public Optional<CategoriaModel> obtenerCategoriaPorId(@PathVariable("id") Long id) {
        return this.categoriaService.obtenerPorId(id);
    }
    
    @PutMapping(path="/categoria")
    public void actualizar( @RequestBody CategoriaModel categoria) {
    	  this.categoriaService.updateCategoria(categoria);
      }

    @DeleteMapping( path = "del/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.categoriaService.eliminarCategoria(id);
        if (ok){
            return "Se eliminó el categoria con id " + id;
        }else{
            return "No pudo eliminar el categoria con id" + id;
        }
    }

}