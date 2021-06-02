package tabuleiro;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;

	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
			throw new TabuleiroException("N�o h� pe�as suficientes para iniciar uma partida!");
		}
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];

	}

	public int getLinhas() {
		return this.linhas;
	}

	public int getColunas() {
		return this.colunas;
	}

	public Peca peca(int linha, int coluna) {
		if (!existePosicao(linha, coluna)) {
			throw new TabuleiroException("N�o h� pe�as suficientes para iniciar uma partida!");
		}
		return this.pecas[linha][coluna];
	}

	public Peca peca(Posicao posicao) {
		if (!existePosicao(posicao)) {
			throw new TabuleiroException("N�o existe essa posi��o no tabuleiro!");
		}
		return this.pecas[posicao.getLinha()][posicao.getColuna()];
	}

	public void LugarDaPeca(Peca peca, Posicao posicao) {
		if (existeUmaPeca(posicao)) {
			throw new TabuleiroException("Existe uma pe�a nesse local, mova para outro lugar - " + posicao);
		}

		pecas[posicao.getLinha()][posicao.getColuna()] = peca;
		peca.posicao = posicao;
	}
	
	public Peca removePeca(Posicao posicao) {
		if(!existePosicao(posicao)) {
			throw new TabuleiroException("N�o existe essa posi��o no tabuleiro!");
		}
		if(peca(posicao) == null) {
			return null;
		}
		
		Peca auxiliar = peca(posicao);
		auxiliar.posicao = null;
		pecas[posicao.getLinha()][posicao.getColuna()] = null;
		return auxiliar;
	}

	private boolean existePosicao(int linha, int coluna) {
		return linha >= 0 && linha < this.linhas && coluna >= 0 && coluna < this.colunas;
	}

	public boolean existePosicao(Posicao posicao) {
		return existePosicao(posicao.getLinha(), posicao.getColuna());
	}

	public boolean existeUmaPeca(Posicao posicao) {
		if (!existePosicao(posicao)) {
			throw new TabuleiroException("N�o existe essa posi��o no tabuleiro!");
		}
		return peca(posicao) != null;
	}

}
