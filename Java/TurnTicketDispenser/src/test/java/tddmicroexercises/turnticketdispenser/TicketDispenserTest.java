package tddmicroexercises.turnticketdispenser;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketDispenserTest {

    public static final TurnTicket FIRST_TICKET = new TurnTicket(0);
    public static final TurnTicket SECOND_TICKET = new TurnTicket(1);
    private TicketDispenser ticketDispenser;

    @Before
    public void setUp() throws Exception {
        ticketDispenser = new TicketDispenser(new FakeTurnNumberSequence());
    }

    @Test
    public void first_turn_ticket_should_be_0() {
        TurnTicket turnTicket = ticketDispenser.getTurnTicket();

        assertEquals(FIRST_TICKET.getTurnNumber(), turnTicket.getTurnNumber());
    }

    @Test
    public void second_turn_ticket_should_be_1() {
        ticketDispenser.getTurnTicket();
        TurnTicket turnTicket = ticketDispenser.getTurnTicket();

        assertEquals(SECOND_TICKET.getTurnNumber(), turnTicket.getTurnNumber());
    }

    private static class FakeTurnNumberSequence extends TurnNumberSequence {
        private int number = 0;

        @Override
        public int nextTurnNumber() {
            int current = number;
            number++;

            return current;
        }
    }
}