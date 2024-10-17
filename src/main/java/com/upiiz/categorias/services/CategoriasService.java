package com.upiiz.categorias.services;

import com.upiiz.categorias.models.Categoria;
import com.upiiz.categorias.repository.CategoriasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasService {
    CategoriasRepository categoriasRepository;

    public CategoriasService(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    public List<Categoria> getAllCategorias() {
        return this.categoriasRepository.obtenerTodas();
    }

    public Categoria getCategoriaById(Long id) {
        return this.categoriasRepository.obtenerPorId(id);
    }

    public Categoria createCategoria(Categoria categoria) {
        return this.categoriasRepository.guardar(categoria);
    }

    public Categoria updateCategoria(Categoria categoria) {
        return this.categoriasRepository.actualizar(categoria);
    }

    public void deleteCategoria(Long id) {
        this.categoriasRepository.eliminar(id);
    }
}
