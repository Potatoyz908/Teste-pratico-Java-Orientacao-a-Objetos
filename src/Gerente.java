import java.time.LocalDate;

class Gerente extends Funcionario {
    public Gerente(String nome, LocalDate dataDeContratacao) {
        super(nome, new Cargo("Gerente", 20000.00, 3000.00, 0.0), dataDeContratacao);
    }

    @Override
    public double calcularSalario(int mes, int ano) {
        int anosDeServico = calcularAnosDeServico(ano);
        return cargo.getSalario() + (anosDeServico * cargo.getBeneficioPorAno());
    }

    @Override
    public double calcularBeneficio(int mes, int ano) {
        return 0.0;
    }
}