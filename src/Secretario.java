import java.time.LocalDate;

class Secretario extends Funcionario {
    public Secretario(String nome, LocalDate dataDeContratacao){
        super(nome, new Cargo("Secretário", 7000.00, 1000.00, 0.2), dataDeContratacao);
    }

    @Override
    public double calcularSalario(int mes, int ano) {
        int anosDeServico = calcularAnosDeServico(ano);
        return cargo.getSalario() + (anosDeServico * cargo.getBeneficioPorAno());
    }

    @Override
    public double calcularBeneficio(int mes, int ano) {
        return calcularSalario(mes, ano) * cargo.getBeneficioPercentual();
    }

}
