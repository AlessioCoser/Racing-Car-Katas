package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.*;
import static org.junit.Assert.*;

public class TestAlarm {

    @Test
    public void is_off_after_initialization() {
        Alarm alarm = new Alarm();
        assertEquals(false, alarm.isAlarmOn());
    }

    @Test
    public void is_off_when_pressure_within_threshold() {
        Alarm alarm = new TestableAlarm();

        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

    private class TestableAlarm extends Alarm {
        @Override
        protected double pressureValue() {
            return 18;
        }
    }
}
