/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jantardosfilosofos;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 *
 * @author 2015.1.08.026
 */
public class Filosofos extends Thread implements Runnable {

    String nomefilo;
    int id;
    static Semaphore mutex = new Semaphore(1);
    static Semaphore[] semaforos;
    static Filosofos[] filosofos;
    static Filosofos aux;

    private int contfilo;

    public enum Estado {
        PENSANDO, FOME, COMENDO;
    }
    Estado estado;

    public void CreateFilosofos(String nome, int filosofo) {
        aux = new Filosofos(nome, Estado.PENSANDO, filosofo);
        filosofos[filosofo] = aux;
        semaforos[filosofo] = new Semaphore(0);
        this.contfilo = filosofo;
    }

    public Filosofos(int quant) {
        filosofos = new Filosofos[quant];
        semaforos = new Semaphore[quant];
    }

    public Filosofos(String nome, Estado estado, int id) {
        this.nomefilo = nome;
        this.estado = estado;
        this.id = id;
    }

    public void Fome() {
        filosofos[contfilo].estado = Estado.FOME;
        System.out.println(nomefilo + " está com fome.");
    }

    public void Come() {
        estado = Estado.COMENDO;
        System.out.println(nomefilo + " está comendo.");
        tryy();

    }

    public void Pensa() {
        estado = Estado.PENSANDO;
        System.out.println(nomefilo + " está pensando");
        tryy();

    }

    public void Take() throws InterruptedException {
        mutex.acquire();
        Fome();
        Estado();
        mutex.release();
        semaforos[this.id].acquire();
    }

    public void Drop() throws InterruptedException {
        mutex.acquire();
        Pensa();
        filosofos[DefineEsquerda()].Estado();
        filosofos[DefineDireita()].Estado();
        mutex.release();
    }

    public int DefineEsquerda() {
        return (this.id + 1) % filosofos.length;
    }

    public int DefineDireita() {
        if (this.id == 0) {
            return filosofos.length - 1;
        }
        return (this.id - 1) % filosofos.length;
    }

    public void Estado() {
        if (filosofos[this.id].estado == Estado.FOME
                && filosofos[DefineEsquerda()].estado != Estado.COMENDO
                && filosofos[DefineDireita()].estado != Estado.COMENDO) {
            Come();
            semaforos[this.id].release();
        } else {
            System.out.println(filosofos[this.id].nomefilo + " Tentativa mal sucedida");
        }
    }

    public void tryy() {
        Random rand = new Random();
        int aleatorio = rand.nextInt(2000) + 1000;
        try {
            Thread.sleep(aleatorio);
        } catch (InterruptedException ex) {

        }
    }

    @Override
    public void run() {
        do {
            try {
                Pensa();
                System.out.println("");

                Take();
                Thread.sleep(1000L);
                Drop();

            } catch (InterruptedException ex) {
                System.out.println("Falha no programa.");
                return;
            }
        } while (true);
    }
}
