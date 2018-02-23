package tddmicroexercises.tirepressuremonitoringsystem;


import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestAlarm {

    @Mock Sensor sensor;

    @Test
    public void is_off_after_initialization() {
        Alarm alarm = new Alarm();
        assertEquals(false, alarm.isAlarmOn());
    }

    @Test
    public void is_off_when_pressure_within_threshold() {
        when(sensor.popNextPressurePsiValue()).thenReturn((double) 18);
        Alarm alarm = new Alarm(sensor);

        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void is_on_when_pressure_is_out_threshold() {
        when(sensor.popNextPressurePsiValue()).thenReturn((double) 0);
        Alarm alarm = new Alarm(sensor);

        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }
}
