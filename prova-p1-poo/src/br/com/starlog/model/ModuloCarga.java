package br.com.starlog.model;

import java.util.ArrayList;
import java.util.List;

import br.com.starlog.exception.CapacidadeExcedidaException;

public class ModuloCarga {
    private String codigoModulo;
    private int capacidadeMaxima;
    private List<Carga> cargas;

    // Método construtor: Inicializa o objeto, também já cria uma lista sempre que um objeto for criado 
    public ModuloCarga(String codigoModulo, int capacidadeMaxima) {
        this.codigoModulo = codigoModulo;
        this.capacidadeMaxima = capacidadeMaxima;

        this.cargas = new ArrayList<>(capacidadeMaxima);
    }

    // Métodos Getters
    public String getCodigoModulo() {
        return codigoModulo;
    }

    public List<Carga> getCargas() {
        return cargas;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    // Métodos Setters
    public void setCodigoModulo(String codigoModulo) {
        this.codigoModulo = codigoModulo;
    }

    public void setCargas(List<Carga> cargas) {
        this.cargas = cargas;
    }

    // Método carregarCarga: confere se o modulo já atingiu a capacidade total, se não atingiu adiciona a carga, se já
    // atingiu lança exceção
    public void carregarCarga(Carga carga) throws CapacidadeExcedidaException{
        if(this.cargas.size() >= capacidadeMaxima){
            throw new CapacidadeExcedidaException("Exceção capturada: Modulo '" + codigoModulo + "' atingiu a capacidade máxima de " + capacidadeMaxima + " cargas");
        }

        this.cargas.add(carga);
    }

    // Método calcularSeguroTotal: Passa por cada elemento da List de cargas, pega o seu valorSeguro e soma com .sum(),
    // retornando a soma total
    public double calcularSeguroTotal(){
        return cargas.stream().mapToDouble(Carga::getValorSeguro).sum();
    }

    // Método contarCargasPorCategoria:Passa por cada elemento e confere se a categoria do elemento é igual a categoria 
    // passada no argumento, se for soma 1 a contagem de categoria
    public long contarCargasPorCategoria(String categoria){
        return cargas.stream().filter(carga -> carga.getCategoria().equals(categoria)).count();
    }

    // Método calcularSeguroCargasPesadas: Filtra por categoria, depois filtra por peso e por fim, soma e retorna o vslor 
    // total de seguro dos elementos
    public double calcularSeguroCargasPesadas(String categoria, double pesoMinimo){
        return cargas.stream().filter(carga -> carga.getCategoria().equals(categoria))
                              .filter(carga -> carga.getPesoKg() > pesoMinimo)
                              .mapToDouble(Carga::getValorSeguro).sum();
    }
}
