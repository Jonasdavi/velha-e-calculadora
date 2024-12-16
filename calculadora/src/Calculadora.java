public class Calculadora{
    private double valor1;
    private double valor2;
    private double resultado;
    private int operacao;

    private void somar(){
        resultado=valor1+valor2;
    }

    private void subtrair(){
        resultado=valor1-valor2;
    }

    private void multiplicar(){
        resultado=valor1*valor2;
    }

    private void dividir(){
        resultado=valor1/valor2;
    }

    public double getResultado(){
        return resultado;
    }

    public int getOperacao(){
        return operacao;
    }

    public void setValor1(double valor1){
        this.valor1=valor1;
    }

    public void setValor2(double valor2){
        this.valor2=valor2;
    }

    public void setOperacao(int operacao){
        this.operacao=operacao;
    }

    public double getValor1(){
        return this.valor1;
    }

    public double getValor2(){
        return this.valor2;
    }

    public void realizarOperacao(){
        switch(operacao){
            case 1:
                somar();
                break;

            case 2:
                subtrair();
                break;

            case 3:
                multiplicar();
                break;

            case 4:
                dividir();
                break;
            
            default:
                System.out.println("Operação inexistente");
            
        }
    }

}