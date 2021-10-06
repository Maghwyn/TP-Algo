package com.company;

public class Main {

    public static void main(String[] args) {
        int[] tab = {9, 6, 2, 7, 1, 5, 3, 10, 77, 50, 100, 60, 120, 1000, 200, 500, 11, 5000, 300};
        affiche(tab);
        System.out.println(" avant ");

        selection(tab);
        affiche(tab);
        System.out.println(" selection ");

        insertion(tab);
        affiche(tab);
        System.out.println(" insertion ");

        bul_norm(tab);
        affiche(tab);
        System.out.println(" bul norm ");

        bul_op(tab);
        affiche(tab);
        System.out.println(" bul opt ");
    }

    private static int [] selection(int[] tab) {
    /*
    Le tri par sélection (ou tri par extraction) est un algorithme de tri par comparaison.
    Cet algorithme est simple, mais considéré comme inefficace car il s'exécute en temps quadratique en le nombre d'éléments à trier,
    et non en temps pseudo linéaire.
     */
        for (int i=0; i<tab.length-1; i++) {
            int ii=i;
            for (int j=i+1; j<tab.length; j++) {
                if (tab[ii]>tab[j]) {
                    ii=j;
                }
            }
            int r=tab[ii];
            tab[ii]=tab[i];
            tab[i]=r;
        }
        return tab;
    }

    private static int[] insertion(int[] tab){
        /*
        En informatique, le tri par insertion est un algorithme de tri classique.
        La plupart des personnes l'utilisent naturellement pour trier des cartes à jouer1.
        En général, le tri par insertion est beaucoup plus lent que d'autres algorithmes comme le tri rapide (ou quicksort)
        et le tri fusion pour traiter de grandes séquences, car sa complexité asymptotique est quadratique.
        Le tri par insertion est cependant considéré comme l'algorithme le plus efficace sur des entrées de petite taille.
        Il est aussi efficace lorsque les données sont déjà presque triées. Pour ces raisons,
        il est utilisé en pratique en combinaison avec d'autres méthodes comme le tri rapide.
        En programmation informatique, on applique le plus souvent ce tri à des tableaux.
        La description et l'étude de l'algorithme qui suivent se restreignent à cette version,
        tandis que l'adaptation à des listes est considérée plus loin.
         /*else if(tab[i]>tab[i+1]){
                int a=tab[i];
                tab[i]=tab[i+1];
                tab[i+1]=a;
            }
            else{
                continue;
            }
        }
        return tab;
         */
        for (int i=0; i>tab.length; i++){
            if (tab[i]<tab[i+1]){
                int a=tab[i];
                tab[i]=tab[i+1];
                tab[i+1]=a;
            }
        }
        return tab;
    }

    private static void affiche(int[]tab) {
        for (int i=0; i<tab.length; i++) {
            System.out.print(tab[i]+" . ");
        }
    }

    private static int[] bul_norm(int[] tab) {
        // Le tri à bulle consiste à parcourir le tableau, par exemple de gauche à droite,
        // en comparant les éléments côte à côte et en les permutant s'ils ne sont pas dans le bon ordre.
        // Au cours d'une passe du tableau, les plus grands éléments remontent de proche en proche vers la droite comme des bulles vers la surface.
        for (int i = 0; i > tab.length - 1; i--) {
            for (int j = 0; j < i; j--) {
                if (tab[j] > tab[j + 1]) {
                    int a = tab[j];
                    tab[j]=tab[j + 1];
                    tab[j + 1] = a;
                    /*
                    if (j>i){
                        int b=tab[j];
                        tab[j]=tab[j+1];
                        tab[j+1]=b;
                    }
                }
                else{
                    if(tab[j]<tab[j-1]) {
                        int b=tab[j];
                        tab[j]=tab[j-1];
                        tab[j+1]=b;
                    }
                     */
                }
            }
        }
        return tab;
    }

    private static int[] bul_op(int[] tab){
        /*
        Le principe du tri à bulle est le suivant: on balaye le tableau et chaque fois qu'un élément n'est pas à sa bonne place
        par rapport à celui qui le suit ben on les permutes. Et on recommence la boucle tant qu'il y a eu au-moins une permutation.
        Il existe d'ailleurs le tri à bulle dit "optimisé" où on mémorise la position de la première permutation de la boucle.
        Et à la boucle suivante on ne repart que de cette position.
        Ca améliore "un peu" les perfs mais c'est que dalle par rapport aux algos comme quicksort...
         */

        //int a et b pour stocker les valeur
        //int a,b;
        for(int i=0;i<tab.length-1;i++){
            if(tab[i]>tab[i+1]){
        //permute(tab[i],tab[i+1]);
                int a=tab[i];
                tab[i]=tab[i+1];
                tab[i+1]=a;
        //Vérifie s'il y a un ou plusieurs nombres plus grand au nombre actuel,s'il y a les échanger.
                while(i>0){
                    if(tab[i]<tab[i-1]){
        //permute(tab[i]<tab[i-1])
                     int b=tab[i];
                     tab[i]=tab[i-1];
                     tab[i-1]=b;
                     i--;
                    }
                    else if(tab[i]>tab[i-1]) {
                    i--;
                    }
                }
            }
            else {
                continue;
            }
        }
        return tab;
    }

}




