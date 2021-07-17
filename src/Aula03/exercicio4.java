package Aula03;

import java.util.Scanner;

public class exercicio4 {

    public static void main(String[] args) {


    // 4. Construa um algoritmo que leia 10 valores inteiros e positivos e:

    // Encontre o maior valor
    // Encontre o menor valor
    // Calcule a média dos números lidos

    // Código do @Bruno Souza

    Scanner in = new Scanner(System.in);
        System.out.println("Digite o primeiro numero:");
    int numero = in.nextInt();

    int menorValor = numero;
    int maiorValor = numero;
    int somaDosValores = 0;

    // somaDosValores = somaDosValores + numero;
    somaDosValores += numero;
    // Tem o mesmo significado, faz a mesma coisa


        System.out.println("Digite o segundo numero:");
    numero = in.nextInt();
    somaDosValores += numero;

        if (numero > maiorValor) {
        maiorValor = numero;
    }

        if (numero < menorValor) {
        menorValor = numero;
    }

        System.out.println("Digite o terceiro numero:");
    numero = in.nextInt();
    somaDosValores += numero;

        if (numero > maiorValor) {
        maiorValor = numero;
    }

        if (numero < menorValor) {
        menorValor = numero;
    }

        System.out.println("Digite o quarto numero:");
    numero = in.nextInt();
    somaDosValores += numero;

        if (numero > maiorValor) {
        maiorValor = numero;
    }

        if (numero < menorValor) {
        menorValor = numero;

    }
        System.out.println("Digite o quinto numero:");
    numero = in.nextInt();
    somaDosValores += numero;

        if (numero > maiorValor) {
        maiorValor = numero;
    }

        if (numero < menorValor) {
        menorValor = numero;
    }

        System.out.println("Digite o sexto numero:");
    numero = in.nextInt();
    somaDosValores += numero;

        if (numero > maiorValor) {
        maiorValor = numero;
    }

        if (numero < menorValor) {
        menorValor = numero;
    }

        System.out.println("Digite o setimo numero:");
    numero = in.nextInt();
    somaDosValores += numero;

        if (numero > maiorValor) {
        maiorValor = numero;
    }

        if (numero < menorValor) {
        menorValor = numero;
    }

        System.out.println("Digite o oitavo numero:");
    numero = in.nextInt();
    somaDosValores += numero;

        if (numero > maiorValor) {
        maiorValor = numero;
    }

        if (numero < menorValor) {
        menorValor = numero;
    }

        System.out.println("Digite o nono numero:");
    numero = in.nextInt();
    somaDosValores += numero;

        if (numero > maiorValor) {
        maiorValor = numero;
    }

        if (numero < menorValor) {
        menorValor = numero;
    }

        System.out.println("Digite o decimo numero:");
    numero = in.nextInt();
    somaDosValores += numero;

        if (numero > maiorValor) {
        maiorValor = numero;
    }

        if (numero < menorValor) {
        menorValor = numero;
    }

        System.out.println("O maior valor digitado foi: " + maiorValor);
        System.out.println("O menor valor digitado foi: " + menorValor);
        System.out.println("A média dos valores é:" + somaDosValores / 10.0);

        in.close();
}
}
