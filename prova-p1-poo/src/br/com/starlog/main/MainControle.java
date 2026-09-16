package br.com.starlog.main;

import java.util.HashSet;
import java.util.Optional;

import br.com.starlog.exception.CapacidadeExcedidaException;
import br.com.starlog.model.BaseLancamento;
import br.com.starlog.model.Carga;
import br.com.starlog.model.ModuloCarga;

public class MainControle {
    public static void main(String[] args) {
        // P01. Instancie 4 cargas e imprima c1 e c4
        Carga c1 = new Carga("ORB-101-SP", "CRIOGENICA", 2.5, 450.00);
        Carga c2 = new Carga("ORB-102-RJ", "PADRAO", 8.0, 120.00);
        Carga c3 = new Carga("ORB-103-MG", "CRIOGENICA", 12.0, 850.00);
        Carga c4 = new Carga("ORB-104-PR", "BIOLOGICA", 15.0, 300.00);

        System.out.println(c1);
        System.out.println(c4);

        // P02. Instancia um módulo orbital, instancia uma base de lançamento e cadastre o módulo na base
        ModuloCarga modulo = new ModuloCarga("MOD-ALFA-01", 3);  
        BaseLancamento baseLancamento = new BaseLancamento();
        baseLancamento.cadastrarModulo(modulo);

        // P03. Careegue c1, c2 e c3 no módulo
        try {
            modulo.carregarCarga(c1);
            System.out.println("Carga '" + c1.getCodigoRastreio() + "' carregada no modulo com sucesso");
            modulo.carregarCarga(c2);
            System.out.println("Carga '" + c2.getCodigoRastreio() + "' carregada no modulo com sucesso");
            modulo.carregarCarga(c3);
            System.out.println("Carga '" + c3.getCodigoRastreio() + "' carregada no modulo com sucesso");
        } catch (CapacidadeExcedidaException e){
            System.out.println(e.getMessage());
        }

        // P04. Tente carregar c4
        try {
            modulo.carregarCarga(c4);
            System.out.println("Carga '" + modulo.getCodigoModulo() + "' carregada no modulo com sucesso");
        } catch (CapacidadeExcedidaException e){
            System.out.println(e.getMessage());
        }

        // P05. Recupere o módulo da base
        Optional<ModuloCarga> base = baseLancamento.buscarModulo("MOD-ALFA-01");
        System.out.println("Módulo localizado na base: " + base);

        // P06. Chame o método modulo.calcularSeguroTotal()
        System.out.println("Seguro total do modulo: R$" + modulo.calcularSeguroTotal());

        // P07. Chame o modulo.contarCargasPorCategoria("CRIOGENICA")
        System.out.println("Cargas CRIOGENICA: " + modulo.contarCargasPorCategoria("CRIOGENICA"));

        // P08. Chame o modulo.calcularSeguroCargasPesadas("CRIOGENICA", 5.0)
        System.out.println("Seguro de cargas críticas (CRIOGENICA > 5Kg): R$" + modulo.calcularSeguroCargasPesadas("CRIOGENICA", 5.0));

        // P09. Crie um hashset e adicione 3 cargas (sendo uma um clone), imprimi o tamanho. Depois, tente capturar em um try catch
        // a exceção para argumento nulo
        HashSet<Carga> manifesto = new HashSet<>();
        Carga c1_clone = new Carga("ORB-101-SP", "CRIOGENICA", 9.0, 990.00);

        manifesto.add(c1);
        manifesto.add(c1_clone);
        manifesto.add(c2);
        System.out.println("Tamanho do manifesto(HashSet): " + manifesto.size());

        try {
            Carga c = new Carga("", "PADRAO", 1.0, 50.00);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
