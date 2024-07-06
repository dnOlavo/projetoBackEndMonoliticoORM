package br.edu.iftm.projeto.backend.orm.manytoone.controller;

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

import br.edu.iftm.projeto.backend.orm.manytoone.domain.Item;
import br.edu.iftm.projeto.backend.orm.manytoone.service.ItemService;

@RestController
@RequestMapping("/item")
class ItemController {

        @Autowired
        ItemService service;

        @GetMapping
        public List<Item> getAll() {
                return service.getAll();
        }

        @GetMapping("{id}")
        public Item getById(@PathVariable("id") Long id) {
                return service.getById(id);
        }

        @PostMapping
        public Item create(@RequestBody Item item) {
                return service.create(item);
        }

        @PutMapping("{id}")
        public Item update(@PathVariable("id") Long id, @RequestBody Item item) {
                return service.update(id, item);
        }

        @DeleteMapping("{id}")
        public boolean delete(@PathVariable("id") Long id) {
                return service.delete(id);
        }
}
