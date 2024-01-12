

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author Titrit
 */
public class Backtracking {


    static String direction = "DLRU";
    private static int min;
    static Point[] posicions = {new Point(1, 0), new Point(0, -1), new Point(0, 1), new Point(-1, 0)};


    static Point[] poscaballo =  {new Point(-2, 1), new Point(-2, -1), new Point(-1, 2), new Point(-1, -2), new Point(1,2),new Point(1,-2),new Point(2,1),new Point(2,-1)};
    private static boolean isValid(Point point, int n, int[][] visited) {
        return point.x >= 0 && point.y >= 0 && point.x < n && point.y < n && visited[point.x][point.y] == 0;
    }


    private static boolean isValidCaball(Point point, int n, int[][] visited) {
        return point.x >= 0 && point.y >= 0 && point.x < n && point.y < n && visited[point.x][point.y] == -1;
    }

    public static boolean Allvisited(int [][] visited){
        for (int i = 0; i<8; i++){
            for (int j = 0; j<8; j++){
                if (visited[i][j]==-1) {
                return false;}
            }
        }
        return true;
    }

    static void printSol(int sol[][])
    {
        for (int x = 0; x < sol.length; x++) {
            for (int y = 0; y < sol.length; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }
    private static boolean solutionFound = false;

    private static boolean caballMoviment(Point current,  int[][] matriz, int[][] visited, int moveNumber) {

       if (Allvisited(visited) ) {
           System.out.println("the problem has a solution");
           printSol(visited);
       //    solutionFound = true;  // Marcamos que ya se encontró una solución

           return true;
       }
           int i = 0;
           Point nextPoint = new Point(0, 0);
           while (i < poscaballo.length) {
               int nextX = current.x + poscaballo[i].x;
               int nextY = current.y + poscaballo[i].y;
               nextPoint.setLocation(nextX, nextY);

               if (isValidCaball(nextPoint, matriz.length, visited)) {
                   visited[nextPoint.x][nextPoint.y] = moveNumber;
                  if (caballMoviment(nextPoint, matriz, visited, moveNumber + 1)) {
                      return true;
                  }
                   visited[nextPoint.x][nextPoint.y] = -1;

               }

               i++;
           }
           return false;


    }

    private static boolean kDivideSum(int[] array, int k) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return sum % k == 0;
    }

    public static boolean Partition(int[] array, int N, int[] t, int k) {
        int n = array.length;
        if (N > n || !kDivideSum(array, N)) {
            return false;
        } else if (N == 1) {
            return true;
        } else {
            t[k] = -1;
            while (t[k] < N - 1) {
                t[k]++;
                if (Sum(t, k, array, N) == 0 && k == n - 1) {
                    return true;
                } else if (Sum(t, k, array, N) > 0 && k < n - 1) {
                    return Partition(array, N, t, k + 1);
                      
                }
            }
        }
        t[k] = -1;
        return false;
    }

    private static int Sum(int[] t, int k, int[] array, int N) {
        int[] sumas = new int[N];
        int total = 0;
        for (int i = 0; i <= k; i++) {
            sumas[t[i]] += array[i];
        }
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        int limit = total / N;

        int iguales = 0;
        for (int i : sumas) {
            if (i > limit) {
                return -1;
            } else if (i == limit) {
                iguales++;
            }
        }

        if (iguales == sumas.length) {
            return 0;
        } else {
            return 1;
        }
    }



    private static void PrintSolucion(int [] t, int [] array){
        int length = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i]==1){
                length++;

        }

        }
        int [] set1 = new int[length];
        int [] set2 = new int [array.length-length];
        int index1=0, index2=0;
        for (int i = 0; i<t.length; i++){
            if (t[i]==1){
                set1[index1]=array[i];
                index1++;
            }else{
                set2[index2]=array[i];
                index2++;
            }
        }
        System.out.println("the subests for "+ Arrays.toString(array));
        System.out.println(Arrays.toString(set1));
        System.out.println(Arrays.toString(set2));



    }


    private static void findPath(Point start, Point end, int n, List<String> ans, StringBuilder currentPath, int[][] matriz, int sum, int[][] visited) {


        if (start.equals(end)) {
            if (sum <= min) {
                min = sum;
                ans.clear();
                ans.add(currentPath.toString());

                return;
            }
        }
        visited[start.x][start.y] = 1;
        int i = 0;
        Point nextPoint = new Point(0, 0);
        while (i < posicions.length) {
            int nextX = start.x + posicions[i].x;
            int nextY = start.y + posicions[i].y;
            nextPoint.setLocation(nextX, nextY);

            if (isValid(nextPoint, n, visited)) {
                currentPath.append(direction.charAt(i));
                sum += matriz[nextX][nextY];
                findPath(new Point(nextX, nextY), end, n, ans, currentPath, matriz, sum, visited);
                currentPath.deleteCharAt(currentPath.length() - 1);
                sum -= matriz[nextX][nextY];
            }

            i++;
        }

        visited[start.x][start.y] = 0;
    }


    private static void findPathIterative(Point start, Point end, int n, List<String> ans, StringBuilder currentPath, int[][] matriz, int sum, int[][] visited) {

        int k = 0, i = 0, nextY = 0, nextX = 0;

        while (k >= 0) {
            if (start.equals(end)) {
                if (sum <= min) {
                    min = sum;
                    ans.clear();
                    ans.add(currentPath.toString());

                    return;
                }
            }
            if (i < posicions.length) {
                visited[start.x][start.y] = 1;
                nextX = start.x + posicions[i].x;
                nextY = start.y + posicions[i].y;
                Point nextPoint = new Point(nextX, nextY);

                if (isValid(nextPoint, n, visited)) {
                    currentPath.append(direction.charAt(i));
                    sum += matriz[nextX][nextY];
                    start = nextPoint;
                } else {
                    k++;//seguent nivell}
                }
            } else {//se han rpocesado todos los nodos
                currentPath.deleteCharAt(currentPath.length() - 1);
                sum -= matriz[nextX][nextY];
                visited[start.x][start.y] = 0;
                k--;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int sum = 0;
        min = Integer.MAX_VALUE;
        int[][] matriz = {{1, 2, 3}, {4, 7, 8}, {2, 4, 3}};
        int n = matriz.length;
        int[][] visited = new int[n][n];
        List<String> result = new ArrayList<>();
        StringBuilder currentPath = new StringBuilder();

        findPath(new Point(0, 0), new Point(0, 2), n, result, currentPath, matriz, sum, visited);

        if (result.isEmpty())
            System.out.println(-1);
        else
            result.forEach(path -> System.out.print(path + " "));
        System.out.println();
        min = Integer.MAX_VALUE;


        findPathIterative(new Point(0, 0), new Point(2, 2), n, result, currentPath, matriz, sum, visited);
        if (result.isEmpty())
            System.out.println(-1);
        else
            result.forEach(path -> System.out.print(path + " "));
        System.out.println();


        //Partition problem

        /*
        int[] array = {1, 2, 3, 6};
        int[] t = new int[array.length];
        Arrays.fill(t, -1);
        System.out.println(Partition(array,3,t,0));*/
       // System.out.println(Partition(array,2,t,0));

        //problema del recorregut del caball

        int [][] tablero= new int[8][8];
        int [][] t = new int [8][8];
        //marcar todas como no visitadas
       for (int i =0; i<8; i++){
           for (int j = 0; j<8; j++){
               t[i][j]=-1;
           }
       }
       //punto de partida
        t[0][0]=0;


        System.out.println(caballMoviment(new Point(0,0),tablero, t,1));
        System.out.println( càlcul(10,2));

        int v1[] = {2,3,4,7,9,12};
        int v2[]={2,3,4,7,9,12};
        System.out.println(EqualVectors(v1,v2));
    }


    public static int càlcul(int a, int acumulativo){
        if(a<=1){
            return acumulativo;
        }else{
            a=a/3;
            return càlcul(a, 3*acumulativo);
        }
    }

    /*
    *Ddos dos vectores ordenados de forma creciente determinar si continene los mismos
    valors.Ejercicio 3 del examen de febrer 2016-2017
     */

    public static boolean EqualVectors(int [] v1, int[] v2){
        int n = v1.length-1;
        int mig = 0;
         for (int i =0; i<=n; i++){
             if (v1[i]==v2[i] && v1[n-i]==v2[n-i]){
                 //comprobar que el valor medio tambien lo es
                 mig = (n+i)/2;
                 if (v1[mig]!=v2[mig]){
                     return false;
                 }
             }
         }
         return true;

    }


}

   /* public boolean Exercici1(boolean[] V, String E) {
        int t[] = new int[V.length];
        Arrays.fill(t, -1);
        int nivel = 0;
        boolean solucion[] = new boolean[V.length];
        return auxiliaryEX1(V, E, nivel, t, solucion);
    }*/

  /*  public boolean auxiliaryEX1(boolean[] V, String E, int k, int[] t, boolean[] solucion) {
        t[k] = -1; //nodo actual
        while (t[k] < 1) {//
            if (canBeTrue(V, E, k)) {
                System.arraycopy(solucion, 0, t, 0, t.length);

            }

        }

    }*/


  /*  private boolean canBeTrue(boolean[] V, String E, int k) {
        String parts[] = E.split(" ");
        StringBuilder condicion= new StringBuilder();

        for (int i = 0 ; i<parts.length; i++){
            if (parts[i].equals("and")){
                condicion.append("&&");
            }else if (parts[i].equals("or")){
                condicion.append("||");
            }else{

                    condicion.append(parts[i]);

            }
        }
        //pasamos la condicion en formato string a formato boolean


    }*/
