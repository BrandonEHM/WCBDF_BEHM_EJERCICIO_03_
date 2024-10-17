package com.upiiz.categorias.repository;

import com.upiiz.categorias.models.Categoria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
@Repository
public class CategoriasRepository {
    private List<Categoria> categorias = new ArrayList();
    private AtomicLong id = new AtomicLong();

    public CategoriasRepository() {
    }

    public Categoria guardar(Categoria categoria) {
        categoria.setId(this.id.incrementAndGet());
        this.categorias.add(categoria);
        return categoria;
    }

    public List<Categoria> obtenerTodas() {
        return this.categorias;
    }

    public Categoria obtenerPorId(Long id) {
        return (Categoria) this.categorias.stream().filter((categoria) -> {
            return categoria.getId().equals(id);
        }).findFirst().orElse((Categoria) null);
    }

    public void eliminar(Long id) {
        this.categorias.removeIf((categoria) -> {
            return categoria.getId().equals(id);
        });
    }

    public Categoria actualizar(Categoria categoria) {
        this.eliminar(categoria.getId());
        this.categorias.add(categoria);
        return categoria;
    }

}
