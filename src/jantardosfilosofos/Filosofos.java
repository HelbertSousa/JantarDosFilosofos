/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jantardosfilosofos;
import  jantardosfilosofos.Estado.acaofilo;

/**
 *
 * @author 2015.1.08.026
 */
public class Filosofos extends Thread{
    String filosofos[];
    Estado estado[];

    
    public Filosofos(String nome, int filo, int quantfilo) {
        super(nome);
        filosofos = new String[quantfilo];
        estado = new Estado[quantfilo];
        filosofos[filo] = nome;
    
    }
    
    public void Fome(int filo){
        estado[filo] = (Estado)FOME;
    }
    
    
}
