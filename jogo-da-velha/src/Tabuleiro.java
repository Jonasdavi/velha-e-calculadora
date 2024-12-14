public class Tabuleiro extends Tabuleiro_base{
    private Jogador iniciante, jogadorAtual;
    private int numeroJogadas;

    public Tabuleiro(Jogador p1, Jogador p2){
        super(p1, p2);

        //iniciando o jogador 1 como iniciante e atual:
        iniciante = getJogador1();
        jogadorAtual = getJogador1();

        //iniciando variavel do numero de jogadas como 0:
        numeroJogadas= 0;
    }

    @Override
    public void exibirTabuleiro() {

        //tamanho das linhas e colunas do tabuleiro:
        int tamanhoTabuleiro= getTabuleiro().length;

        //Laços para percorrer toda a matriz e exibila:
        for(int l=0 ; l<tamanhoTabuleiro ; l++){ //percorre as linhas
            for(int c=0 ; c<tamanhoTabuleiro ; c++){ //percorre as colunas

                System.out.print(getTabuleiro()[l][c]);

            }
            System.out.println(); //pular linha em seguida ao terminar de percorrer as colunas
        }

    }

    @Override
    public boolean jogar() {
        //verificar se estar na primeira jogada para saber se o jogador atual deve ser o iniciante ou nao
        if(numeroJogadas == 0){
            jogadorAtual = iniciante;
        }
        //verificar se o numero de jogadas já esta no limite (caso esteja, significa que o tabuleiro está totalmente preenchido):
        else if(numeroJogadas == 9){
            return false; //se o tabuleiro está lotado, nao se pode jogar
        }


        //botando o jogador atual para escolher a linha e a coluna que deseja jogar:
        int linha = jogadorAtual.escolherLinha();
        int coluna= jogadorAtual.escolherColuna();

        //verificando se a linha e coluna estao validos (com o numero entre 0 e 2, que sao as 3 linhas e colunas possiveis de se jogar no tabuleiro):
        if(linha<0 || linha>2 || coluna<0 || coluna>2){ //se a linha ou coluna estiver fora do que o tabuleiro aguenta
            //entao nao foi possivel jogar:
            return false;
        }

        //verificando se o local escolhido está vazio:
        if(getTabuleiro()[linha][coluna] == '*'){ //se está vazio
            //entao pode jogar
            getTabuleiro()[linha][coluna]= jogadorAtual.getMarcador(); //a posição escolhida muda para o caractere do jogador atual (X ou O)

            return true; //jogada efetuada
        }
        else{ //se o local nao estiver vazio
            
            //entao nao foi possivel jogar:
            return false;
        }


    }

    @Override
    public char verificarVencedor() {
        
    }

    @Override
    public void reiniciarTabuleiro() {
        //tamanho das linhas e colunas do tabuleiro:
        int tamanhoTabuleiro= getTabuleiro().length;

        //Laços para percorrer toda a matriz e muda-la para '*', que representará o espaço vazio:
        for(int l=0 ; l<tamanhoTabuleiro ; l++){ //percorre as linhas
            for(int c=0 ; c<tamanhoTabuleiro ; c++){ //percorre as colunas

                getTabuleiro()[l][c]= '*';

            }
        }
    }

    @Override
    public void setIniciante(int ini) {
        //se o numero para o jogador escolhido for 2:
        if(ini == 2){
            iniciante = getJogador2();
        }
        else{ //se for qualquer outro numero diferente de 2:
            iniciante = getJogador1();
        }
    }
    
}
