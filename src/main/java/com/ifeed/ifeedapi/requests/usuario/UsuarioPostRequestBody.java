package com.ifeed.ifeedapi.requests.usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class UsuarioPostRequestBody {

    private Long usuarioId;

    private Long codigoUsuario;

    private String nomeUsuario;

    private String cpfUsuario;

    private String emailUsuario;
}
