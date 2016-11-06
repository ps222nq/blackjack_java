package BlackJack.model.rules;

import BlackJack.model.Player;
import BlackJack.model.Card;

class SoftSeventeenStrategy implements IHitStrategy {
    private final int g_hitLimit = 17;

    public boolean DoHit(Player a_dealer) {

        boolean dealerUnderLimit = (a_dealer.CalcScore() <= g_hitLimit);
        boolean dealerHasAce;
        for(Card c : a_dealer.GetHand()){
            dealerHasAce = (c.GetValue() == c.Value.Ace);
        }

        if(dealerHasAce && dealerUnderLimit){
            return true;
        } else {
            return a_dealer.CalcScore() <= g_hitLimit;
        }
    }
}