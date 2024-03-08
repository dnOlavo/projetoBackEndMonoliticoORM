package com.projeto.backend.orm.datamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Isso significa que esta classe é um Controller
@RequestMapping(path="/data") // Isso significa que os URLs começam com /data (após o caminho do aplicativo)

public class UsuarioController {
    @Autowired // Isso significa obter o bean chamado usuarioRepository
    // Que é gerado automaticamente pelo Spring, vamos usá-lo para tratar os dados
  private UsuarioRepository usuarioRepository;

  @PostMapping(path="/add") // Mapeia SOMENTE solicitações POST
  public @ResponseBody String addNovoUsuario (@RequestParam String nome
      , @RequestParam String email) {
    // @ResponseBody significa que a String retornada é a resposta, não um nome de visualização
    // @RequestParam significa que é um parâmetro da solicitação GET ou POST

    Usuario n = new Usuario();
    n.setNome(nome);
    n.setEmail(email);
    usuarioRepository.save(n);
    return "Usuário Salvo!";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Usuario> getAllUsuarios() {
    // This returns a JSON or XML with the users
    return usuarioRepository.findAll();
  }
}
