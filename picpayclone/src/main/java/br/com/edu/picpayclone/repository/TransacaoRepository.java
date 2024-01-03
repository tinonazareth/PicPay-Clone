package br.com.edu.picpayclone.repository;

import br.com.edu.picpayclone.modelo.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    Page<Transacao> findByOrigem_LoginOrDestino_Login(String loginUsuario, String loginUsuario1, Pageable paginacao);
}
