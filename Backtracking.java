

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author Titrit
 */
public class Main {


    static String direction = "DLRU";
    private static int min;
    static Point[] posicions = {new Point(1, 0), new Point(0, -1), new Point(0, 1), new Point(-1, 0)};

    private static boolean isValid(Point point, int n, int[][] visited) {
        return point.x >= 0 && point.y >= 0 && point.x < n && point.y < n && visited[point.x][point.y] == 0;
    }

    private boolean kDivideSum(int[] array, int k) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        int result = sum / k;
        double r = (double) sum / k;
        return r - (double) result == 0;

    }

    /*
    Primero resolvemos parar k=2
     */
    public static boolean Partition(int[] array, int N, int t[], int k) {
        //una possiblitat --> int [] t se li assignará valors 0--k i per la suma s'anira sumant perls k conjunts
        int n = array.length;
      /* ++ if (k>n || !kDivideSum(array,k)){//no se puede dividir un conjunto en m>array.length elementos. tampoco si
            //k no divide la suma total del conjunto de elementos
            return false;

        }else if (k ==1){//sol = set
            return true;
        }else{//we use backtracking*/
        t[k] = -1;
        while (t[k] < 1) {
            t[k]++; //visitar nodo actual
            if (Sum(t, k, array) == 0 && k == n - 1) {//sumas iguales
                //imprimir la solucion
                PrintSolucion(t, array);
                return true;
            } else if (Sum(t, k, array)<0 && k < n - 1) {//possible solucio
               return Partition(array, N, t, k + 1);
            }

        }
        t[k]=-1;
        return false; //no solution found

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

    private static int Sum(int [] t, int k, int []array){
        //t = {1..k};
        int sum1 =0,sum2=0;
        for (int i = 0; i<=k; i++){
            if (t[i]==1){
                sum1+=array[i];//elemento incluido en la solucion
            }else{
                sum2+=array[i];//no
            }
        }
        return sum1-sum2;
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
            if (i < 4) {
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

        int[] array = {1, 2, 3, 6};
        int[] t = new int[array.length];
        Arrays.fill(t, -1);
        System.out.println(Partition(array,2,t,0));

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
