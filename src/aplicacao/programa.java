package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoXadrez;
import xadrez.XadrezException;

public class programa {

	public static void main(String[] args) {
		/*
		 * Testando posição no tabuleiro
		 */
//		Tabuleiro mesa = new Tabuleiro(3,8);
//		System.out.println(mesa.getColunas());
		
		Scanner input = new Scanner(System.in);
			
		PartidaDeXadrez xadrez = new PartidaDeXadrez();
		
		while(true) {
			
			try {
			
				UI.limpaTela();
				
				UI.mostrarTabuleiro(xadrez.getPecas());
				System.out.println();
				
				System.out.println("Peca Início: ");
				PosicaoXadrez inicio = UI.lerPosicaoXadrez(input);
				
				System.out.println();
				
				System.out.println("Peca Destino: ");
				PosicaoXadrez destino = UI.lerPosicaoXadrez(input);
				
				
				PecaDeXadrez pecaAtual = xadrez.perfomanceDaAcaoDaPeca(inicio, destino);
			} catch(XadrezException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			} catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			}
		}
		
	}
}
