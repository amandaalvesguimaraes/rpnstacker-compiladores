/*
 * IMPLEMENTA��O RPNSTACKER 
 * DISCIPLINA: COMPILADORES
 * 
 * Amanda Guimar�es (aag)
 * 
 * H� uma vers�o, que est� como coment�rio no m�todo main, que l� os valores do teclado e n�o como um arquivo txt.
 * 
 * A vers�o original l� as entradas de um arquivo .txt chamado "calc1" que se encontra na pasta resources.
 * 
 */

package task01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

class ManipuladorArquivo {

	private String path;
	private BufferedReader buffRead;
	
	public ManipuladorArquivo(String p) throws FileNotFoundException {
		this.path = p;
		this.buffRead = new BufferedReader(new FileReader(this.path));
	}
	
	public String getNextLine() throws IOException {
		String linha = "";
		linha = buffRead.readLine();
		if (linha ==null) {
			linha = "";
		}
		return linha;
	}
	
}

public class Main {
	
	public static void main(String [] args) throws IOException {
		Stack<Integer> pilha = new Stack<Integer>();
		Scanner in = new Scanner(System.in);
		String elementos;
		Integer a;
		Integer b;
		ManipuladorArquivo arquivo = new ManipuladorArquivo("resources/calc1.txt");
		
		String elementosarq = arquivo.getNextLine();
		
		while (!elementosarq.contentEquals("")) {
			if (elementosarq.contentEquals("+")) {
				a = pilha.pop();
				b = pilha.pop();
				pilha.push(b+a);
			} else if (elementosarq.contentEquals("-")) {
				a = pilha.pop();
				b = pilha.pop();
				pilha.push(b-a);
			} else if (elementosarq.contentEquals("*")) {
				a = pilha.pop();
				b = pilha.pop();
				pilha.push(b*a);
			} else if (elementosarq.contentEquals("/")) {
				a = pilha.pop();
				b = pilha.pop();
				pilha.push(b/a);
			} else {
				pilha.push(Integer.parseInt(elementosarq));
			}
			elementosarq = arquivo.getNextLine();
		}
		
		
		/*
		VERS�O PARA LER OS VALORES DO TECLADO
		
		while (in.hasNextLine()) {
			elementos = in.nextLine();
			if (elementos.contentEquals("+")) {
				a = pilha.pop();
				b = pilha.pop();
				pilha.push(b+a);
			} else if (elementos.contentEquals("-")) {
				a = pilha.pop();
				b = pilha.pop();
				pilha.push(b-a);
			} else if (elementos.contentEquals("*")) {
				a = pilha.pop();
				b = pilha.pop();
				pilha.push(b*a);
			} else if (elementos.contentEquals("/")) {
				a = pilha.pop();
				b = pilha.pop();
				pilha.push(b/a);
			} else {
				pilha.push(Integer.parseInt(elementos));
			}
		}
		*/
		
		System.out.println(pilha.pop());
		
	}

}
