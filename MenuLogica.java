import java.util.Scanner;

public class MenuLogica {

    public static void main(String[] args) {
        Scanner ljco = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--------------BIENVENIDO AL MENU---------------");
            System.out.println("1. Llenar matriz con secuencia sobre la diagonal secundaria.");
            System.out.println("2. Imprimir los primeros números primos de un numero.");
            System.out.println("3. Método de Eratóstenes para hallar números primos menores a N.");
            System.out.println("4. Salir.");
            System.out.print("Seleccione una opción: ");
            opcion = ljco.nextInt();

            switch (opcion) {
                case 1:
                    llenarMatriz();
                    break;
                case 2:
                    imprimirNumerosPrimos();
                    break;
                case 3:
                    metodoEratostenes();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);

        ljco.close();
    }

    // Opción 1: Llenar matriz con secuencia sobre la diagonal secundaria
    public static void llenarMatriz() {
        Scanner ljco= new Scanner(System.in);
        System.out.print("Ingrese el tamaño de la matriz (N): ");
        int n = ljco.nextInt();
        System.out.print("Ingrese el valor inicial (X): ");
        int x = ljco.nextInt();

        int[][] matriz = new int[n][n];
        int valor = x;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= n - i - 1) {
                    matriz[i][j] = valor++;
                }
            }
        }

        System.out.println("Matriz resultante:");
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    }

    // Opción 2: Imprimir los primeros N números primos
    public static void imprimirNumerosPrimos() {
        Scanner ljco = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de números primos a imprimir (N): ");
        int n = ljco.nextInt();

        int contador = 0;
        int numero = 2;

        System.out.println("Los primeros " + n + " números primos son:");
        while (contador < n) {
            if (esPrimo(numero)) {
                System.out.print(numero + " ");
                contador++;
            }
            numero++;
        }
        System.out.println();
    }

    public static boolean esPrimo(int numero) {
        if (numero < 2) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    // Opción 3: Método de Eratóstenes
    public static void metodoEratostenes() {
        Scanner ljco = new Scanner(System.in);
        System.out.print("Ingrese el número N (mayor que 2): ");
        int n = ljco.nextInt();

        boolean[] esPrimo = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            esPrimo[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= n; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

        System.out.println("Números primos menores o iguales a " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (esPrimo[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}