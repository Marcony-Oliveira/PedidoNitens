package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrdemStatus;

public class Ordem {
	
	private Date momento;
	private OrdemStatus status;
	
	SimpleDateFormat sdf = new SimpleDateFormat(); // Objeto sdf para formatar a data
	
	public Cliente cliente; // Associa a classe Ordem a classe cliente
	
	private List<OrdemItem> itens = new ArrayList<>(); //Cria a lista que vai receber os itens
	
	public Ordem() {
	}

	

	public Ordem(Date momento, OrdemStatus status, Cliente cliente) {
		super();
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
		
	}



	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public OrdemStatus getStatus() {
		return status;
	}

	public void setStatus(OrdemStatus status) {
		this.status = status;
	}

	public List<OrdemItem> getItens() {
		return itens;
	}
	
	public void addItem(OrdemItem item) { //Método para adicionar na lista
		itens.add(item);
	}
	
	public void removeItem(OrdemItem item) {//Método para retirar na lista
		itens.add(item);
	}
	
	public double total() { //Método para retornar o valor total dos produtos
		double soma =0.0;
		for(OrdemItem item:itens) { //Para minha lista OrdemItem percorra todos os itens
			soma+=item.subTotal(); // variável soma recebe ela mesma + item (percorrido pelo laço) + método subtotal criado em OrdemItem
		}
		return soma;
	}



	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();//Para concatenações de grandes strings
		sb.append("Momento: ");
		sb.append(sdf.format(momento)+"\n"); // usei o objeto instaciado sdf para formatar a data
		sb.append("Status: ");
		sb.append(status+"\n");
		sb.append("Cliente: ");
		sb.append(cliente+"\n");
		sb.append("Ordem itens: ");
		
		for (OrdemItem item : itens ) {
			sb.append(item+"\n");
		}
		
		sb.append("Preço total: ");
		sb.append(String.format("%.2f",total()));
		return sb.toString();
	}
	
	
	

	
	
	
	
	
	
	
	
	
	

}
