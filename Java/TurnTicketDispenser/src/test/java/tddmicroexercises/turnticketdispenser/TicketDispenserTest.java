package tddmicroexercises.turnticketdispenser;

import org.junit.Test;

import static org.junit.Assert.*;

public class TicketDispenserTest {
    @Test
    public void first_turn_ticket_should_be_0() {
        TurnTicket expected = new TurnTicket(0);
        TicketDispenser ticketDispenser = new TicketDispenser();

        TurnTicket turnTicket = ticketDispenser.getTurnTicket();

        assertEquals(expected.getTurnNumber(), turnTicket.getTurnNumber());
    }
}