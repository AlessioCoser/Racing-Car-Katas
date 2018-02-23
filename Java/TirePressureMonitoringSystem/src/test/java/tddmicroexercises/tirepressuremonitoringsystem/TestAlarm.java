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
        Sensor sensor = new SensorWithPressure18();
        Alarm alarm = new Alarm(sensor);

        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void is_on_when_pressure_is_out_threshold() {
        Alarm alarm = new AlarmWithLowPressure();

        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }

    private class AlarmWithLowPressure extends Alarm {
        @Override
        protected double pressureValue() {
            return 0;
        }
    }

    private class SensorWithPressure18 extends Sensor {
        @Override
        public double popNextPressurePsiValue() {
            return 18;
        }
    }
}
