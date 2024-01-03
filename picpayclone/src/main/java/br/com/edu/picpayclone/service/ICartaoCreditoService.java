package br.com.edu.picpayclone.service;

import br.com.edu.picpayclone.dto.CartaoCreditoDTO;
import br.com.edu.picpayclone.modelo.CartaoCredito;

public interface ICartaoCreditoService {
    CartaoCreditoDTO salvar(CartaoCreditoDTO cartaoCredito);
}
