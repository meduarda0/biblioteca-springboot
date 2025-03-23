package br.edu.ifpi.biblioteca.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpi.biblioteca.Dto.UsuarioDto;
import br.edu.ifpi.biblioteca.entity.Usuario;
import br.edu.ifpi.biblioteca.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
//Não precisei fazer o import de dto.usuario.Dto.
@RequestMapping("/usuarios")  
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping() 
    public List<Usuario> listaTodosUsuarios() {
        return usuarioRepository.findAll();
    }
   
    
    @PostMapping //Metodo para adicionar um novo usuário ao banco de dados
    //vamos ultilizar os dados da minha record Dto
    //@Valid ele é uma notação de valida
    public ResponseEntity<String> addUsuario(@RequestBody @Valid UsuarioDto dados) { //conversão p um objeto dto
        Usuario usuario = new Usuario (dados);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}") 
    public ResponseEntity<String> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            usuario.setId(id);
            usuarioRepository.save(usuario);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}") //id p não deletar todos de uma vez, mas um específico
    public ResponseEntity<String> deletarUsuario(@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
