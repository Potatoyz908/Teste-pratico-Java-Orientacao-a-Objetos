import java.time.LocalDate;

abstract class Funcionario{
    protected String nome;
    protected Cargo cargo;
    protected LocalDate dataDeContratacao;

    public Funcionario(String nome, Cargo cargo, LocalDate dataDeContratacao){
        this.nome = nome;
        this.cargo = cargo;
        this.dataDeContratacao = dataDeContratacao;
    }

    public int calcularAnosDeServico(int anoAtual){
        return anoAtual - this.dataDeContratacao.getYear();
    }

    public abstract double calcularSalario(int mes, int ano);
    public abstract double calcularBeneficio(int mes, int ano);
}