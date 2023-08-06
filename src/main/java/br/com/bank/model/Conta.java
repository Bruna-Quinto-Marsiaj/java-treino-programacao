package br.com.bank.model;


public class Conta {

	private double saldo;
	private String cpf;

	

	public Conta() {
    }

	public Conta(String cpf, int i) {
		this.cpf = cpf;
		saldo = i;
	}

    public double getSaldo() {
		return saldo;
	}

	public String getCpf() {
		return cpf;
	}
}
