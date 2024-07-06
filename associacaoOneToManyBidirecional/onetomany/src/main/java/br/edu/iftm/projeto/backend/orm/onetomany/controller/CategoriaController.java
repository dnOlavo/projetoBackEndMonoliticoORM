package br.edu.iftm.projeto.backend.orm.onetomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iftm.projeto.backend.orm.onetomany.domain.Categoria;
import br.edu.iftm.projeto.backend.orm.onetomany.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
class CategoriaController {

        @Autowired
        CategoriaService service;

        @GetMapping
        public List<Categoria> getAll() {
                // Vemos aqui uma chamada à camada de serviço para buscar as categorias.
                // A camada de serviço não conhece o HTTP.
                // A camada de serviço lida com questões de negócio, o que inclui acesso aos dados da aplicação
                // A camada de controle lida com questões de HTTP
                List<Categoria> items = service.getAll();
                return items;
        }

        @GetMapping("{id}")
        public Categoria getById(@PathVariable("id") Long id) {
                return service.getById(id);
        }

        @PostMapping
        public Categoria create(@RequestBody Categoria item) {
                Categoria categoria = service.create(item);
                return categoria;
        }

        @PutMapping("{id}")
        public Categoria update(@PathVariable("id") Long id, @RequestBody Categoria item) {
                return service.update(id, item);
        }

        @DeleteMapping("{id}")
        public boolean delete(@PathVariable("id") Long id) {
                return service.delete(id);
        }
}