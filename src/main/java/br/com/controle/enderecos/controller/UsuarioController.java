package br.com.controle.enderecos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.enderecos.exception.ErroDeNegocioException;
import br.com.controle.enderecos.model.Usuario;
import br.com.controle.enderecos.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario cadastrar(@RequestBody @Valid Usuario usuario, Errors errors) {
		if (errors.hasErrors()) {
			throw new ErroDeNegocioException("Dados inválidos ou incompletos");
		}
		return usuarioService.salvar(usuario);
	}
	
}