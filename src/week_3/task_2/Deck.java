package week_3.task_2;

import java.util.Random;

/**
 * Created by it170692gda on 10.03.17.
 */
public class Deck {

    public static Card deck[] = new Card[36];

    public Deck(){  //создаём и помещаем карты в колоду (в массив)
        int c = 0;
        for (int i = 0; i < Rank.values.length; i++){
            for (int j =0; j < Suit.values.length; j++){
                deck[c] = new Card(Rank.values[i], Suit.values[j]);
                c++;
            }
        }
    }

    public static void main(String[] args) {
        Deck main = new Deck();
        for (int i = 0; i < deck.length; i++){
            System.out.println(deck[i]);
            //System.out.println((int)(Math.random()*deck.length));
        }
        System.out.println("shuffle");
        main.shuffle();
        for (int i = 0; i < deck.length; i++){
            System.out.println(deck[i]);
        }
        System.out.println("order");
        main.order();
        for (int i = 0; i < deck.length; i++){
            System.out.println(deck[i]);
        }
        main.shuffle();
        System.out.println("order");
        main.order();
        for (int i = 0; i < deck.length; i++){
            System.out.println(deck[i]);
        }
    }

    //Перемішує колоду у випадковому порядку
    public void shuffle() {
        for (int i = 0; i < deck.length; i++){
            int randomIndex = (int)(Math.random()*deck.length);
            Card tmp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = tmp;
        }
    }

    /* Впорядкування колоди за мастями та значеннями
    * Порядок сотрування:
    * Спочатку всі карти з мастю HEARTS, потім DIAMONDS, CLUBS, SPADES
    * для кожної масті порядок наступний: Ace,King,Queen,Jack,10,9,8,7,6
    * Наприклад
    * HEARTS Ace
    * HEARTS King
    * HEARTS Queen
    * HEARTS Jack
    * HEARTS 10
    * HEARTS 9
    * HEARTS 8
    * HEARTS 7
    * HEARTS 6
    * І так далі для DIAMONDS, CLUBS, SPADES */

    public void order() {
        Card HEARTS[] = new Card[9];
        Card DIAMONDS[] = new Card[9];
        Card CLUBS[] = new Card[9];
        Card SPADES[] = new Card[9];
        for (int i = 0; i < deck.length; i++){
            if(deck[i].getSuit().equals(Suit.HEARTS.getName())){
                int indexHEARTS = 0;
                HEARTS[indexHEARTS] = deck[i];
                /*
                Card tmp = deck[indexHEARTS];
                deck[indexHEARTS] = deck[i];
                deck[i] = tmp;
                */
                indexHEARTS ++;
            } else if(deck[i].getSuit().equals(Suit.DIAMONDS.getName())) {
                int indexDIAMONDS = 0;
                DIAMONDS[indexDIAMONDS] = deck[i];
                indexDIAMONDS ++;
            } else if(deck[i].getSuit().equals(Suit.CLUBS.getName())) {
                int indexCLUBS = 0;
                CLUBS[indexCLUBS] = deck[i];
                indexCLUBS ++;
            } else if(deck[i].getSuit().equals(Suit.SPADES.getName())) {
                int indexSPADES = 0;
                SPADES[indexSPADES] = deck[i];
                indexSPADES ++;
            }
        }
        finalOrder(HEARTS);
        finalOrder(DIAMONDS);
        finalOrder(CLUBS);
        finalOrder(SPADES);
    }
    public int count = 0;
    public void finalOrder(Card cards[]){
        Card tmp[] = new Card[9];
        for (int i = 0; i < cards.length; i ++){
            if (cards[i].equals(Rank.ACE.getName())){
                tmp[0] = cards[i];
            } else if (cards[i].equals(Rank.KING.getName())){
                tmp[1] = cards[i];
            } else if (cards[i].equals(Rank.QUEEN.getName())){
                tmp[2] = cards[i];
            } else if (cards[i].equals(Rank.JACK.getName())){
                tmp[3] = cards[i];
            } else if (cards[i].equals(Rank.TEN.getName())){
                tmp[4] = cards[i];
            } else if (cards[i].equals(Rank.NINE.getName())) {
                tmp[5] = cards[i];
            } else if (cards[i].equals(Rank.EIGHT.getName())) {
                tmp[6] = cards[i];
            } else if (cards[i].equals(Rank.SEVEN.getName())) {
                tmp[7] = cards[i];
            } else if (cards[i].equals(Rank.SIX.getName())) {
                tmp[8] = cards[i];
            }
        }
        for (int i = 0; i < tmp.length; i ++){
            deck[count] = tmp[i];
            count ++;
        }
    }
/*
    //Повертає true у випадку коли в колоді ще доступні карти
    public boolean hasNext() {

    }
*/
    //"Виймає" одну карту з колоди, коли буде видано всі 36 карт повертає null
    //Карти виймаються з "вершини" колоди. Наприклад перший виклик видасть SPADES 6 потім
    //SPADES 7, ..., CLUBS 6, ..., CLUBS Ace і так далі до HEARTS Ace
    /*
    public Card drawmain() {

    }
    */
}
