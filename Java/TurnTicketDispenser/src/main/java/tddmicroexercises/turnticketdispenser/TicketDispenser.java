package tddmicroexercises.turnticketdispenser;

public class TicketDispenser
{

    private TurnNumberSequence turnNumberSequence;

    public TicketDispenser(TurnNumberSequence turnNumberSequence) {
        this.turnNumberSequence = turnNumberSequence;
    }

    public TicketDispenser() {
        this(new TurnNumberSequence());
    }

    public TurnTicket getTurnTicket()
    {
        int newTurnNumber = nextTurnNumber();

        return new TurnTicket(newTurnNumber);
    }

    private int nextTurnNumber() {
        return turnNumberSequence.nextTurnNumber();
    }
}
