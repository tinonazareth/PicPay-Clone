package br.com.edu.picpayclone.service.impl;

import br.com.edu.picpayclone.conversor.CartaoCreditoConversor;
import br.com.edu.picpayclone.dto.CartaoCreditoDTO;
import br.com.edu.picpayclone.modelo.CartaoCredito;
import br.com.edu.picpayclone.repository.CartaoCreditoRepository;
import br.com.edu.picpayclone.service.ICartaoCreditoService;
import br.com.edu.picpayclone.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

public class CartaoCreditoService implements ICartaoCreditoService {
    @Autowired
    private CartaoCreditoRepository cartaoCreditoRepository;
    @Autowired
    private CartaoCreditoConversor cartaoCreditoConversor;
    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public CartaoCreditoDTO salvar(CartaoCreditoDTO cartaoCreditoDTO) {
        CartaoCreditoDTO cartaoCreditoRetorno = null;
        if (cartaoCreditoDTO.getIsSalva()) {
            CartaoCredito cartaoCredito = cartaoCreditoConversor.converterDtoParaEntidade(cartaoCreditoDTO);
            usuarioService.validar(cartaoCredito.getUsuario());
            CartaoCredito cartaoCreditoSalvo = cartaoCreditoRepository.save(cartaoCredito);
            cartaoCreditoRetorno = cartaoCreditoConversor.converterEntidadeParaDto(cartaoCreditoSalvo);
        }

        return cartaoCreditoRetorno;
    }
}
