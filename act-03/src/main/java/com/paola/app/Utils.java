package com.paola.app;

import java.lang.reflect.Array;

public class Utils {
  public static <T> T ordenar(T vector) {
    quicksort(vector, 0, Array.getLength(vector) - 1);
    return vector;
  }

  private static <T> void quicksort(T vector, int low, int high) {
    if(low < high) {
      int pivot = particion(vector, low, high);
      quicksort(vector, low, pivot - 1);
      quicksort(vector, pivot + 1, high);
    }
  }

  private static <T> int particion(T vector, int low, int high) {
    double pivot = Array.getDouble(vector, high);
    int i = low - 1;

    for(int j = low; j < high; j++) {
      if(Array.getDouble(vector, j) <= pivot) {
        i++;

        if(i != j) {
          swap(vector, i, j); 
        }
      }
    }

    swap(vector, i + 1, high);

    return i + 1;
  }

  private static <T> void swap(T vector, int i, int j) {
    Object temp = Array.get(vector, i);
    Array.set(vector, i, Array.get(vector, j));
    Array.set(vector, j, temp);
  }

  public static <T> void imprimir(T vector) {
    for(int i = 0; i < Array.getLength(vector); i++) {
      System.out.print("[" + Array.get(vector, i) + "] ");
    }

    System.out.println();
  }
}
