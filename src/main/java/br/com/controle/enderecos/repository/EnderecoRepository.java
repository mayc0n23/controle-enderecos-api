package br.com.controle.enderecos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.enderecos.model.Endereco;
import br.com.controle.enderecos.model.Usuario;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	List<Endereco> findByUsuario(Usuario usuario);
	
}