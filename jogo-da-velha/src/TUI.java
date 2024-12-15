public class TUI implements TabUI{
    private char [][] tui;

    public TUI(){
        //iniciando tabuleiro
        tui= new char[17][17];

        //iniciando o desenho do jogo da velha com todas as casas vazias:
        reiniciarTUI();
    }

    @Override
    public void desenheTabuleiro(char[][] tab) {
        //desenhando a linha 0 e coluna 0 do tabuleiro:
        
        if(tab[0][0]=='X'){ //se a posicao tab[0][0] estiver com X:
            /*entao tenho que desenhar isso da linha e coluna 0 a 4 da tui desta forma:

                0  1  2  3  4  5 
            0   X  -  -  -  X  #  
            1   -  X  -  X  -  #  
            2   -  -  X  -  -  #  
            3   -  X  -  X  -  # 
            4   X  -  -  -  X  #  
            5   #  #  #  #  #  #      
            
            */
            // da linha e coluna 0 a 4, toda vez que a linha e coluna são iguais, aquela posição é o caractere 'X':
            for(int i=0 ; i<=4 ; i++){
                tui[i][i]= 'X';
            }

            //na outra diagonal do 'X':
            //linha se inicia na 0, coluna se inicia na 4, toda vez que a linha almenta 1, a coluna diminui 1, até chegar na linha 4 e coluna 0:
            for(int i=0; i<=4; i++){
                tui[i][4-i]= 'X';
            }
            

        }

    

        //depois ajustar todas as posições, exibir toda o desenho:
        for(int l=0 ; l<tui.length ; l++){
            for(int c=0 ; c<tui.length ; c++){
                System.out.print(tui[l][c]);
            }
            System.out.println();
        }
    }

    public void reiniciarTUI(){

        /* 
            desenho do tabuleiro 
            0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16
        0   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        1   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        2   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        3   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        4   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        5   #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #
        6   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        7   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        8   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        9   -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        10  -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        11  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #  #
        12  -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        13  -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        14  -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        15  -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
        16  -  -  -  -  -  #  -  -  -  -  -  #  -  -  -  -  -
            
        */

        //primeiramente deixar o tabuleiro todo como espaço ' ' pra depois fazer o desenho:
        for(int l=0 ; l<tui.length ; l++){
            for(int c=0 ; c<tui.length ; c++){
                tui[l][c]= ' ';
            }
        }

        //desenhando:

        //em todas as linhas, as colunas 5 e 11 sao '#':
        for(int l=0 ; l<=16 ; l++){
            tui[l][5]= '#';
            tui[l][11]= '#';
        }

        // em todas as colunas, as linhas 5 e 11 sao '#':
        for(int c=0 ; c<=16 ; c++){
            tui[5][c]= '#';
            tui[11][c]= '#';
        }
    }
    
}
