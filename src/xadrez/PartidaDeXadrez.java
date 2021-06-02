package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {

	private Tabuleiro tabuleiro;
	
	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8,8); 
		arrumarAsPecas();
	}
	
	public PecaDeXadrez[][] getPecas(){
		PecaDeXadrez[][] matriz = 
				new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
		for(int i = 0; i < tabuleiro.getLinhas(); i++) {
			for(int j = 0; j < tabuleiro.getColunas(); j++) {
				matriz[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
			}
		}
		return matriz;
	}
	
	public PecaDeXadrez perfomanceDaAcaoDaPeca(PosicaoXadrez posicaoOrigem, PosicaoXadrez posicaoDestino) {
		Posicao localInicial = posicaoOrigem.paraPosicao();
		Posicao localDestino = posicaoDestino.paraPosicao();
		
		validaPosicaoInicial(localInicial);
		Peca pecaAtual = fazerMovimento(localInicial,localDestino);
		
		return (PecaDeXadrez) pecaAtual;
	}
	
	private Peca fazerMovimento(Posicao mInicial, Posicao mFinal) {
		Peca pecaDaMesaSelecionadaQuevaiJogar = tabuleiro.removePeca(mInicial);
		Peca pecaDaMesaSelecionadaQuejaJogou = tabuleiro.removePeca(mFinal);
		
		tabuleiro.LugarDaPeca(pecaDaMesaSelecionadaQuevaiJogar, mFinal);
		return pecaDaMesaSelecionadaQuejaJogou;
	}
	
	private void validaPosicaoInicial(Posicao posicao) {
		if(!tabuleiro.existeUmaPeca(posicao)) {
			throw new XadrezException("Não há peça nessa posição");
		}
	}
	
	private void novoLugarDaPeca(char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.LugarDaPeca(peca, new PosicaoXadrez(coluna,linha).paraPosicao());
	}
	
	private void arrumarAsPecas() {
//		novoLugarDaPeca('b', 6, new Torre(tabuleiro, Cor.BRANCO));
//		novoLugarDaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
//		novoLugarDaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));
		
		novoLugarDaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
		novoLugarDaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
		novoLugarDaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
		novoLugarDaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
		novoLugarDaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
		novoLugarDaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

		novoLugarDaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
		novoLugarDaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
		novoLugarDaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
		novoLugarDaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
		novoLugarDaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
		novoLugarDaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
	}
}
