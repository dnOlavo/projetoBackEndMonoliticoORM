package br.edu.iftm.projeto.backend.orm.onetomany.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.projeto.backend.orm.onetomany.domain.Categoria;
import br.edu.iftm.projeto.backend.orm.onetomany.repository.CategoriaRepository;

// A anotação @Service é usada para indicar que uma classe é um "Service" (ou "Service Layer").
// A anotação @Service é um especialização da anotação @Component e é usada para anotar classes de serviço.
// A anotação @Component é uma superclasse para outras anotações de componentes, como @Repository, @Service e @Controller.
// Uma classe anotada com @Service é tipicamente uma classe que fornece serviços de negócios, como lógica de negócios e regras de negócios.
@Service
public class CategoriaService {

        // A anotação @Autowired é usada para injetar dependências automaticamente.
        // A anotação @Autowired pode ser usada para injetar beans em propriedades, métodos e construtores.
        @Autowired
        CategoriaRepository repository;

        public List<Categoria> getAll() {
                try {
                        List<Categoria> items = new ArrayList<Categoria>();

                        // O método findAll() retorna um Iterable que é percorrido com o método
                        // forEach() que adiciona cada item à lista items.
                        // O operador :: é usado para criar expressões lambda mais claras e concisas.
                        // A expressão lambda items::add é usada para adicionar cada item retornado pelo
                        // método findAll() à lista items.
                        // A expressão lambda items::add é equivalente a: (item) -> items.add(item)
                        repository.findAll().forEach(items::add);
                        return items;
                } catch (Exception e) {
                        return null;
                }
        }

        public Categoria getById(Long id) {
                Optional<Categoria> categoria = repository.findById(id);
                if (categoria.isPresent()) {
                        return categoria.get();
                }
                return null;
        }

        public Categoria create(Categoria categoria) {
                return repository.save(categoria);
        }

        public Categoria update(Long id, Categoria item) {
                Optional<Categoria> existingItemOptional = repository.findById(id);

                if (existingItemOptional.isPresent()) {
                        Categoria existingItem = existingItemOptional.get();
                        existingItem.setNome(item.getNome());
                        return repository.save(existingItem);
                } else {
                        return null;
                }
        }

        public boolean delete(Long id) {
                try {
                        repository.deleteById(id);
                        return true;
                } catch (Exception e) {
                        return false;
                }
        }
}
