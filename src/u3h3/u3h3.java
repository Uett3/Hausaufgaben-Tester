package u3h3;

import java.util.Random;


public class u3h3 {

    static int testläufe = 10;
    static int[] input_max = new int[testläufe];
    static int[] input_fix = new int[testläufe];
    static int[] input_wartend = new int[testläufe];
    static boolean[] input_istVoll = new boolean[testläufe];

    static int output_max = 0;
    static int output_fix = 0;
    static int output_wartend = 0;
    static boolean output_istVoll = false;

    static int test_max = 0;
    static int test_fix = 0;
    static int test_wartend = 0;
    static boolean test_istVoll = false;

    public static void main(String[] args) {
        inputGen();

        for (int i = 0; i<testläufe; i++){
            controll_code(input_max[i],input_fix[i],input_wartend[i],input_istVoll[i] );
            test_code( input_max[i],input_fix[i],input_wartend[i],input_istVoll[i] );

            if(output_max != test_max){
                System.out.println("FEHLER bei max");
            }
            if(output_fix != test_fix){
                System.out.println("FEHLER bei fix");
            }
            if(output_wartend != test_wartend) {
                System.out.println("FEHLER bei wartend");
            }
            if(output_istVoll != test_istVoll){
                System.out.println("FEHLER bei istVoll");
            }


        }
        System.out.println("Alles Super");
    }


    static void inputGen() {

        Random rand = new Random();
        for (int i = 0; i < testläufe; i++){
            input_max[i] = rand.nextInt(9000000);

            input_fix[i] = rand.nextInt(input_max[i] + 1); // fix should not be greater than max
            input_wartend[i] = rand.nextInt(9000000);
            input_istVoll[i] = rand.nextBoolean();

        }

    }


    static void controll_code(int i_max, int i_fix, int i_wartend, boolean i_istVoll){
        int max = i_max;
        int fix = i_fix;
        int wartend = i_wartend;
        boolean istVoll = i_istVoll;


        int freiePlätze = max - fix;

        istVoll = false;
        if (fix < max){

            if(wartend < freiePlätze){
                fix += wartend;
                wartend = 0;
            }else{
                fix += freiePlätze;
                wartend -= freiePlätze;
                istVoll = true;
            }

        } else {
            istVoll = true;
        }

        output_fix = fix;
        output_istVoll = istVoll;
        output_wartend = wartend;
        output_max = max;


    }

    static void test_code(int i_max, int i_fix, int i_wartend, boolean i_istVoll){
        int max = i_max;
        int fix = i_fix;
        int wartend = i_wartend;
        boolean istVoll = i_istVoll;




        istVoll = false;

        int frei = max - fix;
        if (wartend < frei) {
            fix += wartend;
            wartend = 0;
            istVoll = false;
        } else if (wartend == frei) {
            fix = max;
            wartend = 0;
            istVoll = true;
        } else { // wartend > frei
            fix = max;
            wartend -= frei;
            istVoll = true;
        }


        test_fix = fix;
        test_istVoll = istVoll;
        test_wartend = wartend;
        test_max = max;


    }
}