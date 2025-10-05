package com.arraylistdemo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Card{
    private String rank;
    private String suit;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "("+suit+rank+")";
    }
}

public class TestPoker {
    public static ArrayList<Card> creatCards(){
        ArrayList<Card> deck = new ArrayList<>();
        String suits[] = {"♥","♠","♣","♦"};
        for (String suit : suits){
            for(int i = 2;i <= 10; i++){
                Card card = new Card(suit,""+ i);
                deck.add(card);
            }
            deck.add(new Card(suit,"J"));
            deck.add(new Card(suit,"Q"));
            deck.add(new Card(suit,"K"));
            deck.add(new Card(suit,"A"));
        }
        return deck;
    }

    public static void main(String[] args) {
        ArrayList<Card> cards = creatCards();
        System.out.println(cards);

        //进行洗牌
        Collections.shuffle(cards);
        System.out.println(cards);

        //进行发牌,假设有三个玩家 每个玩家都有5张牌
        //使用3个ArrayList来表示
        /*
        ArrayList<Card> player1 = new ArrayList<>();
        ArrayList<Card> player2 = new ArrayList<>();
        ArrayList<Card> player3 = new ArrayList<>();
        */


        //通过二维数组来构造二维的ArrayList.
        ArrayList<ArrayList<Card>> players = new ArrayList<>();
        for(int i = 0;i<3;i++){
            players.add(new ArrayList<>());
        }
        //开始发牌
        for(int round = 0 ; round < 5 ; round++){
            for (int i = 0 ; i < 3 ; i++){
                //取出牌堆中的第一张牌
                Card card = cards.remove(0);
                ArrayList<Card> player = players.get(i);
                player.add(card);

            }

        }

        //打印每个玩家的牌.
        for(int i = 0 ; i < 3 ; i++){
            ArrayList<Card> player = players.get(i);
            System.out.println("玩家" + (i + 1) + "的牌:" + player);
        }

    }
} 