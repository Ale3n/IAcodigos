/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examplesia;

import java.util.LinkedList;

/**
 *
 * @author Tower
 */
public class Examplesia {

    /**
     * @param args the command line arguments
     */
    public static int mejor = 0;//mochila 4
    public static LinkedList<LinkedList<Integer>> soluciones = new LinkedList<>();//mochila 4
    
    
    public static int mejorSuma = 0;//mochula 5
    public static LinkedList<LinkedList<Integer>> soluciones2 = new LinkedList<>();//mochila 5
    
    public static int c = 0;
    public static int suma(LinkedList<Integer> L) {
        int total = 0;
        for (Integer num : L) {
            total += num;
        }
        return total;
    }
    public static void sumandos(LinkedList<Integer> L1,int n, int i){
        int sum = suma(L1);
        if(sum > n) return;
        if (sum == n) {
            System.out.println(L1);
            return;
        }
        int k = i;
        while (k<=n) {
            L1.add(k);
            sumandos(L1,n,k);
            L1.removeLast();
            k = k +1;
        }
    }
    
    
    
    public static void sumandos(LinkedList<Integer> L, int n){

        int s = suma(L);
        if(s > n) return;
        if(s == n){
            System.out.println(L);
            return;
        }

        int k = 1;

        while(k <= n){
            L.add(k);              
            sumandos(L, n);         
            L.removeLast();         
            k = k + 1;
        }
    }
    ///////////////////////////////////////////////////////////////////////////
    public static void sumandosIguales(LinkedList<Integer> L, int n, int k){
        int s = suma(L);
        if(s > n) return;
        if(s == n){
            System.out.println(L);
            return;
        }

        int i = k;
        while(i <= k){  
            L.add(i);                    
            sumandosIguales(L, n, k);     
            L.removeLast();              
            i++;
        }
    }
     public static void iniciar(int n){

        int k = 1;

        while(k <= n){

            LinkedList<Integer> L = new LinkedList<>();

            sumandosIguales(L, n, k);  // inicia recursión con un valor fijo

            k++;
        }
    }
     ///////////////////////////////////////////////////////////////////////////

    public static boolean esPrimo(int num){
        if(num < 2) return false;
        int i = 2;
        while(i <= Math.sqrt(num)){
            if(num % i == 0) return false;
            i++;
        }
        return true;
    }

    public static void sumandosPrimos(LinkedList<Integer> L, int n){
        int s = suma(L);
        if(s > n) return;
        if(s == n){
            System.out.println(L);
            return;
        }
        int k = 2;
        while(k <= n){
            if(esPrimo(k)){   
                L.add(k);                    
                sumandosPrimos(L, n);        
                L.removeLast();           
            }
            k++;
        }
    }
    
    public static void sumandosRango(LinkedList<Integer> L, int n, int a, int b){
        int s = suma(L);
        if(s > n) return;
        if(s == n){
            System.out.println(L);
            return;
        }

        int k = a;
        while(k <= b){
            L.add(k);                         
            sumandosRango(L, n, a, b);        
            L.removeLast();                   
            k++;
        }
    }
    
    //Encontrar los factores posibles en una Lista
    public static void factores(LinkedList<Integer> L, int n, int k){
        if(k > n){
            System.out.println(L);
            return;
        }
        if(n % k == 0){
            L.add(k);
        }
        int i = k;
        while(i == k){  
            factores(L, n, k + 1);   
            i++;
        }
        if(n % k == 0){
            L.removeLast();
        }
    }
    
    // Encontrar todos los factores posibles diferentes en una Lista
    public static void factores2(LinkedList<Integer> L, int n, int i){
        if(n == 1){
            System.out.println(L);
            return;
        }
        int k = i;
        while(k <= n){
            if(n % k == 0){   // si k es factor
                L.add(k);   
                factores(L, n / k, k);          
                L.removeLast();                  
            }
            k++;
        }
    }
    //Encontrar todos los factores posibles iguales en una Lista. 
    public static void factoresIguales(LinkedList<Integer> L, int n, int k){
        if(n == 1){
            System.out.println(L);
            return;
        }
        int i = k;
        while(i == k){   
            if(n % k == 0){
                L.add(k);                      
                factoresIguales(L, n / k, k);  
                L.removeLast();                
            }
            i++;
        }
    }

    public static void iniciar2(int n){
        int k = 2;
        while(k <= n){
            LinkedList<Integer> L = new LinkedList<>();
            factoresIguales(L, n, k);
            k++;
        }
    }
    
