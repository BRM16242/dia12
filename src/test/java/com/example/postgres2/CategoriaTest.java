package com.example.postgres2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import models.CategoriaModel;
import services.CategoriaService;



class CategoriaTest {

	 @Autowired
	    CategoriaService categoriaService;
	 
	@Test
	private void getAll(){
		assert ( ResponseEntity.ok(categoriaService.findAll())) != null;
	}
	

	@Test
    public void guardarCategoria(@RequestBody CategoriaModel categoria){
		categoria.setId_Categoria(1l);
		categoria.setNombre("Pepe");
		assert (this.categoriaService.guardarCategoria(categoria)) != null;
    }

	@Test
    public void obtenerCategoriaPorId(@PathVariable("id") Long id) {
		assert ( this.categoriaService.obtenerPorId(1l)) != null;
    }
    
	@Test
    public void actualizar( @RequestBody CategoriaModel categoria) {
		assert (this.categoriaService.updateCategoria(categoria)) != null;
      }

	@Test
    public void eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.categoriaService.eliminarCategoria(1l);
        assert (ok);
    }

}
