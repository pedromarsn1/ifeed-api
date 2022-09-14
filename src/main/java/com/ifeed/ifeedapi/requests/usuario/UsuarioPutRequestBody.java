package com.ifeed.ifeedapi.requests.usuario;

import lombok.Data;

@Data
public class UsuarioPutRequestBody {

    private Long usuarioId;

    private Long codigoUsuario;

    private String nomeUsuario;

    private String cpfUsuario;

    private String emailUsuario;
}
