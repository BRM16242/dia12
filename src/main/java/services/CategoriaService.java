package services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import models.CategoriaModel;
import repositories.CategoriaRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;
    
    public List<CategoriaModel> findAll() {
		return categoriaRepository.findAll();
	}

    public CategoriaModel guardarCategoria(CategoriaModel categoria){
        return categoriaRepository.save(categoria);
    }
    
    public CategoriaModel updateCategoria(CategoriaModel categoria) {
        CategoriaModel categoriaori = categoriaRepository.findById(categoria.getId_Categoria()).orElse(null);
        categoriaori.setNombre(categoria.getNombre());
        return categoriaRepository.save(categoriaori);
    }

    public Optional<CategoriaModel> obtenerPorId(Long id){
        return categoriaRepository.findById(id);
    }


    public boolean eliminarCategoria(Long id) {
        try{
            categoriaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}

