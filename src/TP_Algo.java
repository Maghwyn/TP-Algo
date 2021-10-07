package com.company;

import java.util.Random;

public class TP_Algo {

    private static int affectation = 0;
    private static int comparison  = 0;
    private static int permutation = 0;
    private static int nbOperation = 0;
    private static int nbLoop      = 0;

    private static int random(int min, int max) {
        try {
            Random r = new Random();
            return r.nextInt((max - min) + 1) + min;
        } catch (IllegalArgumentException e) {
            System.err.println("Caught IllegalArgumentException : Your minimum is greater than the maximum.\t" + e.getMessage());
        }
        return random(min,max);
    }

    public static int[] randomTab(int length) {
        int[] tab = new int[length];
        for (int max = 0; max < length; max++) {
            tab[max] = random(1,100);
        }
        return tab;
    }

    public static void displayTab(int[] tab, boolean beforeSorting) {
        if(beforeSorting) {
            System.out.print("Before : ");
            for(int print : tab) System.out.print(print + " ");
        } else {
            System.out.print("\nAfter  : ");
            for(int print : tab) System.out.print(print + " ");
        }
    }

    public static void finalPrint(int[] tab, int sortMethod) {
        displayTab(tab, true);

        if     (sortMethod == 1) displayTab(sortSelection(tab)   , false);
        else if(sortMethod == 2) displayTab(sortInsertion(tab)   , false);
        else if(sortMethod == 3) displayTab(sortNormalBubble(tab), false);
        else if(sortMethod == 4) displayTab(sortOptiBubble(tab)  , false);

        System.out.println("\nAffectation : " + affectation + "\t||\t Comparison : " + comparison + "\t||\t Permutation : " + permutation);
        System.out.println("-> Total number of operations : " + nbOperation + "\nExtra -> Total number of loop : " + nbLoop + "\n");
    }

    public static int[] sortSelection(int[] tab) {
        affectation++;
        for(int index = 0; index <= tab.length - 1; index++) {
            affectation++; nbLoop++;
            for(int verify = index + 1; verify <= tab.length - 1; verify++) {
                affectation = affectation + 2; nbLoop++;
                if(tab[verify] < tab[index]) {
                    int valueIndex = tab[index];
                    tab[index] = tab [verify];
                    tab[verify] = valueIndex;
                    comparison++; permutation++;
                }
            }
        }
        nbOperation = affectation + comparison + (permutation*3);
        return tab;
    }

    public static int[] sortInsertion(int[] tab) {
        affectation++;
        for(int index = 1; index <= tab.length - 1; index++) {
            int range = tab[index];
            int verify;
            affectation = affectation + 2; nbLoop++;
            for(verify = index; verify > 0 && tab[verify -1] > range; verify--) {
                tab[verify] = tab[verify - 1];
                affectation = affectation + 3; nbLoop++;
            }
            tab[verify] = range;
            affectation++;
        }
        nbOperation = affectation;
        return tab;
    }

    public static int[] sortNormalBubble(int[] tab) {
        affectation = affectation + 2;
        for(int index = 0; index < tab.length; index++) {
            affectation++; nbLoop++;
            for (int verify = 0; verify <= tab.length - 2; verify++) {
                affectation++; nbLoop++;
                if (tab[verify + 1] < tab[verify]) {
                    int valueIndex = tab[verify];
                    tab[verify] = tab[verify + 1];
                    tab[verify + 1] = valueIndex;
                    comparison++; permutation++;
                }
            }
        }
        nbOperation = affectation + comparison + (permutation*3);
        return tab;
    }

    public static int[] sortOptiBubble(int[] tab) {
        int exitLoop = 0;
        boolean exchange = true;
        affectation = affectation + 3;
        while(exchange) {
            nbLoop++;
            for (int index = 0; index <= tab.length - 2; index++) {
                if(tab[index + 1] < tab[index]) {
                    int valueIndex = tab[index];
                    tab[index] = tab[index + 1];
                    tab[index + 1] = valueIndex;
                    comparison++; permutation++;
                }
                nbLoop++;

                if(index <= tab.length - 3 && tab[index] <= tab[index +1] && tab[index + 1] <= tab[index + 2]) {
                    exitLoop++;
                    comparison = comparison + 3; affectation++;
                } else if(index == tab.length - 2 && tab[index] <= tab[index +1]) {
                    exitLoop++;
                    comparison = comparison + 2; affectation++;
                }

                if(exitLoop == tab.length - 2) {
                    exchange = false; break;
                }
            }
            exitLoop = 0;
            affectation++;
        }
        comparison++; //exitLoop == tab.length - 2
        affectation++; //permutation = false;
        nbOperation = affectation + comparison + (permutation*3);
        return tab;
    }

    public static void bestWorst(int sortMethod) throws Exception {
        if (sortMethod <= 0 || sortMethod > 4) throw new Exception("IllegalArgumentException : Sort method " + sortMethod + " doesn't exist.");

        String bestWorst;
        int[] best  = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] worst = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] which;

        for(int compare = 0; compare <= 1; compare++) {

            float sum = 0f;
            int length;

            if(compare == 0) { length = best.length;  which = best;  bestWorst = "BEST";  }
            else             { length = worst.length; which = worst; bestWorst = "WORST"; }

            System.out.println(bestWorst + " for table length of " + length);

            finalPrint(which, sortMethod);
            sum = sum + nbOperation;
            affectation = 0; comparison = 0; permutation = 0; nbOperation = 0; nbLoop = 0;

            float average = sum / length;
            System.out.println("Average for the table of " + bestWorst + " : " + average + "\n");
        }
    }

    public static void stat (int min, int max, int step, int nbr, int sortMethod) throws Exception {
        if(sortMethod <= 0 || sortMethod > 4) throw new Exception("IllegalArgumentException : Sort method " + sortMethod + " doesn't exist.");

        while (min <= max) {
            float sum = 0f;
            System.out.println("------------------------ START " + min + " ------------------------\n");
            for(int repeat = 1; repeat <= nbr; repeat++) {
                System.out.println("Table length : " + min + "\t||\t Iteration : " + repeat);

                int[] tab = randomTab(min);
                finalPrint(tab,sortMethod);
                sum = sum + nbOperation;
                affectation = 0; comparison = 0; permutation = 0; nbOperation = 0; nbLoop = 0;
            }
            System.out.println("------------------------  END " + min + "  ------------------------\n");
            float average = sum/nbr;
            System.out.println("Average for the table of " + min + " : " + average + "\n");
            min = min + step;
        }
    }

    public static void main(String[] args) throws Exception {

        // sortMethod 1 = sortSelection.
        // sortMethod 2 = sortInsertion.
        // sortMethod 3 = sortNormalBubble.
        // sortMethod 4 = sortOptiBubble.
        //bestWorst(1);
        stat(10,20,5,10,1);
    }
}
