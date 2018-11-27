/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jantarComMonitor;

/**
 *
 * @author 2015.1.08.026
 */
public class Garfo {
    private int id;
    private boolean livre = true;
    
    public Garfo(int id){
        this.id = id;
    }
    
    public synchronized void pegaGarfo(int i) throws InterruptedException{
        while(!livre) wait();
        System.out.println("Filosofo " + i + " pega garfo " + id);
        livre = false;
    }
    
    public synchronized void soltarGarfo(int i ){
        livre = true;
        System.out.println("Filosofo " + i + " solta o garfo " + id);
        notify();
    }
}
