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

        //tamanho de linhas ou colunas do tabuleiro:
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

            //almentando o numero de jogadas
            numeroJogadas++;

            //mudando a vez do jogador atual
            if(jogadorAtual == getJogador1()){
                jogadorAtual= getJogador2();
            }
            else{
                jogadorAtual= getJogador1();
            }

            return true; //jogada efetuada
        }
        else{ //se o local nao estiver vazio
            
            //entao nao foi possivel jogar:
            return false;
        }


    }

    @Override
    public char verificarVencedor() {
        //criando uma variavel que sirva para verificar a vitoria do 'X', depois do 'O'
        char verificador = 'X'; //apos verificar se houve a vitoria do 'X', ele virará 'O' e refazerá a mesma verificação

        //laço que fará toda a verificação de vitoria, roda duas vezes: na primeira verifica o 'X', depois o 'O' conforme o valor da variavel "verificador":
        for (int i=0 ; i<2 ; i++){
            //lógica para a verificação:

            //verificando se as diagonais são todas 'X' ou todas 'O':
            if(getTabuleiro()[0][0]==verificador && getTabuleiro()[1][1]==verificador && getTabuleiro()[2][2]==verificador){
                /*
                  0 1 2
                0 x * * 
                1 * x *
                2 * * x
                 
                 */
                //entao há vitoria do caractere que estar sendo verificado:
                return verificador;
            }
            //se for a outra diagonal:
            else if(getTabuleiro()[0][2]==verificador && getTabuleiro()[1][1]==verificador && getTabuleiro()[2][0]==verificador){
                /*
                  0 1 2
                0 * * x 
                1 * x *
                2 x * *
                 
                 */

                //entao há vitoria do caractere que estar sendo verificado:
                return verificador;
            }

            //verificando horizontais:
            /*
               0 1 2
             0 x x x 
             1 * * *
             2 * * *
             
               0 1 2
             0 * * *
             1 x x x
             2 * * *

               0 1 2
             0 * * * 
             1 * * *
             2 x x x

             */
            //após perceber que as colunas permanecem fixas em relaçao as linhas, e o que muda é apenas a linha
            //uso um for para percorrer todas as 3 linhas, e deixo as 3 colunas fixas na verificação, apenas variando a linha
            for(int l=0 ; l<3 ; l++){
                //se uma linha horizontal inteira está com o mesmo caractere de verificaçao (X ou O):
                if(getTabuleiro()[l][0]==verificador && getTabuleiro()[l][1]==verificador && getTabuleiro()[l][2]==verificador){
                    //entao há vitoria do caractere que estar sendo verificado:
                    return verificador;
                }
            }

            //verificando verticais:
            /*
               0 1 2
             0 x * * 
             1 x * *
             2 x * *
             
               0 1 2
             0 * x * 
             1 * x * 
             2 * x * 

               0 1 2
             0 * * x 
             1 * * x
             2 * * x

             */
            //após perceber que as linhas permanecem fixas em relaçao as coluna, e o que muda é apenas a linha
            //uso um for para percorrer todas as 3 colunas, e deixo as 3 linhas fixas na verificação, apenas variando a coluna
            for(int c=0 ; c<3 ; c++){
                //se uma coluna vertical inteira está com o mesmo caractere de verificaçao (X ou O):
                if(getTabuleiro()[0][c]==verificador && getTabuleiro()[1][c]==verificador && getTabuleiro()[2][c]==verificador){
                    //entao há vitoria do caractere que estar sendo verificado:
                    return verificador;
                }
            }

            //caso nao entre em nenhum caso de vitoria:
            //apos fazer toda essa verificação com o 'X', volta lá pro inicio do laco com o valor do verificador como 'O':
            verificador= 'O';
        } 

        //se apos verificar com o 'X', e 'O', nao retornar nada, significa que nao houve vitoria, entao:
        return '*'; //retorne '*', indicando que nenhum dos dois ganharam ainda

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
    
    public int getNumJogadas(){
        return numeroJogadas;
    }
}
