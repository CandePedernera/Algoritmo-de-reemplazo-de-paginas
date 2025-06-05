package org.example;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Secuencia de peticiones de páginas (referencias)
        int[] paginas = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        int tamMemoria = 3; // Número de marcos en memoria

        Queue<Integer> memory = new LinkedList<>();
        Set<Integer> memorySet = new HashSet<>();
        int fallos = 0;
        for (int page : paginas) {
            // Si la página no está en memoria
            if (!memorySet.contains(page)) {
                fallos++;
                // Si la memoria está llena, quitar la más antigua (FIFO)
                if (memory.size() == tamMemoria) {
                    int removed = memory.poll();
                    memorySet.remove(removed);
                }
                // Agregar nueva página
                memory.add(page);
                memorySet.add(page);
            }
            // Mostrar estado actual de los marcos
            System.out.println("Página: " + page + " -> Memoria: " + memory);
        }
        System.out.println("\nTotal de fallos de página: " + fallos);
        }
    }
