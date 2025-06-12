package br.com.apoiodesk.model;

public class Venda {
	
	private int id;
    private String produto;
    private int quantidade;
    private double valor;

    // Construtor
    public Venda(int id, String produto, int quantidade, double valor) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    // Getters
    public int getId() { return id; }
    public String getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
    public double getValor() { return valor; }
}


