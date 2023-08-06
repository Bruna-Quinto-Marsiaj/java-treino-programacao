package br.com.bank.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Banco {

    private String nome;

    public Banco(String nome) {
        this.nome = nome;
    }

    private List<Conta> contas = new ArrayList<>();

    private Map<String, Conta> contasMap = new HashMap<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
        contasMap.put(conta.getCpf(), conta);
    }
    public Conta pesquisarContaDoCliente(String cpf) {
       /*  Conta c = null;
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getCpf().equals(cpf)) {
                c = contas.get(i);
             
            }
        }*/
        return contasMap.get(cpf);
    }

    public List<Conta> listarContasAltaRenda() {
        return filtrarContas(c -> c.getSaldo() >= 10000);
    }

    private List<Conta> filtrarContas(Predicate<Conta> filtro) {
        return contas.stream().filter(filtro).collect(Collectors.toList());
    }
    public Integer getTotalDeContas() {
        return contas.size();
    }
}
