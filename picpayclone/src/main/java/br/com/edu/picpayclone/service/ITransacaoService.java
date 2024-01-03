package br.com.edu.picpayclone.service;


import br.com.edu.picpayclone.dto.TransacaoDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITransacaoService {
    TransacaoDTO processar(TransacaoDTO transacaoDTO);

    Page<TransacaoDTO> listar(Pageable paginacao, String loginUsuario);
}

