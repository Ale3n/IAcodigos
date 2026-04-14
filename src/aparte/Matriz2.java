/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aparte;

/**
 *
 * @author Tower
 */
public class Matriz2 {
    private int elem[][];
    private int maxFil;
    private int maxCol;
    private int cantFil;
    private int cantCol;

    public Matriz2(int maxFil, int maxCol, int cantFil, int cantCol) {
        elem = new int[maxFil][maxCol];
        this.maxFil = maxFil;
        this.maxCol = maxCol;
        this.cantFil = cantFil;
        this.cantCol = cantCol;
    }
    public Matriz2(Matriz2 m){
        elem = new int[m.maxFil][m.maxCol];
        this.maxFil = m.maxFil;
        this.maxCol = m.maxCol;
        this.cantFil = m.cantFil;
        this.cantCol = m.cantCol;
        for (int i = 0; i < m.cantFil; i++) {
            for (int j = 0; j < m.cantCol; j++) {
                this.elem[i][j] = m.elem[i][j];
            }
        }
    }
    
    public void eliminarFil(int k){
        for (int i = k+1; i < cantFil; i++) {
            for (int j = 0; j < cantCol; j++) {
                this.elem[i-1][j] = elem[i][j];
            }
        }
    }
    public void eliminarCol(int k){
        for (int i = 0; i < cantFil; i++) {
            for (int j = k+1; j < cantCol; j++) {
                this.elem[i][j-1] = elem[i][j];
            }
        }
    }
    
    public int elem(int i,int j){
        return elem[i][j];
    }
    public int cantFil(){
        return cantFil;
    }
    public int cantCol(){
        return cantCol;
    }
    
    public void mostrar(){
        for (int i = 0; i < cantFil; i++) {
            for (int j = 0; j < cantCol; j++) {
                System.out.print(elem[i][j] + "\t");  
            }
            System.out.println();
        }
        System.out.println();
    }
    
    
  
    
}
