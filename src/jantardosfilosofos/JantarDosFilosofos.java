/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jantardosfilosofos;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 *
 * @author 2015.1.08.026
 */
public class JantarDosFilosofos extends Thread{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int n;
        //System.out.println("Digite a quantidade de filosofos");
        //n = ler.nextInt();

        Filosofos filosofos = new Filosofos(6);
        
        //Caso queira entrar manualmente e com a quantidade que quiser de filosofos.
//      String x;
//      for (int i = 0; i < n; i++) {
//            System.out.println("Digite os Nomes dos Filosofos");
//            x = ler.nextLine();
//            Filosofos filo = new Filosofos(x,i,filosofos);
//            filosofos[i] = filo;
//            semaforos[i] = new Semaphore(0);
//            filosofos[i].start();
//      }
        filosofos.CreateFilosofos("Nietzsche", 0);
        filosofos.CreateFilosofos("Spinoza", 1);
        filosofos.CreateFilosofos("Descartes", 2);
        filosofos.CreateFilosofos("Karl Marx", 3);
        filosofos.CreateFilosofos("Schopenhauer", 4);
        filosofos.CreateFilosofos("Aristoteles", 5);
        
        for (int i = 0; i < Filosofos.filosofos.length; i++) {
            Filosofos.filosofos[i].start();
        }
        
        try {
            Thread.sleep(10000);
            System.exit(0);
        } catch (InterruptedException ex) {
            System.out.println("Falhou");
        }
    }

}
