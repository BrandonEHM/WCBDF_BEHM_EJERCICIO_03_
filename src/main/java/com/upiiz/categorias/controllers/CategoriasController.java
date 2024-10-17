package com.upiiz.categorias.controllers;

import com.upiiz.categorias.models.Categoria;
import com.upiiz.categorias.services.CategoriasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping({"/api/v1/categorias"})
@RestController
public class CategoriasController {

    CategoriasService categoriasService;

    public CategoriasController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getCategorias() {
        return ResponseEntity.ok(this.categoriasService.getAllCategorias());
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Categoria> getCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(this.categoriasService.getCategoriaById(id));
    }

    @PostMapping
    public ResponseEntity<Categoria> addCategoria(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(this.categoriasService.createCategoria(categoria));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Categoria> updateCategoria(@RequestBody Categoria categoria, @PathVariable Long id) {
        categoria.setId(id);
        return ResponseEntity.ok(this.categoriasService.updateCategoria(categoria));
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        this.categoriasService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
