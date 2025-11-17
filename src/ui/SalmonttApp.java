package ui;
import data.GestorDeDatos;
import model.CentroCultivo;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SalmonttApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String rutaDeArchivo = "resources/centros.txt";
        ArrayList<CentroCultivo> centros = GestorDeDatos.cargarArchivo(rutaDeArchivo);
        
        System.out.println("Listado total de Centros: \n");
        for (CentroCultivo centro : centros) {
            System.out.println(centro);
        }
        
        System.out.println("* * * * * * * * * * * * * * * * * *\n");
        
        int filtroPorTonelada = 0;
        boolean filtroOK = false;
        
        
        do {
            if (filtroOK = true) {
                System.out.println("Ingrese cantidad para filtrar por toneladas: ");
                try {
                    filtroPorTonelada = sc.nextInt();
                    filtroOK = true;
                } catch (InputMismatchException e) {
                    System.out.println("\nDigito no valido\n");
                    filtroOK = false;
                    sc.nextLine(); 
                }
            }

        } while (filtroOK != true);
        sc.nextLine();
        
        System.out.println("\nCentros con mas de " + filtroPorTonelada +  " toneladas producidas:\n");
        for (CentroCultivo centro : centros) {
            if (centro.getToneladasProducidas() > filtroPorTonelada) {
                System.out.println(centro);
            }
        }
        
        System.out.println("* * * * * * * * * * * * * * * * * *\n");

        boolean finalizar = false;
        do {
        System.out.println("Ingrese nombre del centro a buscar: ");
        String nombre = sc.nextLine().trim();
        
        CentroCultivo encontrado = GestorDeDatos.buscarCentroPorNombre(centros, nombre);         

            if (encontrado != null) {
                System.out.println("\nCentro encontrado: \n" + encontrado);
                finalizar = true;
            } else {
                System.out.println("\nCentro no encontrado\n");

            }
            
        } while (finalizar != true);
        
        System.out.println("\n Buscador cerrado, hasta la proxima! \n");
        
    }
    
}

