package magic;

import java.util.Scanner;

public class Magic {
    private int chosenOne;
    private int count;
    
    
    public boolean unique(int[][] tab){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    for(int l = 0; l < 4; l++){
                        if(i == k && j == l)
                            continue;
                          if(tab[i][j] == tab[k][l]){
                              return false;
                          }
                    }          
                }
            }
        }              
        return true;
    }
    public int oneDeal(){
       int[][] cards = new int[4][4];
       int[] row = new int[4];
       int chosenRow;
       boolean wrongRange, unique;
       count = 0;
       Scanner getNumber = new Scanner(System.in);
       
       chosenRow = getNumber.nextInt() - 1; //tablice numerowane od 0
       
        while((chosenRow + 1) < 1 || (chosenRow + 1) > 4){
             System.out.println("Nr wiersza musi być z zakresu: <1 : 4>");
             chosenRow = getNumber.nextInt();
        }
       
       //Pierwsze rozdanie kart
       do{ 
           wrongRange = false;
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    cards[i][j] = getNumber.nextInt();
                     if(cards[i][j]< 1 || cards[i][j] > 16){
                      wrongRange = true;
                     }
                    if(chosenRow == i && !wrongRange){
                        row[j] = cards[i][j];
                    }
                }
            }   
                if(wrongRange)
                 System.out.println("Nr karty musi być z zakresu: <1 : 16>. Powtórz rozdanie");
                if(!(unique = unique(cards)))
                 System.out.println("Karty nie mogą się powtarzać. Powtórz rozdanie");
        }
       while(wrongRange || !unique);
       
       
       chosenRow = getNumber.nextInt() - 1;
        
        while((chosenRow + 1) < 1 || (chosenRow + 1) > 4){
             System.out.println("Nr wiersza musi być z zakresu: <1 : 4>");
             chosenRow = getNumber.nextInt();
        }
       
       
       //Drugie rozdanie kart
        do{
           wrongRange = false;
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    cards[i][j] = getNumber.nextInt();
                    if(cards[i][j]< 1 || cards[i][j] > 16)
                      wrongRange = true;
                    if(chosenRow == i && !wrongRange)
                       for(int k = 0; k < 4; k++)
                          if(row[j] == cards[i][k]){
                              count++;  
                              if(count == 1)
                                  chosenOne = row[j];
                              else
                                  chosenOne = 0;
                          }
                                          
                    }
             }
             if(wrongRange)
                 System.out.println("Nr karty musi być z zakresu: <1 : 16>. Powtórz rozdanie");
              if(!(unique = unique(cards)))
                 System.out.println("Karty nie mogą się powtarzać. Powtórz rozdanie");
        }
       while(wrongRange || !unique);
        
       return chosenOne;
    }
    private void showInfo(int numberOfDeal) {
        String string = null;
        
        int number;
        switch(count){
            case 0: string = "Ochotnik oszukiwał!"; 
                    System.out.println("Przypadek #" + numberOfDeal +": " + string );
                break;
            case 1:  number = chosenOne;
                     System.out.println("Przypadek #" + numberOfDeal +": " + number );
                break;
            default: string = "Kiepski magik!";
                     System.out.println("Przypadek #" + numberOfDeal +": " + string );
                break;
                
        }
        
        
    }
    public void dealLooper(){
        int numberOfCases, i = 0;
        Scanner getNumber = new Scanner(System.in);
        numberOfCases = getNumber.nextInt();
        
        while(numberOfCases < 1 || numberOfCases > 100){
             System.out.println("Liczba przypadków testowych musi być z zakresu: <1 : 100>");
             numberOfCases = getNumber.nextInt();
        }
       
        while(i < numberOfCases){
            oneDeal();
            showInfo(i + 1);
            i++;
        
    }
    }
    
    public static void main(String[] args) {
        Magic magic = new Magic();
        magic.dealLooper();
        
           }
    
    
       }
        
      
  
