package br.com.edu.picpayclone.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.edu.picpayclone.constantes.MensagemValidacao;
import br.com.edu.picpayclone.conversor.UsuarioConversor;
import br.com.edu.picpayclone.dto.UsuarioDTO;
import br.com.edu.picpayclone.exception.NegocioException;
import br.com.edu.picpayclone.modelo.Transacao;
import br.com.edu.picpayclone.modelo.Usuario;
import br.com.edu.picpayclone.repository.UsuarioRepository;
import br.com.edu.picpayclone.service.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioConversor usuarioConversor;

    @Override
    public UsuarioDTO consultar(String login) {
        Usuario usuario = consultarEntidade(login);
        return usuarioConversor.converterEntidadeParaDto(usuario);
    }

    @Override
    @Transactional
    public Usuario consultarEntidade(String login) {
        return usuarioRepository.findByLogin(login);
    }

    @Override
    @Async("asyncExecutor")
    @Transactional
    public void atualizarSaldo(Transacao transacaoSalva, Boolean isCartaoCredito) {
        decrementarSaldo(transacaoSalva, isCartaoCredito);
        incrementarSaldo(transacaoSalva);
    }

    private void incrementarSaldo(Transacao transacaoSalva) {
        usuarioRepository.updateIncrementarSaldo(transacaoSalva.getDestino().getLogin(), transacaoSalva.getValor());
    }

    private void decrementarSaldo(Transacao transacaoSalva, Boolean isCartaoCredito) {
        if (!isCartaoCredito) {
            usuarioRepository.updateDecrementarSaldo(transacaoSalva.getOrigem().getLogin(), transacaoSalva.getValor());
        }
    }

    @Override
    public void validar(Usuario... usuarios) {

        Arrays.stream(usuarios).forEach(usuario -> {
            if (usuario == null) {
                throw new NegocioException(MensagemValidacao.ERRO_USUARIO_INEXISTENTE);
            }

        });
    }

    @Override
    public List<UsuarioDTO> listar(String login) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarioConversor.converterEntidadesParaDtos(
                usuarios.stream().filter(v -> !v.getLogin().equals(login)).collect(Collectors.toList()));
    }

}
