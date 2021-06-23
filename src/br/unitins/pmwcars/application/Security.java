package br.unitins.pmwcars.application;

import org.apache.commons.codec.digest.DigestUtils;

import br.unitins.pmwcars.model.Cliente;
import br.unitins.pmwcars.model.Funcionario;
import br.unitins.pmwcars.model.Usuario;

public class Security {
	
	public static String hash(Usuario usuario) {
		return DigestUtils.sha256Hex(usuario.getSenha()+usuario.getLogin());
	}
	
	public static String hashfun(Funcionario funcionario) {
		return DigestUtils.sha256Hex(funcionario.getUsuario().getSenha()+funcionario.getUsuario().getLogin());
	}
	
	public static String hashcli(Cliente cliente) {
		return DigestUtils.sha256Hex(cliente.getUsuario().getSenha()+cliente.getUsuario().getLogin());
	}
	
	public static Usuario encript(Usuario usu) {
		String last3 = usu.getSenha().substring(usu.getSenha().length() - 3);
		String encripted = DigestUtils.sha256Hex(usu.getSenha() + last3);
		usu.setSenha(encripted);

		return usu;
	}
}