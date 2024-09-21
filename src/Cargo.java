class Cargo {
    private String nome;
    private double salario;
    private double beneficioPorAno;
    private double beneficioPorPercentual;

    public Cargo(String nome, double salario, double beneficioPorAno, double beneficioPorPercentual){
        this.nome = nome;
        this.salario = salario;
        this.beneficioPorAno = beneficioPorAno;
        this.beneficioPorPercentual = beneficioPorPercentual;
    }

    public String getNome(){
        return nome;
    }
    public double getSalario(){
        return salario;
    }
    public double getBeneficioPorAno(){
        return beneficioPorAno;
    }
    public double getBeneficioPercentual(){
        return beneficioPorPercentual;
    }
}
