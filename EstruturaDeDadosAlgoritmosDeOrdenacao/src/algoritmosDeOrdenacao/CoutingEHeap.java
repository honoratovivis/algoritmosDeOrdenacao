package algoritmosDeOrdenacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CoutingEHeap {

			public static void main (String[] args) {
				int[] v = gerarVetor(10);
				int n = v.length;
				
				System.out.println("HeapSort Desordenado: " + Arrays.toString(v));
		        System.out.println("\n");
		        for (int i = n / 2 - 1; i >= 0; i--) {
				heapSort(v, n, i);
		        }
			
		        for(int j = n - 1; j > 0; j--) {
		        	int aux = v[0];
		        	v[0] = v[j];
		        	v[j] = aux;
				
		        	heapSort(v, j, 0);
		        }
		        heapSort(v, 0, v.length-1);
		        System.out.println("HeapSort Ordenado: " + Arrays.toString(v));
		        
		        System.out.println("\n________________________________________________________________");
		        int []vetor = gerarVetor(10);
		        System.out.println("CoutingSort Desordenado: " + Arrays.toString(vetor));	        
		        
		      /*  coutingSort(vetor);
				System.out.println("\n");
				System.out.println("CoutingSort Ordenado: " + Arrays.toString(vetor));*/
		    }
		
			//método heapSort
			private static void heapSort(int[] v, int n, int i) {
				int raiz = i;
				int esquerda = 2*i + 1;
				int direita = 2*i + 2;
				
				if (esquerda < n && v[esquerda] > v[raiz]) {
					raiz = esquerda;
			}
				if (direita < n && v[direita] > v[raiz]) {
					raiz = direita;
				}
				if (raiz !=i) {
					int aux = v[i];
					v[i] = v[raiz];
					v[raiz] = aux;
					
				heapSort(v, n, raiz);
				}
		}
			
		//utilizados no método coutingSort
			private static int getIndiceDoMaiorElemento (int[] vetor, int inicio, int fim) {
		         int indice = -1;
		         int maximo = Integer.MIN_VALUE;
		         for (int i = inicio; i < fim; ++i) {
		             if (vetor[i] > maximo) { 
		                 maximo = vetor[i]; indice = i;
		             }
		         }
		         return indice;
		     }
		     private static int getIndiceDoMenorElemento (int[] vetor, int inicio, int fim) {
		         int indice = -1;
		         int minimo = Integer.MAX_VALUE;
		         for (int i = inicio; i < fim; ++i) {
		             if (vetor[i] < minimo) { 
		                 minimo = vetor[i]; indice = i;
		             }
		         }
		         return indice;
		     }
		     
			//método coutingSort
		     public static void coutingSort(int[] vetor){  
		         int menor = vetor[getIndiceDoMenorElemento(vetor, 0, vetor.length)];  
		         int maior = vetor[getIndiceDoMaiorElemento(vetor, 0, vetor.length)];  
		         int[] aux = new int[maior - menor +1];  
		           
		         for(int x=0;x<vetor.length;x++){  
		             aux[vetor[x] -1]++;  
		         }  
		           
		         for(int x=1;x<aux.length;x++){  
		             aux[x] += aux[x -1];  
		         }  
		                   
		         int[] resposta = new int[vetor.length];
		         for(int x=0;x<vetor.length;x++){  
		             resposta[aux[vetor[x]-1]-1]=vetor[x];  
		             aux[vetor[x] -1]-=1;
		         }  
		         System.arraycopy (resposta, 0, vetor, 0, vetor.length);  
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