package u3h2;

import java.util.Random;


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
         input_Jahr[i] = rand.nextInt(9000000);
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

        //Wenn das Jahr durch 4 teilbar:
        if(jahr%4 == 0) {
            schalt = true;
            //Wenn das Jahr durch 100 teilbar ist UND nicht durch 400 teilbar ist:
            if (jahr%100 == 0 && jahr%400 != 0) {
                schalt = false;
            }
            //Andernfalls, wenn das Jahr nicht durch 4 teilbar ist:
        } else {
            schalt = false;
        }

        return schalt;
    }
}



