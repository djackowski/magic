import java.util.Scanner;
import java.util.Vector;

public class Magic {
    static int chosenOne;
    static int countNumbersInRow;

    public static int oneDeal() {
        int chosenRow;
        countNumbersInRow = 0;

        Vector<Integer> vector = new Vector<>();
        Integer number;
        Scanner getNumber = new Scanner(System.in);
        chosenRow = getNumber.nextInt() - 1;
        //Pierwsze rozdanie kart
        for (int i = 0; i < 16; i++) {
            number = getNumber.nextInt();
            if (i >= (chosenRow * 4) && i <= (chosenRow * 4) + 3)
                vector.add(number);
        }
        chosenRow = getNumber.nextInt() - 1;
        //Drugie rozdanie kart
        for (int i = 0; i < 16; i++) {
            number = getNumber.nextInt();
            if (i >= (chosenRow * 4) && i <= (chosenRow * 4) + 3) {
                if (vector.contains(number)) {
                    countNumbersInRow++;
                    if (countNumbersInRow == 1)
                        chosenOne = number;
                    else
                        chosenOne = 0;
                }

            }
        }
        return chosenOne;
    }

    private static void showInfo(int numberOfDeal) {
        String string;
        switch (countNumbersInRow) {
            case 0:
                string = "Ochotnik oszukiwał!";
                System.out.println("Przypadek #" + numberOfDeal + ": " + string);
                break;
            case 1:
                System.out.println("Przypadek #" + numberOfDeal + ": " + chosenOne);
                break;
            default:
                string = "Kiepski magik!";
                System.out.println("Przypadek #" + numberOfDeal + ": " + string);
                break;
        }
    }

    private static void dealLooper() {
        int numberOfCases, i = 0;
        Scanner getNumber = new Scanner(System.in);
        numberOfCases = getNumber.nextInt();

        while (i < numberOfCases) {
            oneDeal();
            showInfo(i + 1);
            i++;
        }
    }

    public static void main(String[] args) {
        dealLooper();
    }
}
        
      
  