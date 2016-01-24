import java.util.Scanner;
import java.util.Vector;

public class Magic {
    static int chosenOne;
    static int count;

    public static int oneDeal(){
       int chosenRow;
       count = 0;

       Vector<Integer> vector = new Vector<>();
       Integer number;
       Scanner getNumber = new Scanner(System.in);
       chosenRow = getNumber.nextInt() - 1;
        //Pierwsze rozdanie kart
        for(int i = 0; i < 16; i++){
            number = getNumber.nextInt();
            if(i >= (chosenRow * 4) && i <= (chosenRow * 4) + 3)
             vector.add(number);
        }
        chosenRow = getNumber.nextInt() - 1;
        int j = 0;
       //Drugie rozdanie kart
        for(int i = 0; i < 16; i++){
            number = getNumber.nextInt();
            if(i >= (chosenRow * 4) && i <= (chosenRow * 4) + 3 ){
                if(vector.get(j) == number)
                {
                    count++;
                    if(count == 1)
                        chosenOne = number;
                    else
                        chosenOne = 0;
                }
                j++;
            }
        }
        return chosenOne;
    }
    private static void showInfo(int numberOfDeal) {
        String string;
        int number = chosenOne;
        switch(count){
            case 0: string = "Ochotnik oszukiwał!"; 
                    System.out.println("Przypadek #" + numberOfDeal +": " + string );
                break;
            case 1:
                     System.out.println("Przypadek #" + numberOfDeal +": " + number );
                break;
            default: string = "Kiepski magik!";
                     System.out.println("Przypadek #" + numberOfDeal +": " + string );
                break;
        }
    }
   private static void dealLooper(){
        int numberOfCases, i = 0;
        Scanner getNumber = new Scanner(System.in);
        numberOfCases = getNumber.nextInt();

        while(i < numberOfCases){
            oneDeal();
            showInfo(i + 1);
            i++;
    }
    }
    public static void main(String[] args) {
                dealLooper();
           }
       }
        
      
  