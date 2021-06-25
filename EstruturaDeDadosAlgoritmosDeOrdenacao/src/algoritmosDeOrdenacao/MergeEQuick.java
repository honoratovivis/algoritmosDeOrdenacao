package algoritmosDeOrdenacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeEQuick {
		
		public static void main (String[] args) {
			
		        int[] v = gerarVetor(10);
		        int []w = new int[v.length];
		        System.out.println("MergeSort Desordenado: " + Arrays.toString(v));
		        System.out.println("\n");
		        
				mergeSort(v, w, 0, v.length-1);
				System.out.println("MergeSort Ordenado: " + Arrays.toString(v));
				
		        System.out.println("\n________________________________________________________________");
		        int []vetor = gerarVetor(10);
		        System.out.println("QuickSort Desordenado: " + Arrays.toString(vetor));
		        
				quickSort(vetor, 0, vetor.length-1);
				System.out.println("\n");
				System.out.println("QuickSort Ordenado: " + Arrays.toString(vetor));
		    }
		
		//método mergeSort
		private static void mergeSort(int[] v, int[] w, int ini, int fim) {
			if(ini < fim) {
				int meio = (ini + fim) / 2;
				mergeSort(v, w, ini, meio);
				mergeSort(v, w, meio+1, fim);
				intercalar(v, w, ini, meio, fim);
			}
		}
		
		//utilizado no método mergeSort
		private static void intercalar(int[] v, int[] w, int ini, int meio, int fim) {
			for(int k = ini; k <= fim; k++)
			w[k] = v[k];
			
			int i = ini;
			int j = meio + 1;
			
			for(int k = ini; k <= fim; k++) {
				if(i > meio) v[k] = w[j++];
				else if (j > fim) v[k] = w[i++];
				else if (w[i] < w[j]) v[k] = w[i++];
				else v[k] = w[j++];
			}
		}
		
		//método quickSort
		private static void quickSort(int[] v, int esq, int dir) {
			if(esq < dir) {
				int j = separar(v, esq, dir);
				quickSort(v, esq, j-1);
				quickSort(v, j+1, dir);
			}
		}
		
		//utilizado no método quickSort
		private static int separar(int[] v, int esq, int dir) {
			int i = esq + 1;
			int j = dir;
			int pivo = v[esq];
			
			while (i <= j) {
				if(v[i] <= pivo) i++;
				else if (v[j] > pivo) j--;
				else if (i <= j) {
					trocar(v, i, j);
					i++;
					j--;
				}
			}
			trocar(v, esq, j);
			return j;
		}
		
		//utilizado no método separar
		private static void trocar(int[] v, int i, int j) {
			int aux = v[i];
			v[i] = v[j];
			v[j] = aux;
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