package tddmicroexercises.turnticketdispenser;

import org.junit.Test;

import static org.junit.Assert.*;

public class TicketDispenserTest {

    public static final TurnTicket FIRST_TICKET = new TurnTicket(0);
    public static final TurnTicket SECOND_TICKET = new TurnTicket(1);
    public static final TurnNumberSequence SEQUENCE = new TurnNumberSequence();

    @Test
    public void first_turn_ticket_should_be_0() {
        TicketDispenser ticketDispenser = new TicketDispenser();

        TurnTicket turnTicket = ticketDispenser.getTurnTicket();

        assertEquals(FIRST_TICKET.getTurnNumber(), turnTicket.getTurnNumber());
    }

    @Test
    public void second_turn_ticket_should_be_1() {
        TicketDispenser ticketDispenser = new TicketDispenser(SEQUENCE);

        ticketDispenser.getTurnTicket();
        TurnTicket turnTicket = ticketDispenser.getTurnTicket();

        assertEquals(SECOND_TICKET.getTurnNumber(), turnTicket.getTurnNumber());
    }
}