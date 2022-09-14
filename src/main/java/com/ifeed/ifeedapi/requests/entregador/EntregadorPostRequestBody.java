package com.ifeed.ifeedapi.requests.entregador;

import lombok.Data;

@Data
public class EntregadorPostRequestBody {

    private Long entregadorId;

    private Long codigoEntregador;

    private String nomeEntregador;

    private String cpfEntregador;

    private String emailEntregador;
}
