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
        this.elem = new int[maxFil][maxCol];
        this.maxFil = maxFil;
        this.maxCol = maxCol;
        this.cantFil = cantFil;
        this.cantCol = cantCol;
    }
    public Matriz2(Matriz2 m) {
        this.elem = new int[m.maxFil][m.maxCol];
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
    
    public int cantFil(){
        return cantFil;
    }
    public int cantCol(){
        return cantCol;
    }
    public int elem(int i,int j){
        return elem[i][j];
    }
    public void setElem(int i,int j,int elem){
        this.elem[i][j] = elem;
    }
    
    public void mostrar(){
        for (int i = 0; i < cantFil; i++) {
            for (int j = 0; j < cantCol; j++) {
                System.out.print(elem[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("------------");
    }
    public Matriz2 subMatriz(int i,int j,int a,int b){
        Matriz2 m1 = new Matriz2(a-i+1,b-j+1,a-i+1,b-j+1);
        int i2 = 0;
        for (int x = i; x <=a; x++) {
            int j2 = 0;
            for (int y = j; y <= b; y++) {
                m1.setElem(i2, j2, elem[x][y]);
                j2++;
            }
            i2++;
        }
        return m1;
    }
    
    
    
    
    
    
    
    

}
