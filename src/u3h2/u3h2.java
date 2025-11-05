package u3h2;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class u3h2 {

    //Übung 3 Aufgabe 2
    static int testläufe = 100;
    static int[] input_Jahr = new int[testläufe];
    static boolean[] input_Schalt = new boolean[testläufe];


    static boolean[][] results = new boolean[testläufe][3];

    public static void main(String[] args) {
        inputGen();

        for (int i = 0; i < testläufe; i++){
            results[i][0] = thomasCode(input_Jahr[i],input_Schalt[i]);
            results[i][1] = andreasCode(input_Jahr[i],input_Schalt[i]);
            results[i][2] = müllCode(input_Jahr[i],input_Schalt[i]);
        }

        for (int i = 0; i < testläufe; i++){

            if ((results[i][0] != results[i][1]) || (results[i][0] != results[i][2])){

                System.out.println();
                System.out.println("FEHLER");
            }


            /*
            System.out.print(results[i][0] +" | ");
            System.out.print(results[i][1] +" | ");
            System.out.print(results[i][2]);
            System.out.println();
            */

        }
        System.out.println("Ende");
}

 static void inputGen(){
     Random rand = new Random();
     for (int i = 0; i < testläufe; i++){
         input_Jahr[i] = rand.nextInt(90000);
         input_Schalt[i] = rand.nextBoolean();
     }
    }


    //Test Methoden


    static boolean thomasCode(int in_Jahr, boolean in_Schalt){

        int jahr = in_Jahr;
        boolean schalt = in_Schalt;

        schalt = false;

        if (jahr % 4 == 0 && jahr % 100 != 0){
            schalt = true;
        }
        if (jahr % 4 == 0 && jahr % 400 == 0){
            schalt = true;
        }

        return schalt;


    }

    static boolean andreasCode(int in_Jahr, boolean in_Schalt){

        int jahr = in_Jahr;
        boolean schalt = in_Schalt;


        schalt = ((jahr % 4 == 0) && !(jahr % 100 == 0)) || (jahr % 400 == 0);


        return schalt;


    }
    static boolean müllCode(int in_Jahr, boolean in_Schalt){

        int jahr = in_Jahr;
        boolean schalt = in_Schalt;

        int a = 4;
        int b = 400;
        int c = 100;

        // Zu prüfen: jahr sollte durch 4 und durch 400 teilbar sein aber nicht durch 100

        if (jahr % a == 0 && jahr % c != 0 || jahr % b == 0) {schalt = true;} else {schalt = false;}


        return schalt;
    }
}



