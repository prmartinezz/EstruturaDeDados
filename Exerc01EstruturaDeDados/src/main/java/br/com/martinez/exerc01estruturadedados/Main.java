package br.com.martinez.exerc01estruturadedados;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*1 Desenvolva um programa que solicite ao
            usuário para informar a quantidade de números
            que irá cadastrar, após solicite para informar os
            mesmos. Nesse aplicativo deverá ter um menu
            para selecionar o tipo de pesquisa que deseja
            fazer, linear ou binária. Para efetuar a pesquisa
            solicite qual número a ser pesquisado, coloque-os
            em ordem crescente e faça a pesquisa seleciona e
            exiba para o usuário o resultado. */
        
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe os números que ira cadastrar: ");
        int quantidade = scanner.nextInt();

        int[] num = new int[quantidade];
            for (int i = 0; i < quantidade; i++) {
                System.out.print("Informe o número " + (i+1) + ": ");
                    num[i] = scanner.nextInt();
        }

        Arrays.sort(num);

        System.out.println("Informe o Tipo de Pesquisa!:");
        System.out.println("1 - Busca Linear");
        System.out.println("2 - Busca Binária");
        System.out.println("0 - Sair");

        int tipoPesquisa = scanner.nextInt();

        System.out.print("Informe o número que deseja pesquisar ");
        int numPesquisa = scanner.nextInt();

        int resultado;
            if (tipoPesquisa == 1) {
                resultado = buscaLinear(num, numPesquisa);
                    } else {
                        resultado = buscaBinaria(num, numPesquisa);         
                       
        }

        if (resultado == -1) {
            System.out.println("Número não encontrado.");
                } else {
                System.out.println("Número encontrado na posição ["+ resultado + "]!" );
                    Arrays.sort(num);
                        System.out.println("Números em ordem crescente: " + Arrays.toString(num));
            }
    }

    public static int buscaLinear(int[] num, int numPesquisa) {
        for (int i = 0; i < num.length; i++) {
            if (num[i] == numPesquisa) {
                return i;
            }
        }
        return -1;
    }

    public static int buscaBinaria(int[] num, int numPesquisa) {
        int esquerda = 0;
        int direita = num.length - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;

            if (num[meio] == numPesquisa) {
                return meio;
            }

            if (num[meio] < numPesquisa) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }
        return -1;
    }
}