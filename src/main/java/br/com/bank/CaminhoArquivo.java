package br.com.bank;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CaminhoArquivo {


    private Path diretorio;

    private Path arquivo;

    /*private CaminhoArquivo(Path diretorio, Path arquivo) {
        super();// ver pq ta aqui
        this.diretorio = diretorio;
        this.arquivo = arquivo;
    }*/

    public CaminhoArquivo(Path diretorio, Path arquivo) {
        this.diretorio = diretorio;
        this.arquivo = arquivo;
    }

    public Path getDiretorio() {
        return diretorio;
    }

    public Path getArquivo() {
        return arquivo;
    }

    @Contract("_ -> new")
    public static @NotNull CaminhoArquivo getInstance(Integer id) {
        String b = "/tmp/";
        String d = null;
        if (id <= 1000) {
            b = b + 1;
            d = b + "/" + id ;
        } else if(id <= 2000) {
            b = b + 2;
            d = b + "/" + id ;
        } else {
            b = b + 3;
            d = b + "/" + id ;

        }
        return new CaminhoArquivo(Paths.get(b), Paths.get(d));

    }

    public static RuntimeException getInstance() {

        return new RuntimeException(" É esperado um valor inteiro no parâmetro do método CaminhoArquivo.getInstance()");
    }

}
