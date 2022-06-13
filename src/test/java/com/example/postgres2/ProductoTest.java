package com.example.postgres2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import models.ProductoModel;
import services.ProductoService;

class ProductoTest {

	@Autowired
    ProductoService productoService;

    @Test
    public void obtener(){
        assert ( productoService.obtenerProductos()) != null;
    }

    @Test
    public void guardarProducto(@RequestBody ProductoModel producto){
    	producto.setIdProducto(1l);
    	producto.setId_Categoria(1l);
    	producto.setCodigo("123");
    	producto.setNombre("Vaso");
    	assert ( this.productoService.guardarProducto(producto)) != null;
    }

    @Test
    public void obtenerProductoPorId(@PathVariable("id") Long id) {
        assert ( this.productoService.obtenerPorId(1l)) != null;
    }
    
    @Test
    public void actualizar( @RequestBody ProductoModel producto) {
    	producto.setIdProducto(1l);
    	producto.setId_Categoria(2l);
    	producto.setCodigo("321");
    	producto.setNombre("Vasos");
    	  assert (this.productoService.updateProducto(producto)) != null;
      }

    @Test
    public void eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.productoService.eliminarProducto(id);
        assert(ok);
    }
	

}
