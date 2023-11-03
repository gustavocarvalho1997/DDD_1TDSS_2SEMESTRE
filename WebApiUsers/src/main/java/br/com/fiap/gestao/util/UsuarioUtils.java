package br.com.fiap.gestao.util;

import java.util.List;

import br.com.fiap.gestao.excecption.BadInfoException;
import br.com.fiap.gestao.model.Usuario;

public class UsuarioUtils {
	// mergeUser INICIO
	public static void mergeUser(Usuario model, Usuario target) {
		if (StringUtils.isNullOrEmpty(target.getNome())) {
			target.setNome(model.getNome());
		}
		if (StringUtils.isNullOrEmpty(target.getEmail())) {
			target.setEmail(model.getEmail());
		}
		if (StringUtils.isNullOrEmpty(target.getCpf())) {
			target.setCpf(model.getCpf());
		}
		if (target.getDataCadastro() == null) {
			target.setDataCadastro(model.getDataCadastro());
		}
		if (target.getDataNascimento() == null) {
			target.setDataNascimento(model.getDataNascimento());
		}
	}// mergeUser FIM

	// checkStrings INICIO
	public static void checkStrings(Usuario usuario) throws BadInfoException {
		// Validações
		if (StringUtils.isNullOrEmptyOrHasMoreThan(usuario.getNome(), 100)) {
			throw new BadInfoException("Nome não pode ser nulo ou maior que cem caracteres");
		}
		if (StringUtils.isNullOrEmptyOrHasMoreThan(usuario.getEmail(), 100)) {
			throw new BadInfoException("Email não pode ser nulo ou ter mais que cem caracteres");
		}
		if (StringUtils.isNullOrEmpty(usuario.getCpf()) || !StringUtils.has(usuario.getCpf(), 11)) {
			throw new BadInfoException("CPF não pode ser nulo e deve contar 11 numeros");
		}
	}// checkStrings FIM
	
	// checkUniques INICIO
	public static void checkUniques(Usuario usuario, List<Usuario> lista) throws BadInfoException {
		for(Usuario user : lista) {
			if(usuario.getCodigo() == user.getCodigo()) {
				continue;
			}
			if(usuario.getNome().equalsIgnoreCase(user.getNome())) {
				throw new BadInfoException("Nome ja cadastrado!");
			}
			if(usuario.getEmail().equalsIgnoreCase(user.getEmail())) {
				throw new BadInfoException("Email ja cadastrado!");
			}
			if(usuario.getCpf().equals(user.getCpf())) {
				throw new BadInfoException("CPF ja cadastrado!");
			}
		}
	}// checkUniques FIM
}// CLASS