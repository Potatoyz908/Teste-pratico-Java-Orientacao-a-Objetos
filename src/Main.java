import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Secretario("Jorge Carvalho", LocalDate.of(2018, 1, 1)));
        funcionarios.add(new Secretario("Maria Souza", LocalDate.of(2015, 12, 1)));
        Vendedor vendedor1 = new Vendedor("Ana Silva", LocalDate.of(2021, 12, 1));
        Vendedor vendedor2 = new Vendedor("João Mendes", LocalDate.of(2021, 12, 1));
        funcionarios.add(vendedor1);
        funcionarios.add(vendedor2);
        funcionarios.add(new Gerente("Juliana Alves", LocalDate.of(2017, 07, 1)));
        funcionarios.add(new Gerente("Bento Albino", LocalDate.of(2014, 03, 1)));

        //registro de vendas da Ana Silva
        vendedor1.setValorVendido(12, 5200.00);
        vendedor1.setValorVendido(1, 4000.00);
        vendedor1.setValorVendido(2, 4200.00);
        vendedor1.setValorVendido(3, 5850.00);
        vendedor1.setValorVendido(4, 7000.00);
        
        //registro de vendas do João Mendes
        vendedor2.setValorVendido(12, 3400.00);
        vendedor2.setValorVendido(1, 7700.00);
        vendedor2.setValorVendido(2, 5000.00);
        vendedor2.setValorVendido(3, 5900.00);
        vendedor2.setValorVendido(4, 6500.00);
        

        /*
        Assim que for iniciado o programa insira o mês e ano (apenas números) para serem realizados todos os cálculos
        */
        boolean valido = false;
        int mes = 0;
        int ano = 0;
        Scanner scanner = new Scanner(System.in);
        
        while (!valido) {
            System.out.print("Digite o mês(apenas números): ");
            mes = scanner.nextInt();

            if (mes > 12 || mes < 1) {
                System.out.println("Erro! Insira um valor válido para o mês.");
            } else {
                valido = true;
            }
        }

        System.out.print("Digite o ano: ");
        ano = scanner.nextInt();
        scanner.close();
        
        System.out.println("Total pago a funcionários no mês " + mes + "/" + ano + ": R$ " + calcularTotalPago(funcionarios, mes, ano));
        System.out.println("Total pago em salários no mês " + mes + "/" + ano + ": R$ " + calcularTotalSalarios(funcionarios, mes, ano));
        System.out.println("Total pago em benefícios no mês " + mes + "/" + ano + ": R$ " + calcularTotalBeneficios(funcionarios, mes, ano));
        System.out.println("Funcionário que recebeu o valor mais alto no mês " + mes + "/" + ano + ": " +getFuncionarioMaisPago(funcionarios, mes, ano));
        System.out.println("Funcionário que recebeu o valor mais alto em benefícios no mês " + mes + "/" + ano + ": " + getFuncionarioMaisBeneficios(funcionarios, mes, ano));
        System.out.println("Vendedor que mais vendeu no mês " + mes + "/" + ano + ": " + getVendedorMaisVendas(funcionarios, mes, ano));

        
    }

    //Valor total pago (salário e benefício) a esses funcionários no mês
    public static double calcularTotalPago(List<Funcionario> funcionarios, int mes, int ano) {
        double total = 0.0;
        for (Funcionario funcionario : funcionarios) {
            total += funcionario.calcularSalario(mes, ano) + funcionario.calcularBeneficio(mes, ano);
        }
        return total;
    }

    //Total pago somente em salários no mês
    public static double calcularTotalSalarios(List<Funcionario> funcionarios, int mes, int ano) {
        double total = 0.0;
        for (Funcionario funcionario : funcionarios) {
            total += funcionario.calcularSalario(mes, ano);
        }
        return total;
    }

    //Total pago em benefícios no mês
    public static double calcularTotalBeneficios(List<Funcionario> funcionarios, int mes, int ano) {
        double total = 0.0;
        for (Funcionario funcionario : funcionarios) {
            if(funcionario instanceof Secretario || funcionario instanceof Vendedor){
                total += funcionario.calcularBeneficio(mes, ano);
            }
        }
        return total;
    }

    //Nome do funcionário que recebeu o valor mais alto em benefícios no mês
    private static String getFuncionarioMaisBeneficios(List<Funcionario> funcionarios, int mes, int ano) {
        double maxValor = 0.0;
        String funcionarioMaisBeneficios = "";
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Secretario || funcionario instanceof Vendedor) {
                double valor = funcionario.calcularBeneficio(mes, ano);
                if (valor > maxValor) {
                    maxValor = valor;
                    funcionarioMaisBeneficios = funcionario.nome;
                }
            }
        }
        return funcionarioMaisBeneficios;
    }

    //Nome do funcionário que recebeu o valor mais alto no mês
    public static String getFuncionarioMaisPago(List<Funcionario> funcionarios, int mes, int ano) {
        double maxValor = 0.0;
        String funcionarioMaisPago = "";
        for (Funcionario funcionario : funcionarios) {
            double valor = funcionario.calcularSalario(mes, ano) + funcionario.calcularBeneficio(mes, ano);
            if (valor > maxValor) {
                maxValor = valor;
                funcionarioMaisPago = funcionario.nome;
            }
        }
        return funcionarioMaisPago;
    }

    //Vendedor que mais vendeu no mês
    public static String getVendedorMaisVendas(List<Funcionario> funcionarios, int mes, int ano) {
        double maxValor = 0.0;
        String vendedorMaisVendas = "";
        for (Funcionario funcionario : funcionarios) {
            if (funcionario instanceof Vendedor) {
                Vendedor vendedor = (Vendedor) funcionario;
                double valor = vendedor.getValorVendido(mes);
                if (valor > maxValor) {
                    maxValor = valor;
                    vendedorMaisVendas = funcionario.nome;
                }
            }
        }
        return vendedorMaisVendas;
    }

}
