class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    public double consultarSaldo() {
        return saldo;
    }
}

class Usuario {
    private String nome;
    private ContaBancaria conta;

    public Usuario(String nome, double saldoInicial) {
        this.nome = nome;
        this.conta = new ContaBancaria(saldoInicial);
    }

    public String getNome() {
        return nome;
    }

    public ContaBancaria getConta() {
        return conta;
    }
}

// Classe Main
public class Main {
    public static void main(String[] args) {
        // Criando usuário e conta
        Usuario usuario = new Usuario("Gabriel", 7000.00);

        // Operações bancárias
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Saldo inicial: R$" + usuario.getConta().consultarSaldo());

        usuario.getConta().depositar(500.00); // Depósito de R$500
        System.out.println("Saldo após depósito: R$" + usuario.getConta().consultarSaldo());

        usuario.getConta().sacar(200.00); // Saque de R$200
        System.out.println("Saldo após saque: R$" + usuario.getConta().consultarSaldo());

        usuario.getConta().sacar(8000.00); // Tentativa de saque maior que o saldo
    }
}

