import java.util.Scanner;

public class TUI extends Calculadora implements CalcUI {
    private Calculadora calculadora; 
    private Scanner ler = new Scanner(System.in); 
    private double resultado = 0; 


    // Constantes para os diferentes menus
    private final int MENUINICIAL = 0;
    private final int MENUN1 = 1;
    private final int MENUN2 = 2;
    private final int MENURESULTADO = 3;

    // Matriz para representar a interface do usuário
    private char[][] matriz;


    
    public TUI() {
        this.calculadora = new Calculadora(); 

        int linhas = 16; //linhas
        int colunas = 21; //colunas

        // Criação da matriz
        matriz = new char[linhas][colunas];

        // preenchendo a matriz com espaços em branco
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = ' '; 
            }
        }

        // Adicionando as bordas da matriz
        for (int i = 0; i < colunas; i++) {
            matriz[0][i] = '#'; // superior
            matriz[linhas - 1][i] = '#'; // inferior
        }
        for (int i = 0; i < linhas; i++) {
            matriz[i][0] = '#'; // esquerda
            matriz[i][colunas - 1] = '#'; //direita
        }

        // Linha de asteriscos do display
        for (int j = 2; j < colunas - 2; j++) {
            matriz[2][j] = '*'; // superior 
            matriz[5][j] = '*'; // inferior 
        }
        
        // lateral esquerda
        matriz[3][2] = '*'; 
        matriz[4][2] = '*';
        
        //lateral direita
        matriz[3][18] = '*';
        matriz[4][18] = '*';

        // Opções do menu na matriz
        String[] opcoes = {
            "Operacao: ",
            "1 - Entrar dados",
            "2 - Somar",
            "3 - Subtrair",
            "4 - Multiplicação",
            "5 - Divisão",
            "6 - Sair"
        };

        // Inserindo as opções no menu, começando na linha apropriada
        int opcaoInicialLinha = 7;
        for (int i = 0; i < opcoes.length; i++) {
            for (int j = 0; j < opcoes[i].length(); j++) {
                matriz[opcaoInicialLinha + i][2 + j] = opcoes[i].charAt(j); // Preenchendo a linha com opções do menu
            }
        }
    }

    // exibir a matriz formatada
    public void exibirMenu() {
        // Exibindo a matriz formatada no console
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]); 
            }
            System.out.println(); 
        }
    }


    //preenche o display com espaços vazios
    public void limparDisplay() {
        for (int c=3 ; c<matriz[0].length-3 ; c++) { 
            matriz[3][c]=' '; 
            matriz[4][c]=' '; 
        }
    }

    public void atualizarDisplay(int menu) {
        this.limparDisplay(); // Limpa a área de exibição antes de atualizar com novos dados
        String textoL1 = "", textoL2 = ""; // Inicializa as strings que irão armazenar os textos a serem exibidos
    
        // Verifica qual menu está ativo e define os textos a serem exibidos
        if (menu == MENUINICIAL) { 
            textoL1 = "Qual Opcao?"; // mensagem para o menu inicial
            textoL2 = ""; // sem texto na segunda linha neste caso

        } else if (menu == MENUN1) { 
            // para o menu de entrada de dados, exibe os valores atuais de n1 e n2
            textoL1 = "n1: " + (calculadora.getValor1() != 0 ? String.valueOf(calculadora.getValor1()) : "");
            textoL2 = "n2: " + (calculadora.getValor2() != 0 ? String.valueOf(calculadora.getValor2()) : "");

        } else if (menu == MENUN2) { 
            // Para o menu onde se espera a segunda operação, exibe apenas n2
            textoL1 = "N2: " + String.valueOf(calculadora.getValor2());
            textoL2 = "Nova opcao?"; // pergunta ao usuário por uma nova opção

        } else if (menu == MENURESULTADO) { 
            // Para o menu que exibe o resultado da operação
            textoL1 = "Ans: " + String.valueOf(calculadora.getResultado()); // Mostra o resultado da operação
            textoL2 = "Nova opcao?"; 
        }
    
        int LIMITECHARDISPLAY = 15; // Define um limite de caracteres para a exibição
    
        // se o comprimento do L1 exceder o limite, corta para se ajustar ao display
        if (textoL1.length() > LIMITECHARDISPLAY) { 
            textoL1 = textoL1.substring(0, LIMITECHARDISPLAY); 
        }
        
        // mesma coisa para L2
        if (textoL2.length() > LIMITECHARDISPLAY) { 
            textoL2 = textoL2.substring(0, LIMITECHARDISPLAY); 
        }
    
        // Atualiza a matriz com os textos L1 e L2, invertendo a ordem dos caracteres para exibição correta
        for (int i = textoL1.length() - 1; i >= 0; i--) { 
            // preenche a linha 3 da matriz com os caracteres de textoL1 em ordem reversa para exibição correta
            matriz[3][matriz[0].length - 3 - (textoL1.length() - i)] = textoL1.charAt(i); 
        }
        
        for (int i = textoL2.length() - 1; i >= 0; i--) { 
            //mesma coisa com a linha 4
            matriz[4][matriz[0].length - 3 - (textoL2.length() - i)] = textoL2.charAt(i); 
        }
    }
    


    @Override
    public void execGui() {
        boolean continuar = true; // Variável para controlar o loop do menu
        
        atualizarDisplay(MENUINICIAL); // Atualiza o display para o menu inicial

        while (continuar) {            
            exibirMenu(); 
            System.out.print("-> "); // prompt para entrada

            int operacao = ler.nextInt(); 

            if (operacao == 6) { // se o usuário escolher sair
                continuar = false;
                System.out.println("Saindo..."); 
                continue;
            } else if (operacao == 1) { 
                calculadora.setValor1(0); // Reseta valor1 antes de entrar dados
                calculadora.setValor2(0); // Reseta valor2 antes de entrar dados

                this.atualizarDisplay(MENUN1); 
                this.exibirMenu();
                System.out.print("n1: "); 
                calculadora.setValor1(ler.nextDouble()); 
                
                this.atualizarDisplay(MENUN1); 
                this.exibirMenu();
                System.out.print("n2: "); 
                calculadora.setValor2(ler.nextDouble()); 
                this.atualizarDisplay(MENUN2); 
                
            } else { 
                calculadora.setOperacao(operacao - 1); // define a operação com base na escolha do usuário
                calculadora.realizarOperacao(); 
                
                if (operacao >= 2 && operacao <= 5)//verifica se é uma opção que tem resultado(somar, subtrair, multiplicar e dividir) { 
                    this.atualizarDisplay(MENURESULTADO); 
                }
            }
            
        }
}
