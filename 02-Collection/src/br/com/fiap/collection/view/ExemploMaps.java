package br.com.fiap.collection.view;

import java.util.HashMap;
import java.util.Set;

public class ExemploMaps {
    public static void main(String[] args) {
        // Mapa de estados
        HashMap<String, String> mapa = new HashMap<>();
        
        // Adicionar 3 estados no mapa
        mapa.put("SP", "São Paulo");
        mapa.put("RJ", "Rio de Janeiro");
        mapa.put("AM", "Amazonas");
        
        // Recuperar o valor da chava "AM"
        System.out.println(mapa.get("AM"));
        
        // Exibir a quantidade de elementos no mapa
        System.out.println(mapa.size());
        
        // Remover o SP
        mapa.remove("SP");
        
        // Recuperar todas as chaves do mapa
        Set<String> chaves = mapa.keySet();
        
        for(String item : chaves) {
            System.out.println(mapa.get(item) + "(" + item + ")");
        }
    }// MAIN
}// CLASS