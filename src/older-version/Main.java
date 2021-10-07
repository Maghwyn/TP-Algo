package com.company;

public class Main {

    public static void betterPrint(int[] tab, boolean before) {
        if(before) {
            System.out.print("Before : ");
            for(int print : tab) System.out.print(print + " ");
            System.out.print("\nAfter  : ");
        } else for(int print : tab) System.out.print(print + " ");
    }

    public static int[] sortSelection(int[] tab) {
        for(int index = 0; index <= tab.length - 1; index++) {
            for(int verify = index; verify <= tab.length - 1; verify++) {
                if(tab[verify] < tab[index]) {
                    int valueIndex = tab[index];
                    tab[index] = tab [verify];
                    tab[verify] = valueIndex;
                }
            }
        }
        return tab;
    }

    public static int[] sortInsertion(int[] tab) {
        for(int index = 1; index <= tab.length - 1; index++) {
            int range = tab[index];
            int verify;
            for(verify = index; verify > 0 && tab[verify -1] > range; verify--) {
                tab[verify] = tab[verify - 1];
            }
            tab[verify] = range;
        }
        return tab;
    }

    public static int[] sortNormalBubble(int[] tab) {
        for(int test = 0; test < tab.length; test++) {
            for (int index = 0; index <= tab.length - 2; index++) {
                if (tab[index + 1] < tab[index]) {
                    int valueIndex = tab[index];
                    tab[index] = tab[index + 1];
                    tab[index + 1] = valueIndex;
                }
            }
        }
        return tab;
    }

    public static int[] sortOptiBubble(int[] tab) {
        int exitLoop = 0;
        boolean exchange = true;
        while(exchange) {
            for (int index = 0; index <= tab.length - 2; index++) {
                if(tab[index + 1] < tab[index]) {
                    int valueIndex = tab[index];
                    tab[index] = tab[index + 1];
                    tab[index + 1] = valueIndex;
                }

                if(index <= tab.length - 3 && tab[index] < tab[index +1] && tab[index + 1] < tab[index + 2]) exitLoop++;
                else if(index == tab.length - 2 && tab[index] < tab[index +1]) exitLoop++;

                if(exitLoop == tab.length - 2) { exchange = false; break; }
            }
            exitLoop = 0;
        }
        return tab;
    }

    public static void main(String[] args) {

        int[] select       = {59, 78, 44, 90,  3, 19, 81, 62, 23};
        int[] insert       = {90, 71, 52, 17,  9, 30, 28,  1, 48};
        int[] normalBubble = {74, 31,  7,  4, 32, 46, 83, 67, 11};
        int[] optiBubble   = {74, 31,  7,  4, 32, 46, 83, 67, 11}; //int[] optiBubble = {1,2,3,4,5,7,6,8,9};

        betterPrint(select,true);
        betterPrint(sortSelection(select),false);

        betterPrint(insert, true);
        betterPrint(sortInsertion(insert),false);

        betterPrint(normalBubble,true);
        betterPrint(sortNormalBubble(normalBubble),false);

        betterPrint(optiBubble,true);
        betterPrint(sortOptiBubble(optiBubble),false);

    }
}
