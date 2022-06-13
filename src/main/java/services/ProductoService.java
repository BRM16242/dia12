package services;
import java.util.ArrayList;
import java.util.Optional;

import models.CategoriaModel;
import models.ProductoModel;
import repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    
    public ArrayList<ProductoModel> obtenerProductos(){
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }

    public ProductoModel guardarProducto(ProductoModel producto){
        return productoRepository.save(producto);
    }

    public Optional<ProductoModel> obtenerPorId(Long id){
        return productoRepository.findById(id);
    }
    
    public ProductoModel updateProducto(ProductoModel producto) {
        ProductoModel prodori = productoRepository.findById(producto.getId_Categoria()).orElse(null);
        prodori.setNombre(producto.getNombre());
        prodori.setCodigo(producto.getCodigo());
        prodori.setId_Categoria(producto.getId_Categoria());
        return productoRepository.save(prodori);
    }



    public boolean eliminarProducto(Long id) {
        try{
            productoRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}

