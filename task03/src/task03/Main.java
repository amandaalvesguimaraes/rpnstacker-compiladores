package task03;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
		List<Token> tokens = new ArrayList<Token>();
		Scanner in = new Scanner(System.in);
		String elementos;
		Integer a;
		Integer b;
		ManipuladorArquivo arquivo = new ManipuladorArquivo("resources/calc1.txt");
		boolean error = false;
		String elementosarq = arquivo.getNextLine();
		Regex reg = new Regex();
		
	
		
		
		while (!elementosarq.contentEquals("")) {
			if (reg.isNum(elementosarq)) {
				pilha.push(Integer.parseInt(elementosarq));
				tokens.add(new Token(TokenType.NUM, elementosarq));
			} else if (reg.isOP(elementosarq)) {
				if (reg.isPlus(elementosarq)) {
					tokens.add(new Token(TokenType.PLUS, "+"));
					a = pilha.pop();
					b = pilha.pop();
					pilha.push(b+a);
				} else if (reg.isMinus(elementosarq)) {
					tokens.add(new Token(TokenType.MINUS, "-"));
					a = pilha.pop();
					b = pilha.pop();
					pilha.push(b-a);
				} else if (reg.isSlash(elementosarq)) {
					tokens.add(new Token(TokenType.SLASH, "/"));
					a = pilha.pop();
					b = pilha.pop();
					pilha.push(b/a);
				} else {
					tokens.add(new Token(TokenType.STAR, "*"));
					a = pilha.pop();
					b = pilha.pop();
					pilha.push(b*a);
				}
				
			} else {
				System.out.println("Error:  Unexpected character: " + elementosarq);
				error = true;
				break;
			}
			elementosarq = arquivo.getNextLine();
			
		}
		
		
		
		/*
		VERSÃO PARA LER OS VALORES DO TECLADO
		
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
		
		if (!error) {
			
			int tsize = tokens.size();
			for (int i = 0; i < tsize; i++ ) {
				System.out.println(tokens.get(i).toString());
			}
			
			System.out.println("Saída: " + pilha.pop());
		}

		
	}

}