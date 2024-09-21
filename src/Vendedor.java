import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class Vendedor extends Funcionario {
    private Map<Integer, Double> vendasMensais;


    public Vendedor(String nome, LocalDate dataDeContratacao){
        super(nome, new Cargo("Vendedor", 12000.00, 1800.00, 0.3), dataDeContratacao);
        this.vendasMensais = new HashMap<>();
    }
    //Pega o valor vendido em um determinado mês
    public double getValorVendido(int mes){
        return vendasMensais.getOrDefault(mes, 0.0);
    }
    //Define o valor vendido em um determinado mês
    public void setValorVendido(int mes, double valor){
        vendasMensais.put(mes,valor);
    }

    @Override
    public double calcularSalario(int mes, int ano){
        int anosDeServico = calcularAnosDeServico(ano);
        return cargo.getSalario() + (anosDeServico * cargo.getBeneficioPorAno());
    }
    @Override
    public double calcularBeneficio(int mes, int ano) {
        double valorVendas = getValorVendido(mes);
        return cargo.getBeneficioPercentual() * valorVendas;
    }


}
