package com.company;

import java.util.Arrays;

public class Main {

/*static void Permut(int tab[],int[index1],int[index2]){
    int a=tab[index1];
    tab[index1]=tab[index2];
    tab[index2]=a;
}*/
static int comptaff;
static int comptcom;
static int[] GenTab(int len){
    int[] tab=new int[len];
    for (int i = 0; i < len; i++) {
        tab[i]=(int)(Math.random()*100);
    }
    return tab;
}
static void Stat(int min,int max,int step,int nbr){
    int len=min;
    int affmeds;
    int commeds;
    int affmedi;
    int commedi;
    int affmedb;
    int commedb;
    int affmedo;
    int commedo;
    for (int i = min; i < max+1; i=i+step) {
        len=len+step;
        affmeds=0;
        commeds=0;
        affmedi=0;
        commedi=0;
        affmedb=0;
        commedb=0;
        affmedo=0;
        commedo=0;
        for (int j = 0; j < nbr; j++) {
            Selection(GenTab(len));
            affmeds=+comptaff;
            commeds=+comptcom;
            Insertion(GenTab(len));
            affmedi=+comptaff;
            commedi=+comptcom;
            Bulle(GenTab(len));
            affmedb=+comptaff;
            commedb=+comptcom;
            BulleO(GenTab(len));
            affmedo=+comptaff;
            commedo=+comptcom;
        }
        affmeds=affmeds/nbr;
        commeds=commeds/nbr;
        System.out.println("Selection "+i+" : "+affmeds+" affectation "+commeds+" comparaison ");
        affmedi=affmedi/nbr;
        commedi=commedi/nbr;
        System.out.println("Insertion "+i+" : "+affmedi+" affectation "+commedi+" comparaison ");
        affmedb=affmedb/nbr;
        commedb=commedb/nbr;
        System.out.println("Bulle "+i+" : "+affmedb+" affectation "+commedb+" comparaison ");
        affmedo=affmedo/nbr;
        commedo=commedo/nbr;
        System.out.println("Bulle opti "+i+" : "+affmedo+" affectation "+commedo+" comparaison ");
    }
}
static int[] Selection(int[]tab) {
    int min;
    comptcom=0;
    comptaff=0;
    int[] newtab=new int[tab.length];
    for (int i = 0; i < tab.length; i++) {
        min=100;
        for (int j = 0; j < tab.length; j++) {
            if (min>tab[j]) {
                min = tab[j];
                comptcom++;
            }
        }
        for (int j = 0; j < tab.length; j++) {
            if (min == tab[j]){
                tab[j]=100;
                comptcom++;
            }
        }
        newtab[i]=min;
        comptaff++;
    }
    return newtab;
}
static int[] Insertion(int[] tab){
    comptcom=0;
    comptaff=0;
    int[] newtab=new int[tab.length];
    for (int i = 0; i < tab.length; i++) {
        for (int j = 0; j < newtab.length; j++) {
            if (tab[i] < newtab[j]) {
                comptcom++;
                for (int k = tab.length - 1; k > j; k--) {
                    newtab[k] = newtab[k-1];
                    comptaff++;
                }
                newtab[j] = tab[i];
                comptaff++;
                break;
            } else {
                comptcom++;
                newtab[i] = tab[i];
                comptaff++;
            }
        }
    }
    return newtab;
}
static int[] Bulle(int[] tab){
    comptcom=0;
    comptaff=0;
    for (int i = 0; i < tab.length; i++) {
        int tag=tab[0];
        for (int j = 0; j < tab.length; j++) {
            if (tag>tab[j]){
                comptcom++;
                int sto=tab[j-1];
                comptaff++;
                tab[j-1]=tab[j];
                comptaff++;
                tab[j]=sto;
                comptaff++;
            }else{
                tag=tab[j];
                comptcom++;
            }
        }
    }
    return tab;
}
static int[] BulleO(int[] tab){
    comptcom=0;
    comptaff=0;
    int futj=0;
        for (int i = 0; i < tab.length; i++) {
            int tag=tab[futj];
            boolean fir=true;
            for (int j = futj; j < tab.length; j++) {
                if (tag>tab[j]){
                    comptcom++;
                    int sto=tab[j-1];
                    comptaff++;
                    tab[j-1]=tab[j];
                    comptaff++;
                    tab[j]=sto;
                    comptaff++;
                }else if ((tag<tab[j])&&fir){
                    comptcom++;
                    tag=tab[j];
                    futj=j-1;
                    fir=false;
                }else{
                    comptcom++;
                    tag=tab[j];
                }
            }
        }
        return tab;
    }
    public static void main(String[] args) {
        Stat(10,20,5,5);
        //System.out.println(Arrays.toString(Selection(GenTab(10))));
    }
}
