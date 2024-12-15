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
            //na primeira diagonal:
            // linha se inicia na 0, coluna se inicia na 0, toda vez que a linha almenta 1, a coluna almenta 1, até chegar na linha 4 e coluna 4:
            for(int i=0 ; i<=4 ; i++){
                tui[i][i]= 'X';
            }

            //na outra diagonal do 'X':
            //linha se inicia na 0, coluna se inicia na 4, toda vez que a linha almenta 1, a coluna diminui 1, até chegar na linha 4 e coluna 0:
            for(int i=0; i<=4; i++){
                tui[i][4-i]= 'X';
            }
        }

        //se o tab[0][0] for 'O':
        else if(tab[0][0]=='O'){
            /*entao tenho que desenhar isso da linha e coluna 0 a 4 da tui desta forma:

                0  1  2  3  4  5 
            0   -  O  O  O  -  #  
            1   O  -  -  -  O  #  
            2   O  -  -  -  O  #  
            3   O  -  -  -  O  # 
            4   -  O  O  O  -  #  
            5   #  #  #  #  #  #      
            
            */
            //nas linhas 1, 2 e 3, as colunas 0 e 4 sempre são 'O':
            for(int l=1 ; l<=3 ; l++){ //laço que percorre as linhas 1, 2 e 3
                tui[l][0]= 'O';
                tui[l][4]= 'O';
            }

            //nas colunas 1, 2 e 3, as linhas 0 e 4 sempre são 'O':
            for(int c=1 ; c<=3 ; c++){ //laço que percorre as colunas 1, 2 e 3
                tui[0][c]= 'O';
                tui[4][c]= 'O';
            }

        }
        //se o tab[0][0] for vazio, ent nada é mudado (logo nao precisa do else)




        
        //desenhando a linha 0 e coluna 1 do tabuleiro:
        if(tab[0][1]=='X'){ //se a posicao tab[0][1] estiver com X:
            /*entao tenho que desenhar isso da linha 0 a 4 e coluna 6 a 10 da tui desta forma:

               5  6  7  8  9 10 11 
            0  #  X  -  -  -  X  # 
            1  #  -  X  -  X  -  #  
            2  #  -  -  X  -  -  # 
            3  #  -  X  -  X  -  # 
            4  #  X  -  -  -  X  # 
            5  #  #  #  #  #  #  #      
            
            */
            //na primeira diagonal:
            // linha se inicia na 0, coluna se inicia na 6, toda vez que a linha almenta 1, a coluna almenta 1, até chegar na linha 4 e coluna 10:
            for(int i=0 ; i<=4 ; i++){
                tui[i][6+i]= 'X';
            }

            //na outra diagonal do 'X':
            //linha se inicia na 0, coluna se inicia na 10, toda vez que a linha almenta 1, a coluna diminui 1, até chegar na linha 4 e coluna 6:
            for(int i=0; i<=4; i++){
                tui[i][10-i]= 'X';
            }
        }

        //se o tab[0][1] for 'O':
        else if(tab[0][1]=='O'){
            /*entao tenho que desenhar isso da linha 0 a 4 e coluna 6 a 10 da tui desta forma:

               5  6  7  8  9 10 11 
            0  #  -  O  O  O  -  # 
            1  #  O  -  -  -  O  #  
            2  #  O  -  -  -  O  # 
            3  #  O  -  -  -  O  # 
            4  #  -  O  O  O  -  # 
            5  #  #  #  #  #  #  #  
            
            */
            //nas linhas 1, 2 e 3, as colunas 6 e 10 sempre são 'O':
            for(int l=1 ; l<=3 ; l++){ //laço que percorre as linhas 1, 2 e 3
                tui[l][6]= 'O';
                tui[l][10]= 'O';
            }

            //nas colunas 7, 8 e 9, as linhas 0 e 4 sempre são 'O':
            for(int c=7 ; c<=9 ; c++){ //laço que percorre as colunas 7, 8 e 9
                tui[0][c]= 'O';
                tui[4][c]= 'O';
            }

        }
        //se o tab[0][1] for vazio, ent nada é mudado (logo nao precisa do else)

        



        //desenhando a linha 0 e coluna 2 do tabuleiro:
        if(tab[0][2]=='X'){ //se a posicao tab[0][2] estiver com X:
            /*entao tenho que desenhar isso da linha 0 a 4 e coluna 12 a 16 da tui desta forma:

              11 12 13 14 15 16 
            0  #  X  -  -  -  X  
            1  #  -  X  -  X  -   
            2  #  -  -  X  -  -  
            3  #  -  X  -  X  -  
            4  #  X  -  -  -  X  
            5  #  #  #  #  #  #      
            
            */
            //na primeira diagonal:
            // linha se inicia na 0, coluna se inicia na 12, toda vez que a linha almenta 1, a coluna almenta 1, até chegar na linha 4 e coluna 16:
            for(int i=0 ; i<=4 ; i++){
                tui[i][12+i]= 'X';
            }

            //na outra diagonal do 'X':
            //linha se inicia na 0, coluna se inicia na 16, toda vez que a linha almenta 1, a coluna diminui 1, até chegar na linha 4 e coluna 12:
            for(int i=0; i<=4; i++){
                tui[i][16-i]= 'X';
            }
        }

        //se o tab[0][2] for 'O':
        else if(tab[0][2]=='O'){
            /*entao tenho que desenhar isso da linha 0 a 4 e coluna 12 a 16 da tui desta forma:

              11 12 13 14 15 16 
            0  #  -  O  O  O  -  
            1  #  O  -  -  -  O   
            2  #  O  -  -  -  O  
            3  #  O  -  -  -  O  
            4  #  -  O  O  O  -  
            5  #  #  #  #  #  # 
            
            */
            //nas linhas 1, 2 e 3, as colunas 12 e 16 sempre são 'O':
            for(int l=1 ; l<=3 ; l++){ //laço que percorre as linhas 1, 2 e 3
                tui[l][12]= 'O';
                tui[l][16]= 'O';
            }

            //nas colunas 13, 14 e 15, as linhas 0 e 4 sempre são 'O':
            for(int c=13 ; c<=15 ; c++){ //laço que percorre as colunas 13, 14 e 15
                tui[0][c]= 'O';
                tui[4][c]= 'O';
            }

        }
        //se o tab[0][2] for vazio, ent nada é mudado (logo nao precisa do else)

    




        //desenhando a linha 1 e coluna 0 do tabuleiro:
        if(tab[1][0]=='X'){ //se a posicao tab[1][0] estiver com X:
            /*entao tenho que desenhar isso da linha 6 a 10 e da coluna 0 a 4 da tui desta forma:

                0  1  2  3  4  5 
            5   #  #  #  #  #  #
            6   X  -  -  -  X  #  
            7   -  X  -  X  -  #  
            8   -  -  X  -  -  #  
            9   -  X  -  X  -  # 
            10  X  -  -  -  X  #  
            11  #  #  #  #  #  #      
            
            */
            //na primeira diagonal:
            // linha se inicia na 6, coluna se inicia na 0, toda vez que a linha almenta 1, a coluna almenta 1, até chegar na linha 10 e coluna 4:
            for(int i=0 ; i<=4 ; i++){
                tui[6+i][i]= 'X';
            }

            //na outra diagonal do 'X':
            //linha se inicia na 6, coluna se inicia na 4, toda vez que a linha almenta 1, a coluna diminui 1, até chegar na linha 10 e coluna 0:
            for(int i=0; i<=4; i++){
                tui[6+i][4-i]= 'X';
            }
        }

        //se o tab[1][0] for 'O':
        else if(tab[1][0]=='O'){
            /*entao tenho que desenhar isso da linha e coluna 0 a 4 da tui desta forma:

                0  1  2  3  4  5 
            5   #  #  #  #  #  #
            6   -  O  O  O  -  #  
            7   O  -  -  -  O  #  
            8   O  -  -  -  O  #  
            9   O  -  -  -  O  # 
            10  -  O  O  O  -  #  
            11  #  #  #  #  #  #      
            
            */
            //nas linhas 7, 8 e 9, as colunas 0 e 4 sempre são 'O':
            for(int l=7 ; l<=9 ; l++){ //laço que percorre as linhas 7, 8 e 9
                tui[l][0]= 'O';
                tui[l][4]= 'O';
            }

            //nas colunas 1, 2 e 3, as linhas 6 e 10 sempre são 'O':
            for(int c=1 ; c<=3 ; c++){ //laço que percorre as colunas 1, 2 e 3
                tui[6][c]= 'O';
                tui[10][c]= 'O';
            }

        }
        //se o tab[1][0] for vazio, ent nada é mudado (logo nao precisa do else)




        
        //desenhando a linha 1 e coluna 1 do tabuleiro:
        if(tab[1][1]=='X'){ //se a posicao tab[1][1] estiver com X:
            /*entao tenho que desenhar isso da linha 6 a 10 e coluna 6 a 10 da tui desta forma:

               5  6  7  8  9 10 11 
            5  #  #  #  #  #  #  #   
            6  #  X  -  -  -  X  # 
            7  #  -  X  -  X  -  #  
            8  #  -  -  X  -  -  # 
            9  #  -  X  -  X  -  # 
            10 #  X  -  -  -  X  # 
            11 #  #  #  #  #  #  #      
            
            */
            //na primeira diagonal:
            // linha se inicia na 6, coluna se inicia na 6, toda vez que a linha almenta 1, a coluna almenta 1, até chegar na linha 10 e coluna 10:
            for(int i=0 ; i<=4 ; i++){
                tui[6+i][6+i]= 'X';
            }

            //na outra diagonal do 'X':
            //linha se inicia na 6, coluna se inicia na 10, toda vez que a linha almenta 1, a coluna diminui 1, até chegar na linha 10 e coluna 6:
            for(int i=0; i<=4; i++){
                tui[6+i][10-i]= 'X';
            }
        }

        //se o tab[1][1] for 'O':
        else if(tab[1][1]=='O'){
            /*entao tenho que desenhar isso da linha 6 a 10 e coluna 6 a 10 da tui desta forma:

               5  6  7  8  9 10 11 
            5  #  #  #  #  #  #  # 
            6  #  -  O  O  O  -  # 
            7  #  O  -  -  -  O  #  
            8  #  O  -  -  -  O  # 
            9  #  O  -  -  -  O  # 
            10 #  -  O  O  O  -  # 
            11 #  #  #  #  #  #  #  
            
            */
            //nas linhas 7, 8 e 9, as colunas 6 e 10 sempre são 'O':
            for(int l=7 ; l<=9 ; l++){ //laço que percorre as linhas 7, 8 e 9
                tui[l][6]= 'O';
                tui[l][10]= 'O';
            }

            //nas colunas 7, 8 e 9, as linhas 6 e 10 sempre são 'O':
            for(int c=7 ; c<=9 ; c++){ //laço que percorre as colunas 7, 8 e 9
                tui[6][c]= 'O';
                tui[10][c]= 'O';
            }

        }
        //se o tab[1][1] for vazio, ent nada é mudado (logo nao precisa do else)

        



        //desenhando a linha 1 e coluna 2 do tabuleiro:
        if(tab[1][2]=='X'){ //se a posicao tab[1][2] estiver com X:
            /*entao tenho que desenhar isso da linha 6 a 10 e coluna 12 a 16 da tui desta forma:

              11 12 13 14 15 16 
            5  #  #  #  #  #  # 
            6  #  X  -  -  -  X  
            7  #  -  X  -  X  -   
            8  #  -  -  X  -  -  
            9  #  -  X  -  X  -  
            10 #  X  -  -  -  X  
            11 #  #  #  #  #  #
            
            */
            //na primeira diagonal:
            // linha se inicia na 6, coluna se inicia na 12, toda vez que a linha almenta 1, a coluna almenta 1, até chegar na linha 10 e coluna 16:
            for(int i=0 ; i<=4 ; i++){
                tui[6+i][12+i]= 'X';
            }

            //na outra diagonal do 'X':
            //linha se inicia na 6, coluna se inicia na 16, toda vez que a linha almenta 1, a coluna diminui 1, até chegar na linha 10 e coluna 12:
            for(int i=0; i<=4; i++){
                tui[6+i][16-i]= 'X';
            }
        }

        //se o tab[1][2] for 'O':
        else if(tab[1][2]=='O'){
            /*entao tenho que desenhar isso da linha 6 a 10 e coluna 12 a 16 da tui desta forma:

              11 12 13 14 15 16 
            5  #  #  #  #  #  # 
            6  #  -  O  O  O  -  
            7  #  O  -  -  -  O   
            8  #  O  -  -  -  O  
            9  #  O  -  -  -  O  
            10 #  -  O  O  O  -  
            11 #  #  #  #  #  # 
            
            */
            //nas linhas 7, 8 e 9, as colunas 12 e 16 sempre são 'O':
            for(int l=7 ; l<=9 ; l++){ //laço que percorre as linhas 7, 8 e 9
                tui[l][12]= 'O';
                tui[l][16]= 'O';
            }

            //nas colunas 13, 14 e 15, as linhas 6 e 10 sempre são 'O':
            for(int c=13 ; c<=15 ; c++){ //laço que percorre as colunas 13, 14 e 15
                tui[6][c]= 'O';
                tui[10][c]= 'O';
            }

        }
        //se o tab[1][2] for vazio, ent nada é mudado (logo nao precisa do else)
        


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
