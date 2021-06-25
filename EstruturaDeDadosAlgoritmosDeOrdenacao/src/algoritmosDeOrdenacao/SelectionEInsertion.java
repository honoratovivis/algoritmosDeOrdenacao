package algoritmosDeOrdenacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SelectionEInsertion {

	public static void main (String[] args) {
        int[] v = gerarVetor(10);
     
        System.out.println("InsertionSort Desordenado: " + Arrays.toString(v));
        System.out.println("\n");
        insertionSort(v);
        System.out.println("InsertionSort Ordenado: " + Arrays.toString(v));
		
        System.out.println("\n________________________________________________________________");
        int []vetor = gerarVetor(10);
        System.out.println("SelectionSort Desordenado: " + Arrays.toString(vetor));
        
        selectionSort(vetor);
		System.out.println("\n");
		System.out.println("SelectionSort Ordenado: " + Arrays.toString(vetor));
    }
    
	private static void insertionSort(int[] v) {
		int x, j;
		for(int i = 1; i < v.length; i++) {
			x = v[i]; // x está na posição 1
			j = i - 1; //j está na posição 0
			while((j >= 0) && v[j] > x) {
				v[j + 1] = v[j];
				j = j - 1;
			}
			v[j + 1] = x;
		}
	}
	
	private static void selectionSort(int[] v) {
		for (int i=0; i< v.length; i++) {
			int menor = i;
			for(int j = i + 1; j < v.length; j++) {
				if(v[j] < v[menor])
					menor = j;
			}
			trocar(v, i, menor);
		}
	}
	
	//utilizado no método selectionSort
		private static void trocar(int[] v, int i, int menor) {
			int aux = v[i];
			v[i] = v[menor];
			v[menor] = aux;
		}

		private static int[] gerarVetor(int n) {
			int []v = new int[n];
			Random gerador = new Random();
			for(int i = 0; i < n; i++) {
				v[i] = gerador.nextInt(100);
			}
			return v;
		}
}