package br.com.controle.enderecos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controle.enderecos.exception.ErroDeNegocioException;
import br.com.controle.enderecos.model.Usuario;
import br.com.controle.enderecos.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvar(Usuario usuario) {
		boolean exists = usuarioRepository.existsByCpfOrEmail(usuario.getCpf(), usuario.getEmail());
		if (exists) {
			throw new ErroDeNegocioException("Usuário com CPF e Email informados já está cadastrado");
		}
		return usuarioRepository.save(usuario);
	}
	
}