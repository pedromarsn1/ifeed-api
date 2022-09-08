package com.ifeed.ifeedapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    private Long codigoUsuario;

    private String nomeUsuario;

    private String cpfUsuario;

    private String emailUsuario;

   // private Endereco endereco;

}
