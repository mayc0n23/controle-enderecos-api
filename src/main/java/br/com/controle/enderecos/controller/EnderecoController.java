package br.com.controle.enderecos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.controle.enderecos.exception.ErroDeNegocioException;
import br.com.controle.enderecos.model.Endereco;
import br.com.controle.enderecos.service.EnderecoService;

@RestController
@RequestMapping("/usuarios/{id}/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco cadastrar(@PathVariable Long id, @RequestBody @Valid Endereco endereco, Errors errors) {
		if (errors.hasErrors()) {
			throw new ErroDeNegocioException("Dados inválidos ou incompletos");
		}
		return enderecoService.salvar(id, endereco);
	}
	
	@GetMapping
	public List<Endereco> listar(@PathVariable Long id) {
		return enderecoService.listar(id);
	}
	
}