/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treasureHunter;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author longthai
 */
public class TreasureHunter {
    
    static char  board[][]=new char[6][8];///use to show on console
    public static void printfun()
    {
          for(int i=0;i<6;i++)
         {
             for(int j=0;j<8;j++)
             {
                 System.out.print(board[i][j]+ " ");
             }
             System.out.println();
         }
          System.out.println("Press 0 for up");
          System.out.println("Press 1 for down");
          System.out.println("Press 2 for left");
          System.out.println("Press 3 for right");
          System.out.println("Press 4 for HP");
          System.out.println("Press 5 for Items");
    }
    public static void clearScreen() {  
    for(int clear = 0; clear < 1000; clear++)
  {
     System.out.println("\b") ;
  }
}
    public static void main(String[] args) {
        // TODO code application logic here
        int user_x=0;
        int user_y=0;
        int treasure=3;
        int monster=3;
        int sword=2;
        int potion=2;
        int hp=10;
        int swordcount=0;
        int user_input;
        int randomrow=6;
        int randomcolumn=8;
        char mainboard[][]=new char[6][8];/// use to store treasure and other things
        Random rand = new Random();
        for( int i=0;i<6;i++)//Intializing with -
        {
            for(int j=0;j<8;j++)
            {
                board[i][j]='-';
            }
        }
        for( int i=0;i<6;i++)//Intializing with _
        {
            for(int j=0;j<8;j++)
            {
                mainboard[i][j]='_';
            }
        }
        for(int i=0;i<3;)//Generating random num for Treasure
        {
            int x=rand.nextInt(randomrow);
            int y=rand.nextInt(randomcolumn);
            if(mainboard[x][y]=='_')
             {
                mainboard[x][y]='T';
                i++;
             }
        }
        for(int i=0;i<3;)//Generating random num for Monster
        {
            int x=rand.nextInt(randomrow);
            int y=rand.nextInt(randomcolumn);
             if(mainboard[x][y]=='_')
             {
                mainboard[x][y]='M';
                i++;
             }
        }
        for(int i=0;i<2;)//Generating random num for Sword
        {
            int x=rand.nextInt(randomrow);
            int y=rand.nextInt(randomcolumn);
             if(mainboard[x][y]=='_')
             {
                mainboard[x][y]='S';
                i++;
             }
        }
        for(int i=0;i<2;)//Generating random num for Potion
        {
            int x=rand.nextInt(randomrow);
            int y=rand.nextInt(randomcolumn);
             if(mainboard[x][y]=='_')
             {
                mainboard[x][y]='P';
                i++;
             }
        }
        for(int i=0;i<1;)////Generating random num for user location
        {
            int x=rand.nextInt(randomrow);
            int y=rand.nextInt(randomcolumn);
             if(mainboard[x][y]=='_')
             {
                board[x][y]='X';
                mainboard[x][y]='X';
                user_x=x;
                user_y=y;
                i++;
             }
        }
        Scanner s=new Scanner(System.in);
        
         do
         {
             printfun();
             System.out.print("Enter your choice:");
             user_input=s.nextInt();
             if(user_input==0)
             {
                 if((user_x-1)==-1)
                 {
                     System.out.println("Invalid Move!");
                 }
                 else
                 {
                     if( (board[user_x - 1][user_y]=='-' && mainboard[user_x -1][user_y]=='_') || (board[user_x - 1][user_y]=='.' && mainboard[user_x -1][user_y]=='.') )
                     {
                         
                         board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x -1][user_y]='X';
                         mainboard[user_x -1][user_y]='X';
                         user_x-=1;
                     }
                     else if(board[user_x - 1][user_y]=='-' && mainboard[user_x -1][user_y]=='T')
                     {
                        board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x -1][user_y]='X';
                         mainboard[user_x -1][user_y]='X';
                         user_x-=1;
                         treasure=treasure-1;
                         System.out.println();
                         System.out.println("You found Treasure");
                     }
                     else if(board[user_x - 1][user_y]=='-' && mainboard[user_x -1][user_y]=='P')
                     {
                        board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x -1][user_y]='X';
                         mainboard[user_x -1][user_y]='X';
                         user_x-=1;
                         potion=potion-1;
                         hp=hp+1;
                         System.out.println();
                         System.out.println("You found potion");
                     }
                     else if(board[user_x - 1][user_y]=='-' && mainboard[user_x -1][user_y]=='S')
                     {
                        board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x -1][user_y]='X';
                         mainboard[user_x -1][user_y]='X';
                         user_x-=1;
                         sword=sword-1;
                         swordcount=swordcount+1;
                         System.out.println();
                         System.out.println("You found sword");
                     }
                      else if(board[user_x - 1][user_y]=='-' && mainboard[user_x -1][user_y]=='M')
                     {
                        board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x -1][user_y]='X';
                         mainboard[user_x -1][user_y]='X';
                         user_x-=1;
                         monster=monster-1;
                         if(swordcount>0)
                         {
                             System.out.println();
                             System.out.println("Monster Attack! You have sword");
                             swordcount=swordcount-1;
                         }
                         else
                         {
                             System.out.println();
                             System.out.println("Monster Attack! You don't have sword");
                             hp=hp-4;
                         }
                     }
                 }
             }
             else if(user_input==1)
             {
                 if((user_x+1)==6)
                 {
                     System.out.println("Invalid Move!");
                 }
                 else
                 {
                      if( (board[user_x + 1][user_y]=='-' && mainboard[user_x +1][user_y]=='_') || (board[user_x + 1][user_y]=='.' && mainboard[user_x +1][user_y]=='.'))
                     {
                         board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x +1][user_y]='X';
                         mainboard[user_x +1][user_y]='X';
                         user_x+=1;
                     }
                      else if(board[user_x + 1][user_y]=='-' && mainboard[user_x +1][user_y]=='T')
                     {
                         board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x +1][user_y]='X';
                         mainboard[user_x +1][user_y]='X';
                         user_x+=1;
                         treasure=treasure-1;
                         System.out.println();
                         System.out.println("You found Treasure");
                     }
                     else if(board[user_x + 1][user_y]=='-' && mainboard[user_x +1][user_y]=='P')
                     {
                         board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x +1][user_y]='X';
                         mainboard[user_x +1][user_y]='X';
                         user_x+=1;
                         potion=potion-1;
                         hp=hp+1;
                         System.out.println();
                         System.out.println("You found Potion");
                     }
                      else if(board[user_x + 1][user_y]=='-' && mainboard[user_x +1][user_y]=='S')
                     {
                         board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x +1][user_y]='X';
                         mainboard[user_x +1][user_y]='X';
                         user_x+=1;
                         sword=sword-1;
                         swordcount=swordcount+1;
                         System.out.println();
                         System.out.println("You found sword");
                     }
                     else if(board[user_x + 1][user_y]=='-' && mainboard[user_x +1][user_y]=='M')
                     {
                         board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x +1][user_y]='X';
                         mainboard[user_x +1][user_y]='X';
                         user_x+=1;
                         monster=monster-1;
                         if(swordcount>0)
                         {
                             System.out.println();
                             System.out.println("Monster Attack! You have sword");
                             swordcount=swordcount-1;
                         }
                         else
                         {
                             System.out.println();
                             System.out.println("Monster Attack! You don't have sword");
                             hp=hp-4;
                         }
                     }
                 }
             }
             else if(user_input==2)
             {
                 if((user_y-1)==-1)
                 {
                     System.out.println("Invalid Move!");
                 }
                 else
                 {
                      if( (board[user_x][user_y -1]=='-' && mainboard[user_x][user_y-1]=='_') || (board[user_x][user_y -1]=='.' && mainboard[user_x][user_y-1]=='.')  )
                     {
                         board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x][user_y-1]='X';
                         mainboard[user_x][user_y-1]='X';
                         user_y-=1;
                     }
                     else if(board[user_x][user_y -1]=='-' && mainboard[user_x][user_y-1]=='T')
                     {
                         board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x][user_y-1]='X';
                         mainboard[user_x][user_y-1]='X';
                         user_y-=1;
                         treasure=treasure-1;
                         System.out.println();
                         System.out.println("You found Treasure");
                     }
                      else if(board[user_x][user_y -1]=='-' && mainboard[user_x][user_y-1]=='P')
                     {
                         board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x][user_y-1]='X';
                         mainboard[user_x][user_y-1]='X';
                         user_y-=1;
                         potion=potion-1;
                         hp=hp+1;
                         System.out.println();
                         System.out.println("You found Potion");
                     }
                      else if(board[user_x][user_y -1]=='-' && mainboard[user_x][user_y-1]=='S')
                     {
                         board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x][user_y-1]='X';
                         mainboard[user_x][user_y-1]='X';
                         user_y-=1;
                         sword=sword-1;
                         swordcount=swordcount+1;
                         System.out.println();
                         System.out.println("You found sword");
                     }
                      else if(board[user_x][user_y -1]=='-' && mainboard[user_x][user_y-1]=='M')
                     {
                         board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x][user_y-1]='X';
                         mainboard[user_x][user_y-1]='X';
                         user_y-=1;
                         monster=monster-1;
                         if(swordcount>0)
                         {
                             System.out.println();
                             System.out.println("Monster Attack! You have sword");
                             swordcount=swordcount-1;
                         }
                         else
                         {
                             System.out.println();
                             System.out.println("Monster Attack! You don't have sword");
                             hp=hp-4;
                         }
                     }
                 }
             }
             else if(user_input==3)
             {
                 if((user_y+1)==8)
                 {
                     System.out.println("Invalid Move!");
                 }
                 else
                 {
                     if( (board[user_x][user_y+1]=='-' && mainboard[user_x][user_y+1]=='_') || (board[user_x][user_y+1]=='.' && mainboard[user_x][user_y+1]=='.'))
                     {
                         board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x][user_y+1]='X';
                         mainboard[user_x][user_y+1]='X';
                         user_y+=1;
                     }
                     else if(board[user_x][user_y+1]=='-' && mainboard[user_x][user_y+1]=='T')
                     {
                         board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x][user_y+1]='X';
                         mainboard[user_x][user_y+1]='X';
                         user_y+=1;
                         treasure=treasure-1;
                         System.out.println();
                         System.out.println("You found Treasure");
                     }
                     
                      else if(board[user_x][user_y+1]=='-' && mainboard[user_x][user_y+1]=='P')
                     {
                         board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x][user_y+1]='X';
                         mainboard[user_x][user_y+1]='X';
                         user_y+=1;
                         potion=potion-1;
                         hp=hp+1;
                         System.out.println();
                         System.out.println("You found Potion");
                     }
                     else if(board[user_x][user_y+1]=='-' && mainboard[user_x][user_y+1]=='S')
                     {
                         board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x][user_y+1]='X';
                         mainboard[user_x][user_y+1]='X';
                         user_y+=1;
                         sword=sword-1;
                         swordcount=swordcount+1;
                         System.out.println();
                         System.out.println("You found sword");
                     }
                      else if(board[user_x][user_y+1]=='-' && mainboard[user_x][user_y+1]=='M')
                     {
                         board[user_x][user_y]='.';
                         mainboard[user_x][user_y]='.';
                         board[user_x][user_y+1]='X';
                         mainboard[user_x][user_y+1]='X';
                         user_y+=1;
                         monster=monster-1;
                         if(swordcount>0)
                         {
                             System.out.println();
                             System.out.println("Monster Attack! You have sword");
                             swordcount=swordcount-1;
                         }
                         else
                         {
                             System.out.println();
                             System.out.println("Monster Attack! You don't have sword");
                             hp=hp-4;
                         }
                     }
                 }
             }
             else if(user_input==4)
             {
                 System.out.println("Your HP is: " + hp);
             }
             else if(user_input==5)
             {
                 System.out.println("Treasures left: " + treasure);
                 System.out.println("Monsters left: " + monster);
                 System.out.println("Sword left: " + sword);
                 System.out.println("Potion left: " + potion);   
             }
             else
             {
                 System.out.println("Invalid Input");
             }
         }while(treasure>0 && hp>0);
         
         
         if(treasure==0)
         {
             System.out.println();
             System.out.println("Game Over!You Win");
         }
         if(hp==0)
         {
             System.out.println();
             System.out.println("Game Over!You loss");
         }
    }
    
}
