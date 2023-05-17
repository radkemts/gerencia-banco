/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco;

/**
 *
 * @author Mateus
 */
import java.util.Scanner;

public class GerenciaBanco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        System.out.println("=== Bem-vindo ao Gerenciamento Bancário ===");
        
        System.out.print("Informe seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Informe seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Informe seu CPF: ");
        String cpf = scanner.nextLine();
        banco.setDadosPessoais(nome, sobrenome, cpf);

        do {
            exibirMenu();
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    banco.consultarCadastro();
                    break;
                case 2:
                    double saldo = banco.getSaldo();
                    System.out.println("Seu saldo é: R$" + saldo);
                    break;
                case 3:
                    System.out.print("Informe o valor do depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    banco.depositar(valorDeposito);
                    break;
                case 4:
                    System.out.print("Informe o valor do saque: ");
                    double valorSaque = scanner.nextDouble();
                    banco.sacar(valorSaque);
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (true);
    }

    public static void exibirMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1 - Consultar cadastro");
        System.out.println("2 - Consultar saldo");
        System.out.println("3 - Realizar depósito");
        System.out.println("4 - Realizar saque");
        System.out.println("5 - Encerrar");
        System.out.print("Escolha uma opção: ");
    }
}

class Banco {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public void setDadosPessoais(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        System.out.println("Dados pessoais atualizados com sucesso!");
    }
    
    public void consultarCadastro() {
        System.out.println("\n=== Cadastro ===");
        System.out.println("Nome: " + nome);
        System.out.println("Sobrenome: " + sobrenome);
        System.out.println("CPF: " + cpf);
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado com sucesso!");
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente!");
        } else {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        }
    }
}