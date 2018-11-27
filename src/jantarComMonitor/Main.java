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
public class Main {
    
        public static void main(String[] args) {
            Garfo[] garfos = new Garfo[5];
            for (int i = 0; i < garfos.length; i++) {
                garfos[i] = new Garfo(i);
            }
            Filosofo[] filosofos = new Filosofo[5];
            for (int i = 0; i < filosofos.length; i++) {
                filosofos[i] = new Filosofo(i, garfos[i], garfos[(i+1)%5]);
            }
            for (int i = 0; i < filosofos.length; i++) {
                filosofos[i].start();
            }
        }
}
