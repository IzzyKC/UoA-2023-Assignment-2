package industry.assignment02.role;

import industry.assignment02.game.Result;

import java.util.List;
import java.util.stream.Collectors;

public class MediumAI extends Computer {
    /**
     * constructor of MediumAI
     *
     * @param aiLevel computer AI Level
     */
    public MediumAI(AILevel aiLevel) {
        setAiLevel(aiLevel);
    }

    /**
     * MediumAI guesses player's secret with MediumAI guess strategy
     * The AI will not make the same guess twice.
     *
     * @return computer's random guess
     */
    @Override
    public String guessPlayerCode() {
        String randomGuess;
        do {
            randomGuess = genRandomCode(4, false);
        } while (isRepeatGuess(randomGuess));
        return randomGuess;
    }

    /**
     * checks if next guess already exists
     *
     * @param guess next guess code
     * @return is next guess already exists
     */
    private boolean isRepeatGuess(String guess) {
        List<Result> repeatGuess = getGuessResults().stream()
                .filter(result -> result.getGuess().equals(guess))
                .collect(Collectors.toList());
        return repeatGuess.size() > 0;
    }
}
