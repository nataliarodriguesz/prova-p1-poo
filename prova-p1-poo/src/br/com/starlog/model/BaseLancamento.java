package br.com.starlog.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BaseLancamento {
    private Map<String, ModuloCarga> modulos;

    // Método construtor
    public BaseLancamento() {
        this.modulos = new HashMap<>();
    }

    // Cadasta um novo módulo com 'put'
    public void cadastrarModulo(ModuloCarga moduloCarga){
        modulos.put(moduloCarga.getCodigoModulo(), moduloCarga);
        System.out.println("Modulo '" + moduloCarga.getCodigoModulo() + "' cadastrado na base com capacidade de " + moduloCarga.getCapacidadeMaxima() + " cargas.");
    }

    // Busca um modulo passando o código como argumento
    public Optional<ModuloCarga> buscarModulo(String codigoModulo){
        return Optional.ofNullable(modulos.get(codigoModulo));
    }
}
