package questao.a;

import java.awt.List;
import java.util.ArrayList;

import utils.Leitor;
import utils.Time;

// Nao pode alterar a classe Musica.
// 
// Em todas as alineas necessita de testar as funcionalidades pedidas, mostrando claramente
// os resultados. Pode ser util usar o metodo lerMusicas() que esta' na classe Leitor e o 
// ficheiro musicas.txt
//
//
// a) Crie a classe MusicaComVariosAutores de modo a que extenda a classe Musica 
// e permita guardar o nome de todos os autores. Quando for chamado o metodo getAutor() 
// este deve devolver o nome do primeiro autor seguido de "et al." (significa "e outros")
//
// *****************************************************************************************
//
// b) Crie o metodo musicasDoAutor(...), cujo objetivo e' devolver todas as musicas que   
// contenham o autor passado em argumento, quer as musicas tenham um ou varios autores.
//
// N�o deve usar um inspetor que devolva a lista de autores da classe MusicaComVariosAutores
// 
// *****************************************************************************************
//	
// c) Crie e use um comparador que permita ordenar musicas por ordem crescente de duracao, 
// e, para musicas com a mesma duracao, o desempate deve ser por ordem alfabetica do titulo. 
// Ordene as musicas de forma a testar o comparador.
// 
// *****************************************************************************************
// 
// d) Crie o metodo filtrarMusicas(...), cujo objetivo e' remover de uma lista todas as 
// musicas de acordo com um objeto FiltroDeMusicas que � passado no argumento. Teste de  
// forma a retirar da lista todas as musicas que tenham uma duracao superior a 6 minutos.
// 
// Pode usar expressoes lambda para testar.
//

public class Main {

	public static void main(String[] args) {
		String[] n = {"xa", "ya"};
		MusicaComVariosAutores m = new MusicaComVariosAutores("ana", n, new Time(1, 50));
		System.out.println(m);
		//
		//
		//
		ArrayList<Musica> listaComMusica = new ArrayList<>();
		listaComMusica.addAll(Leitor.lerMusicas("musicas.txt"));
		System.out.println();
		System.out.println("**************SEARCH SONGS************");
		System.out.println(musicasDoAutor("Serafim"));
		System.out.println();
		System.out.println("****************SORT******************");
		SortByTimeWithAlphabetical(listaComMusica);
		System.out.println(listaComMusica);
		System.out.println();
		System.out.println("****************FILTRO******************");
		fitrarMusicas(listaComMusica,  o -> o.getDuracao().getMinutos() >= 6);
		System.out.println(listaComMusica);
		
	}
	
	public static ArrayList<Musica> musicasDoAutor(String autor){
		ArrayList<Musica> listaComMusica = new ArrayList<>();
			listaComMusica.addAll(Leitor.lerMusicas("musicas.txt"));
		ArrayList<Musica> listaDeMusicaParaAutor = new ArrayList<>();
			for(Musica x: listaComMusica) {
				if(x.contemAutor(autor))
					listaDeMusicaParaAutor.add(x);
			}
		return listaDeMusicaParaAutor;
	}
	public static void fitrarMusicas(ArrayList<Musica> listaComMusica, FiltroDeMusicas filto){
		ArrayList<Musica> removeItems = new ArrayList<Musica>();
		for(Musica x: listaComMusica)
			if(filto.excluir(x))
				removeItems.add(x);
		listaComMusica.removeAll(removeItems);
	}
	public static void SortByTimeWithAlphabetical(ArrayList<Musica> listaComMusica) {
		listaComMusica.sort(((o1, o2) -> compareTimeABC(o1,o2)));
	}
	
	private static int compareTimeABC(Musica m1, Musica m2) {
		if(m1.getDuracao().totalSeconds() == m2.getDuracao().totalSeconds())
			return m1.getTitulo().compareTo(m2.getTitulo());
		else
			return m1.getDuracao().totalSeconds() - m2.getDuracao().totalSeconds();
	} 

}
