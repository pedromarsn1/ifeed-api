package com.ifeed.ifeedapi.service;

import com.ifeed.ifeedapi.model.Usuario;
import com.ifeed.ifeedapi.repository.UsuarioRepository;
import com.ifeed.ifeedapi.requests.usuario.UsuarioPostRequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;


    public List<Usuario> listAll(){
        log.info("Listando todos os usuários existentes no banco");
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Não foi possível achar o usuário"));
    }

    public void deleteById(Long id){
        usuarioRepository.deleteById(id);
    }

    public void deleteAll(){
        usuarioRepository.deleteAll();
    }

    public Usuario save(UsuarioPostRequestBody usuarioPostRequestBody){
        return usuarioRepository.save(Usuario.builder()
                        .usuarioId(usuarioPostRequestBody.getUsuarioId())
                        .codigoUsuario(usuarioPostRequestBody.getCodigoUsuario())
                        .cpfUsuario(usuarioPostRequestBody.getCpfUsuario())
                        .emailUsuario(usuarioPostRequestBody.getEmailUsuario())
                        .nomeUsuario(usuarioPostRequestBody.getNomeUsuario())
                .build());
    }

}
