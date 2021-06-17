package br.unitins.pmwcars.application;

import org.apache.commons.codec.digest.DigestUtils;

import br.unitins.pmwcars.model.Usuario;

public class Security {
	
	public static String hash(Usuario usuario) {
		return DigestUtils.sha256Hex(usuario.getSenha()+usuario.getLogin());
	}
}