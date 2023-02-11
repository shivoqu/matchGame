package comp208.budiakov;

import android.os.Handler;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import comp208.budiakov.Card;

public class Game {
    private final Card[] cards;
    public long start;
    private int numPairsFound;
    public int score;
    public int attempts;
    private Card firstCard;

    public Game(ImageView[] imageViews) {
//        instantiate an array of images from the drawable folder
        int[] cardImages = { R.drawable.car, R.drawable.dragon, R.drawable.forsaken, R.drawable.oni, R.drawable.reaver, R.drawable.rift };
        cards = new Card[12];
        firstCard = null;
        attempts = 0;
//        create a list of id's to shuffle the deck later
        List<Integer> cardImageIds = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            cardImageIds.add(cardImages[i]);
            cardImageIds.add(cardImages[i]);
        }
//        mix-mix-mix
        Collections.shuffle(cardImageIds);

//        creating card objects for every card
        for (int i = 0; i < 12; i++) {
            cards[i] = new Card(cardImageIds.get(i), imageViews[i]);
        }
        start = 0;
        numPairsFound = 0;
        score = 1000;
    }

    public void onCardClicked(Card card) {
//        setting up the timer when the user first clicks the card
        if(start == 0)
            start = System.currentTimeMillis();
//        show the card
        card.turnFaceUp();
//        check if there is another card turn face up rn to compare them
        if (firstCard == null) {
            firstCard = card;
        } else {
            if (checkForMatch(firstCard, card)) {
//                if matched, reset the first card reference and check if all matches have been found to finish the game
                firstCard = null;
                if(isFinished())
                    System.out.println("Finished in " + attempts + " attempts");
            } else {
//                turn both cards face down after a short delay if not matched
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        firstCard.turnFaceDown();
                        card.turnFaceDown();
                        firstCard = null;
                    }
                }, 1000);
            }
        }
    }

    private boolean checkForMatch(Card firstCard, Card secondCard) {
        attempts++;
        if (firstCard.getImageId() == secondCard.getImageId()) {
            numPairsFound++;
            return true;
        } else {
            return false;
        }
    }

    public boolean isFinished() {
        return numPairsFound == 6;
    }

    public Card[] getCards() {
        return cards;
    }
}