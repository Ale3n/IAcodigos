/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examplesia;
import java.util.Random;
 /*public Matriz subMatriz(int i, int j, int a, int b){
        Matriz M2 = new Matriz(a-i,b-j,a-i,b-j);
        int i2 = 0;
        int j2 = 0;
        for (int x = 0; x>=i && x<=a; x++) {
            for (int y = 0; y>=j && y<=b; y++) {
                M2.setElem(i2, j2, elem[x][y]);
                j2++;
            }
            i2++;
        }
        return M2;
    }*/
/**
 *
 * @author LENOVO
 */
public class Matriz {
    private int elem[][];
    private int maxFil;
    private int maxCol;
    private int cantFil;
    private int cantCol;
        
    public Matriz(int maxFil, int maxCol, int cantFil, int cantCol){
        elem = new int[maxFil][maxCol];
        this.cantFil = cantFil;
        this.cantCol = cantCol;
        this.maxFil = maxFil;
        this.maxCol = maxCol;    
    }
    public Matriz(Matriz M1){
        elem = new int[M1.maxFil][M1.maxCol];
        this.cantFil = M1.cantFil;
        this.cantCol = M1.cantCol;
        this.maxFil = M1.maxFil;
        this.maxCol = M1.maxCol;

        // copiar datos
        for (int i = 0; i < cantFil; i++) {
            for (int j = 0; j < cantCol; j++) {
                elem[i][j] = M1.elem[i][j];
            }
        } 
    }
    public void eliminarFil(int k){
        for (int i = k+1; i < cantFil; i++) {
            for (int j = 0; j < cantCol; j++) {
                elem[i-1][j] = elem[i][j];
            }
        }
        cantFil = cantFil -1;
    }
    public void eliminarCol(int k) {
        for (int i = 0; i < cantFil; i++) {
            for (int j = k + 1; j < cantCol; j++) {
                elem[i][j-1] = elem[i][j];
            }
        }
        cantCol--;
    }
    public int elem(int i, int j){
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
    
    public void setElem(int fila,int columna,int valor){
        if (fila>=0 && fila<cantFil && columna>=0 && columna<cantCol) {
            elem[fila][columna] = valor;
        } else {
           System.out.println("Fuera de rango");
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cantFil; i++) {
            for (int j = 0; j < cantCol; j++) {
                sb.append(elem[i][j]).append("\t");
            }
            sb.append("\n");
        }
        sb.append("------------");

        return sb.toString();
    }
    public void generarRandom(int a, int b){
        Random r = new Random();

        for (int i = 0; i < cantFil; i++) {
            for (int j = 0; j < cantCol; j++) {
                elem[i][j] = r.nextInt(b - a + 1) + a;
            }
        }
    }
    
   
    public Matriz subMatriz(int i, int j, int a, int b){
        Matriz M2 = new Matriz(a - i + 1, b - j + 1, a - i + 1, b - j + 1);
        int i2 = 0;
        for (int x = i; x <= a; x++) {
            int j2 = 0;

            for (int y = j; y <= b; y++) {
                M2.setElem(i2, j2, elem[x][y]);
                j2++;
            }

            i2++;
        }
        return M2;
    }
    
}

