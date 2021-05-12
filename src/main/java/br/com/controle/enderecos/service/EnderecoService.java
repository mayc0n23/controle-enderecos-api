package br.com.controle.enderecos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle.enderecos.exception.UsuarioNaoEncontradoException;
import br.com.controle.enderecos.model.Endereco;
import br.com.controle.enderecos.model.Usuario;
import br.com.controle.enderecos.repository.EnderecoRepository;
import br.com.controle.enderecos.repository.UsuarioRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Endereco salvar(Long usuarioId, Endereco endereco) {
		Usuario usuario = buscar(usuarioId);
		endereco.setUsuario(usuario);
		return enderecoRepository.save(endereco);
	}
	
	public List<Endereco> listar(Long usuarioId) {
		Usuario usuario = buscar(usuarioId);
		return enderecoRepository.findByUsuario(usuario);
	}
	
	private Usuario buscar(Long usuarioId) {
		return usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado"));
	}
	
}