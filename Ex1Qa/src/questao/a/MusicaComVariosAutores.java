package questao.a;

import utils.Time;

// TODO
// Acrescentar o que for necessario, incluindo atributos e codigo no construtor
//
public class MusicaComVariosAutores extends Musica {
	
	private String[] outrosAutores;
	
	public MusicaComVariosAutores(String titulo, String[] autores, Time duracao) {
		super(titulo, autores[0], duracao);
		outrosAutores = autores;
	}
	
	@Override
	public boolean contemAutor(String nome) {
		for(int i = 0; i < outrosAutores.length; i++)
			if(nome.equals(outrosAutores[i]))
					return true;
		return false;
	}
	
	@Override
	public String getAutor() {
		return super.getAutor() + ((outrosAutores.length > 1)? " et al.": ".");
	}
	
	
}
