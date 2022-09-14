package com.ifeed.ifeedapi.controller;

import com.ifeed.ifeedapi.model.Entregador;
import com.ifeed.ifeedapi.model.Usuario;
import com.ifeed.ifeedapi.repository.EntregadorRepository;
import com.ifeed.ifeedapi.repository.UsuarioRepository;
import com.ifeed.ifeedapi.requests.entregador.EntregadorPostRequestBody;
import com.ifeed.ifeedapi.requests.entregador.EntregadorPutRequestBody;
import com.ifeed.ifeedapi.requests.usuario.UsuarioPostRequestBody;
import com.ifeed.ifeedapi.requests.usuario.UsuarioPutRequestBody;
import com.ifeed.ifeedapi.service.EntregadorService;
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
public class EntregadorController {
    @Autowired
    private final EntregadorRepository repository;
    private final EntregadorService service;

    @GetMapping
    public ResponseEntity<List<Entregador>> list(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Entregador> findById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Entregador> save(@RequestBody EntregadorPostRequestBody postRequestBody){
        return new ResponseEntity<>(service.save(postRequestBody), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/deleteAll")
    public ResponseEntity<Void> deleteAll(){
        service.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Entregador> put(@PathVariable Long id, @RequestBody EntregadorPutRequestBody putRequestBody){
        Optional<Entregador> antigoUsuario = repository.findById(id);

        if(antigoUsuario.isPresent()){
            Entregador entregador = antigoUsuario.get();
            entregador.setCodigoEntregador(putRequestBody.getCodigoEntregador());
            entregador.setCpfEntregador(putRequestBody.getCpfEntregador());
            entregador.setEmailEntregador(putRequestBody.getEmailEntregador());
            entregador.setNomeEntregador(putRequestBody.getNomeEntregador());
            return new ResponseEntity<Entregador>(entregador, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
