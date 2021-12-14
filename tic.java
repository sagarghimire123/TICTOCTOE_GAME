import java.util.Scanner;
public class tic{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the name of first player:");
        String name1 = in.nextLine();
        System.out.print("Enter the name of second player:");
        String name2 = in.nextLine();

        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
        boolean isname1 = true;
        boolean gameEnded=false;
        while(!gameEnded){
            drawBoard(board);

            char symbol = ' ';
            if (isname1) {
                symbol = 'x';
            } else {
                symbol = 'o';
            }

            if (isname1) {
                System.out.println("\n"+name1 +" it's your turn(x):");
            } else {
                System.out.println("\n"+name2 +" it's your turn(o):");
            }

            int row = 0;
            int col = 0;
            while (true) {
                System.out.print("Enter a row(0,1 or 2):");
                row = in.nextInt();
                System.out.print("Enter a col(0,1 or 2):");
                col = in.nextInt();

                if (row < 0 || col < 0 || row > 2 || col > 2) {
                    System.out.println("Selection is out of order");
                    System.out.println("Plase enter only (0,1 or 2)");
                } else if (board[row][col] != '_') {
                    System.out.println("This space is already occupied");
                    System.out.println("Please select different space:");
                } else {
                    break;
                }
            }

            board[row][col] = symbol;
            if (hasWon(board) == true) {
                if (symbol=='x') {
                    System.out.println(name1 + " has won");

                }else{
                    System.out.println(name2+"has won");
                }
                gameEnded=true;


            } else {

                if (hasTied(board)) {
                    System.out.println("The game is tie");
                    gameEnded=true;
                } else {
                    isname1= !isname1;
                }
            }
        }
        drawBoard(board);
    }

    public static void drawBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + board[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static boolean hasWon(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '_') {
                return true;
            }
        }
        for(int j=0;j<3;j++){
            if(board[0][j]==board[1][j]&&board[1][j]==board[2][j]&&board[0][j] != '_'){
                return true;
            }
        }
        if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[0][0] != '_'){
            return true;
        }
        if(board[2][0]==board[1][1]&&board[1][1]==board[0][2]&&board[2][0] != '_') {
            return true;
        }
        return false;
    }

    public static boolean hasTied(char[][]board){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]=='_'){
                    return false;
                }
            }
        }
        return true;
    }
}



