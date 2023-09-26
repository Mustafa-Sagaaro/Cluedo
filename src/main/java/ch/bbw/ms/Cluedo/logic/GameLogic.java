package ch.bbw.ms.Cluedo.logic;

import ch.bbw.ms.Cluedo.model.Crime;

public class GameLogic {

    private int history = 0;

    public boolean evaluateSuggestion(Crime suggestion, Crime secret,
                                      int numberOfSuggestion, int maxNumberOfSuggestions) {
        int matches = 0;

        if(suggestion.getTaeter().equals(secret.getTaeter())) {
            matches++;
        }
        if(suggestion.getTatwaffe().equals(secret.getTatwaffe())) {
            matches++;
        }
        if(suggestion.getTatort().equals(secret.getTatort())) {
            matches++;
        }

        history = matches;

        if(matches == 3) {
            return true;
        }

        if(numberOfSuggestion >= maxNumberOfSuggestions) {
            history = -1;
            return false;
        }

        return false;
    }

    public int getHistory() {
        return history;
    }
}
