package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Cliente;
import entities.Ordem;
import entities.OrdemItem;
import entities.Produto;
import entities.enums.OrdemStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner read = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");// M�scara para ler uma data
		
		System.out.println("Entre com os dados do cliente:");
		System.out.print("Nome: ");
		String nome = read.next();
		System.out.print("Email: ");
		String email = read.next();
		System.out.print("Anivers�rio (dd/MM/yyyy): ");
		Date data = sdf.parse(read.next()); // pediu para adicionar uma exce��o
	    Cliente cliente = new Cliente(nome,email,data);
	    
	    System.out.println("---------------------------------------------");
	    System.out.println("Entre com os dados da ordem:");
	    System.out.print("Status: ");
	    OrdemStatus status = OrdemStatus.valueOf(read.next()); //lendo um status que est� na ENUM
	    Ordem ordem = new Ordem(new Date(),status,cliente); //Instancia na classe ordem
	    System.out.println("Quantos itens deseja adicionar:");
	    int qt = read.nextInt();
	    
	    for(int i=1;i<=qt;i++) {
	    	System.out.println("Digite os dados do item "+i+".");
	    	System.out.print("Nome do produto:");
	    	String nome_produto = read.next();
	    	System.out.print("Pre�o:");
	    	Double preco = read.nextDouble();
	    	System.out.print("Quantidade:");
	    	int quantidade = read.nextInt();
	    	Produto produto = new Produto(nome_produto,preco);
	    	OrdemItem ordemItem = new OrdemItem(quantidade,preco,produto);
	    	ordem.addItem(ordemItem);
	    	
	    	
	    }
	    
	    System.out.println("------------------------------------------------");
	    System.out.println("Sum�rio dos dados digitados:");
	    System.out.print(ordem);
	    
	    read.close();

	}

}
