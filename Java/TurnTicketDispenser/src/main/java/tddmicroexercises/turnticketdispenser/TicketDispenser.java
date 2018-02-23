package tddmicroexercises.turnticketdispenser;

public class TicketDispenser
{
    public TurnTicket getTurnTicket()
    {
        int newTurnNumber = nextTurnNumber();

        return new TurnTicket(newTurnNumber);
    }

    private int nextTurnNumber() {
        return new TurnNumberSequence().nextTurnNumber();
    }
}
