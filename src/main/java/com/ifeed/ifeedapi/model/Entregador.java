package com.ifeed.ifeedapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entregador {
    @Id
    private Long entregadorId;

    private Long codigoEntregador;

    private String nomeEntregador;

    private String cpfEntregador;

    private String emailEntregador;

}
