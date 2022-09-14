package com.ifeed.ifeedapi.service;

import com.ifeed.ifeedapi.model.Entregador;
import com.ifeed.ifeedapi.repository.EntregadorRepository;
import com.ifeed.ifeedapi.requests.entregador.EntregadorPostRequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class EntregadorService {
    @Autowired
    EntregadorRepository repository;

    public List<Entregador> findAll(){
        return repository.findAll();
    }

    public Entregador findById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ResponseStatusException
                        (HttpStatus.BAD_REQUEST, "Não foi possível encontrar o ID")
                );
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public Entregador save(EntregadorPostRequestBody postRequestBody){
        return repository.save(Entregador.builder()
                        .entregadorId(postRequestBody.getEntregadorId())
                        .codigoEntregador(postRequestBody.getCodigoEntregador())
                        .cpfEntregador(postRequestBody.getCpfEntregador())
                        .emailEntregador(postRequestBody.getEmailEntregador())
                        .nomeEntregador(postRequestBody.getNomeEntregador())
                .build());
    }
}
