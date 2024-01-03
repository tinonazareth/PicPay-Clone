package br.com.edu.picpayclone.service;

import br.com.edu.picpayclone.dto.UsuarioDTO;
import br.com.edu.picpayclone.modelo.Transacao;
import br.com.edu.picpayclone.modelo.Usuario;

import java.util.List;

public interface IUsuarioService {
    UsuarioDTO consultar(String login);

    Usuario consultarEntidade(String login);

    void validar(Usuario... usuarios);

    void atualizarSaldo(Transacao transacao, Boolean isCartaoCredito);

    List<UsuarioDTO> listar(String login);
}
