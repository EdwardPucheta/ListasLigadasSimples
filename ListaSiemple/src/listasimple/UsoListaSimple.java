package listasimple;
import java.util.Scanner;

public class UsoListaSimple {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();

        lista.insertaPrimerNodo("H");
        lista.insertaAntesPrimerNodo("O");
        lista.insertaAlFinal("Y");
       // lista.insertaEntreNodos("R", "A");
       System.out.println("Contenido al principio:");
       lista.imprimir();
       //System.out.print(lista);

        // Instanciar y ejecutar el menú
        MenuExample menu = new MenuExample(lista);
        menu.ejecutarMenu();
    }
}

class MenuExample {
    Scanner scanner = new Scanner(System.in);
    char opcion;
    ListaSimple lista;

    // Constructor que recibe la referencia de la lista
    public MenuExample(ListaSimple lista) {
        this.lista = lista;
    }

    public void ejecutarMenu() {
        do {
            System.out.println("---------------------------------------------------------");
            System.out.println("a. Buscar un nodo por su posición.");
            System.out.println("b. Insertar un nuevo nodo antes del último");
            System.out.println("c. Intercambiar un nodo por otro buscado");
            System.out.println("d. Salir");
            System.out.println("Seleccione una opción:");
            
            try {
                opcion = scanner.next().charAt(0);
            } catch (Exception e) {
                System.out.println("Error al leer la opción. Intente de nuevo.");
                scanner.nextLine(); // Limpiar el buffer del scanner
                continue; // Volver al inicio del bucle
            }
            
            
            switch (opcion) {
                case 'a':
                    System.out.println("---------------------------------------------------------");
                    lista.imprimirConPosiciones();

                    int posicionBuscada = 2; // Cambiar la posición 
                    Nodo nodoEncontrado = lista.buscarPorPosicion(posicionBuscada);

                    if (nodoEncontrado != null) {
                        System.out.println("Nodo encontrado en la posición " + posicionBuscada + ": " + nodoEncontrado.name);
                    } else {
                        System.out.println("No se encontró ningún nodo en la posición " + posicionBuscada);
                    }
                    break;
                    
                    
                case 'b':
                    
                    System.out.println("Ingrese el valor para el nuevo nodo (New)");                   
                    lista.insertaAntesUltimoNodo("New");
                    lista.imprimir();
                    
                    break;
                    
                    
                case 'c':
                    System.out.println("-Utilice el contenido del nodo que desea intercambiar-");
                    System.out.print("Ingrese el nodo que desea intercambiar: ");
                    String nodoBuscado = scanner.next();

                    System.out.print("Ingrese el nuevo valor para el nodo: ");
                    String nuevoDato = scanner.next();

                    lista.intercambiarNodo(nodoBuscado, nuevoDato);

                    System.out.println("Lista después del intercambio:");
                    lista.imprimir();

                   //scanner.close();
                    break;
                    
                    
                case 'd':
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }

        } while (opcion != 'd');

        scanner.close();
    }
}

