package br.com.starlog.model;

public class Carga {
    private String codigoRastreio;
    private String categoria;
    private double pesoKg;
    private double valorSeguro;

    // Método construtor: para criar um objeto já passando seus valores
    public Carga(String codigoRastreio, String categoria, double pesoKg, double valorSeguro) throws IllegalArgumentException{

        // Testa se o codigoRastreio passado por argumento é nulo ou vazio, caso seja, ele lança a exceção e NÂO cria o objeto
        if (codigoRastreio == null || codigoRastreio.trim().isEmpty()){
            throw new IllegalArgumentException("Codigo de rastreio da carga não pode ser nulo ou vazio");
        }

        this.codigoRastreio = codigoRastreio;
        this.categoria = categoria;
        this.pesoKg = pesoKg;
        this.valorSeguro = valorSeguro;
    }

    // Métodos Getters para acessar um atributo privado
    public String getCodigoRastreio() {
        return codigoRastreio;
    }
    public String getCategoria() {
        return categoria;
    }
    public double getPesoKg() {
        return pesoKg;
    }
    public double getValorSeguro() {
        return valorSeguro;
    }

    // Imutabilidade: não tem métodos sets, depois de criado não pode ser alterado

    // Métodos equals e hashCode: Dois objetos são iguais quando seus números de rastreio(codigoRastreio) são iguais
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoRastreio == null) ? 0 : codigoRastreio.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carga other = (Carga) obj;
        if (codigoRastreio == null) {
            if (other.codigoRastreio != null)
                return false;
        } else if (!codigoRastreio.equals(other.codigoRastreio))
            return false;
        return true;
    }

    // Método toString: Usado para representação textual do objeto
    @Override
    public String toString() {
        return "Carga[rastreio=" + codigoRastreio +
               ", categoria=" + categoria + 
               ", peso=" + pesoKg + "kg" +
               ", seguro=R$" + valorSeguro + ']';
    }
}