    //4. Encontrar todos los factores primos posibles en una Lista.
    public static void factoresPrimos(LinkedList<Integer> L, int n, int i){
        if(n == 1){
            System.out.println(L);
            return;
        }
        int k = i;
        while(k <= n){
            if(n % k == 0 && esPrimo(k)){  
                L.add(k);                         
                factoresPrimos(L, n / k, k);      
                L.removeLast();                  
            }
            k++;
        }
    }
    //5. Encontrar todos los factores entre a y b inclusive en una Lista.
     public static void factoresRango(LinkedList<Integer> L, int n, int k, int b){
        if(k > b){
            System.out.println(L);
            return;
        }
        if(n % k == 0){
            L.add(k);
        }
        int i = k;
        while(i == k){  
            factoresRango(L, n, k + 1, b);  
            i++;
        }
        if(n % k == 0){
            L.removeLast();
        }
    }
     //Encontrar todas las combinaciones de pesos de objetos que se pueden transportar en la mochila.
    public static void mochila(LinkedList<Integer> L1,LinkedList<Integer> L2, int max, int i){
        int sum = suma(L2);
        if(sum > max) return;
        System.out.println(L2); c++;
        int k = i;
        while (k<L1.size()) {
            L2.add(L1.get(k));
            mochila(L1,L2,max,k+1);
            L2.removeLast();
            k = k+1;
        }
    }
    //2. Encontrar todas las combinaciones de pesos diferentes que se pueden transportar en la mochila.
    public static void mochilaDiferentes(LinkedList<Integer> L1, LinkedList<Integer> L2, int max, int i){
        int s = suma(L2);
        if(s > max) return;
        System.out.println(L2);
        int k = i;
        while(k < L1.size()){
            L2.add(L1.get(k));                
            mochilaDiferentes(L1, L2, max, k + 1);
            L2.removeLast();                 
            k++;
        }
    }
    
    //3. Encontrar todas las combinaciones de pesos entre a y b inclusive que se pueden transportar en la mochila.
    public static void mochilaRango(LinkedList<Integer> L1, LinkedList<Integer> L2, int a, int b, int i){
        int s = suma(L2);
        if(s > b) return;
        if(s >= a && s <= b){
            System.out.println(L2);
        }
        int k = i;
        while(k < L1.size()){
            L2.add(L1.get(k));               
            mochilaRango(L1, L2, a, b, k + 1); 
            L2.removeLast();            
            k++;
        }
    }
    //Encontrar las combinaciones de objetos de mayor cantidad de objetos que se pueden transportar
    public static void mochila2(LinkedList<Integer> L1, LinkedList<Integer> L2, int max, int i){
        int s = suma(L2);
        if(s > max) return;
        if(L2.size() >= mejor){
            if(L2.size() > mejor){
                mejor = L2.size();
                soluciones.clear();
            }
            soluciones.add(new LinkedList<>(L2));
        }

        int k = i;
        while(k < L1.size()){
            L2.add(L1.get(k));                 
            mochila(L1, L2, max, k + 1);     
            L2.removeLast();                   
            k++;
        }
    }
    // Encontrar las mejores combinaciones que se pueden transportar en la mochila. (Las más próximas a la capacidad de la mochila)

    public static void mochila3(LinkedList<Integer> L1, LinkedList<Integer> L2, int max, int i){
        int s = suma(L2);
        if(s > max) return;
        if(s >= mejorSuma){
            if(s > mejorSuma){
                mejorSuma = s;
                soluciones2.clear();
            }
            soluciones2.add(new LinkedList<>(L2));
        }
        int k = i;
        while(k < L1.size()){
            L2.add(L1.get(k));              
            mochila(L1, L2, max, k + 1);     
            L2.removeLast();              
            k++;
        }
    }

    public static void main(String[] args) {
         // TODO code application logic here
        /*int n = 4;
        LinkedList<Integer> L1 = new LinkedList();
        sumandos(L1,n,1);*/
        /*LinkedList<Integer> L1 = new LinkedList();
        LinkedList<Integer> L2 = new LinkedList();
        int max = 9;
        L1.add(1);
        L1.add(3);
        L1.add(5);
        L1.add(7);
        mochila(L1,L2,max,0);
        System.out.println("Sol = " + c);*/
        //LinkedList<Integer> L = new LinkedList<>();
        //sumandosPrimos(L, 7);
        //LinkedList<Integer> L = new LinkedList<>();
        //sumandosRango(L, 5, 2, 4);
        //LinkedList<Integer> L = new LinkedList<>();
        //factores(L, 10, 1);
        //LinkedList<Integer> L = new LinkedList<>();
        //factores2(L, 12, 2);
        /*LinkedList<Integer> L1 = new LinkedList<>();
        L1.add(2);
        L1.add(3);
        L1.add(4);
        L1.add(5);
        LinkedList<Integer> L2 = new LinkedList<>();
        int a = 3;
        int b = 6;
        mochilaRango(L1, L2, a, b, 0);*/
        
        
    }
    
}
