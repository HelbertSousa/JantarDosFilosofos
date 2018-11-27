/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jantardosfilosofos;

import java.util.concurrent.Semaphore;

/**
 *
 * @author 2015.1.08.026
 */
public class Filosofos extends Thread implements Runnable{
    static Semaphore mutex = new Semaphore(1);
    static Semaphore[] semaforos;
    static Filosofos[] filosofos;
    
    public Filosofos(int quant){
        filosofos = new Filosofos[quant];
        semaforos = new Semaphore[quant];    
    }
    
    String nomefilo;
    
    static int filo = -1;
    
    public enum Estado{
        PENSANDO, FOME, COMENDO;
    }
    Estado estado;

    public Filosofos(String nome, int filosofo) {
        this.filo++;
        filosofos[filo].nomefilo = nome;
        filosofos[filo].estado = Estado.PENSANDO;
        
    }

    public void Fome(){
        filosofos[filo].estado = Estado.FOME;
        System.out.println(nomefilo + " está com fome.");
    }
    
    public void Come(){
        estado = Estado.COMENDO;
        System.out.println(nomefilo + " está comendo.");
        run();
    }
    
    public void Pensa(){
        estado = Estado.PENSANDO;
        System.out.println(nomefilo + " está pensando");
        run();
    }
    
    public void LargarGarfo() throws InterruptedException{
        mutex.acquire();
        Pensa();
        
    }
    
    public int DefineEsquerda(){
        return (this.filo + filo - 1) % filo;
    }
    
    public int DefineDireita(){
        return (this.filo + 1) % filo;
    }
    
    public void run (){        
        do{
            try
            {
                Thread.sleep(1000L);
            }
            catch (InterruptedException ex){
                System.out.println("Falha no programa.");
            }
        }
        while (true);
    }
    
}
