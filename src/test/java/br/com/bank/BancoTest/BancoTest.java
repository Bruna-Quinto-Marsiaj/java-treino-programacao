package br.com.bank.BancoTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.bank.model.Banco;
import br.com.bank.model.Conta;

@ExtendWith(MockitoExtension.class)
public class BancoTest {


    @InjectMocks
    private Banco inter;
    private Conta conta;

    @BeforeEach// ver se n vai antes do add conta
    public void zerarConta(){
        conta = new Conta();

    }

    @Test
    public void deveAdicionarContaNoBanco(){
        Conta conta1 = new Conta("08731740545", 1000), conta2 = new Conta("08731740541", 11000);
        inter.adicionarConta(conta1);
        inter.adicionarConta(conta2);

        assertEquals(2, inter.getTotalDeContas());
    }

    @Test
    public void devePesquisarContaDoCliente(){
        Conta conta1 = new Conta("08731740545", 1000), conta2 = new Conta("08731740541", 11000);
        inter.adicionarConta(conta1);
        inter.adicionarConta(conta2);
        inter.pesquisarContaDoCliente("08731740545");

       
		assertEquals(conta1.getCpf(), inter.pesquisarContaDoCliente("08731740545").getCpf());
        assertEquals(conta2.getCpf(), inter.pesquisarContaDoCliente("08731740541").getCpf());
    }

    @Test
    public void deveListarContasAltaRenda(){
        criarContasAleatoriasDeBaixaeAltaRenda();

		List<Conta> contasAltaRenda = inter.listarContasAltaRenda();

		assertEquals(3, contasAltaRenda.size());
	}

	







    private void criarContasAleatoriasDeBaixaeAltaRenda() {
		// baixa renda
		inter.adicionarConta(new Conta("92468831010", 500));
		inter.adicionarConta(new Conta("92468831012", 1000));

		// classe média
		inter.adicionarConta(new Conta("40302693033", 3000));

		// alta renda
		inter.adicionarConta(new Conta("59432843033", 15000));
		inter.adicionarConta(new Conta("68356490030", 20000));
		inter.adicionarConta(new Conta("77243837077", 20000000));

    }

}





