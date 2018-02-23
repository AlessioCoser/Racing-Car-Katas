package tddmicroexercises.turnticketdispenser;

public class TurnNumberSequence
{
    private static int _turnNumber = 0;

    public static int getNextTurnNumber()
    {
        return _turnNumber++;
    }

    public int nextTurnNumber() {
        return TurnNumberSequence.getNextTurnNumber();
    }
}
