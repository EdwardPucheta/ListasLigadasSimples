package listasimple;

public class ListaSimple {
    Nodo top;

    // Métodos para los casos de inserción de nodos
    public boolean insertaPrimerNodo(String dato) {
        if (top == null) { // La lista está vacía
            top = new Nodo();
            top.name = dato;
            top.next = null;
            return true;
        } else {
            return false;
        }
    }

    public void insertaAntesPrimerNodo(String nombre) {
        Nodo temp;
        temp = new Nodo();
        temp.name = nombre;
        temp.next = this.top;
        this.top = temp;
        temp = null;
    }

    public void insertaAlFinal(String nombre) {
        Nodo temp = new Nodo();
        temp.name = nombre;
        temp.next = null;
        Nodo temp2 = this.top;

        while (temp2.next != null)
            temp2 = temp2.next;

        temp2.next = temp;
        temp = null;
    }

//    public boolean insertaEntreNodos(String nombre, String buscado) {
//        Nodo temp = new Nodo();
//        temp.name = nombre;
//        Nodo temp2 = this.top;
//
//        while ((temp2 != null) && !temp2.name.equals(buscado)) {
//            temp2 = temp2.next;
//        }
//
//        if (temp2 != null) { // Nodo buscado se encontró
//            temp.next = temp2.next;
//            temp2.next = temp;
//            temp = null;
//            return true;
//        } else {
//            return false;
//        }
//    }

    public void imprimir() {
         System.out.println("Contenido: ");
        for (Nodo temp = this.top; temp != null; temp = temp.next) {             
             System.out.print("[ " + temp.name + " ] -> ");
        }         
        System.out.print("[...]\n");
    }

//    public String String() {
//        StringBuilder cadAux = new StringBuilder();
//        for (Nodo temp = this.top; temp != null; temp = temp.next) {
//            cadAux.append("[ ").append(temp.name).append(" ] -> ");
//        }
//
//        cadAux.append("[X]\n");
//
//        return cadAux.toString();
//    }

    // Métodos de borrado
    public void borrarPrimerNodo() {
        this.top = this.top.next;
    }

    // Borrar cualquier nodo que no sea el primero
    public boolean borrarCualquierNodo(String buscado) {
        Nodo temp = this.top;

        while ((temp != null) && !temp.name.equals(buscado)) {
            temp = temp.next;
        }

        if (temp != null) { // Nodo buscado se encontró
            temp.next = temp.next.next;
            temp = null;
            return true;
        } else {
            return false;
        }
    }
    /////////////////////////////////////////////////////////////////7
     // Métodos de búsqueda
    public Nodo buscarPorPosicion(int posicion) {
        int contador = 0;
        Nodo temp = this.top;

        while (temp != null) {
            if (contador == posicion) {
                return temp;
            }

            temp = temp.next;
            contador++;
        }

        return null; // Si la posición no existe en la lista
    }

    // Método para imprimir la lista indicando las posiciones
    public void imprimirConPosiciones() {
        Nodo temp = this.top;
        int posicion = 0;

        while (temp != null) {
            System.out.print("[ Posición " + posicion + ": " + temp.name + " ] -> ");
            temp = temp.next;
            posicion++;
        }

        System.out.print("[?]\n");
    }
    
    public boolean insertaAntesUltimoNodo(String nombre) {
        Nodo temp = new Nodo();
        temp.name = nombre;
        temp.next = null;

        // Caso especial: si la lista está vacía, inserta al principio
        if (top == null) {
            top = temp;
            return true;
        }

        // Caso general: recorre la lista hasta el penúltimo nodo
        Nodo temp2 = this.top;
        while (temp2.next != null && temp2.next.next != null) {
            temp2 = temp2.next;
        }

        // Inserta el nuevo nodo antes del último
        temp.next = temp2.next;
        temp2.next = temp;
        return true;
    }
    
    // Método para intercambiar un nodo por otro buscado
    public void intercambiarNodo(String nodoBuscado, String nuevoDato) {
        Nodo temp = this.top;

        while (temp != null && !temp.name.equals(nodoBuscado)) {
            temp = temp.next;
        }

        if (temp != null) {
            temp.name = nuevoDato;
            System.out.println("Nodo intercambiado exitosamente.");
        } else {
            System.out.println("Nodo no encontrado. No se realizó el intercambio.");
        }
    }
}
