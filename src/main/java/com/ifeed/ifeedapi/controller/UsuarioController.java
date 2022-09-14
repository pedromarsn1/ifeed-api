package com.ifeed.ifeedapi.controller;

import com.ifeed.ifeedapi.model.Usuario;
import com.ifeed.ifeedapi.repository.UsuarioRepository;
import com.ifeed.ifeedapi.requests.usuario.UsuarioPostRequestBody;
import com.ifeed.ifeedapi.requests.usuario.UsuarioPutRequestBody;
import com.ifeed.ifeedapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("usuarios")
@Log4j2
@RequiredArgsConstructor
public class UsuarioController {
    @Autowired
    private final UsuarioRepository usuarioRepository;
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> list(){
        return new ResponseEntity<>(usuarioService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id){
        return new ResponseEntity<>(usuarioService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody UsuarioPostRequestBody postRequestBody){
        return new ResponseEntity<>(usuarioService.save(postRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        usuarioService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/deleteAll")
    public ResponseEntity<Void> deleteAll(){
        usuarioService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Usuario> put(@PathVariable Long id, @RequestBody UsuarioPutRequestBody putRequestBody){
        Optional<Usuario> antigoUsuario = usuarioRepository.findById(id);

        if(antigoUsuario.isPresent()){
            Usuario usuario = antigoUsuario.get();
            usuario.setEmailUsuario(putRequestBody.getEmailUsuario());
            usuario.setCpfUsuario(putRequestBody.getCpfUsuario());
            usuario.setNomeUsuario(putRequestBody.getNomeUsuario());
            usuario.setCodigoUsuario(putRequestBody.getCodigoUsuario());
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
