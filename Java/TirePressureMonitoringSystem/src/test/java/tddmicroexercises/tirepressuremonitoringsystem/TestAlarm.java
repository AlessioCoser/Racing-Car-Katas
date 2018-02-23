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
        RealSensor sensor = new SensorWithPressure18();
        Alarm alarm = new Alarm(sensor);

        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

    @Test
    public void is_on_when_pressure_is_out_threshold() {
        RealSensor sensor = new SensorWithPressure0();
        Alarm alarm = new Alarm(sensor);

        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }

    private class SensorWithPressure18 extends RealSensor {
        @Override
        public double popNextPressurePsiValue() {
            return 18;
        }
    }

    private class SensorWithPressure0 extends RealSensor {
        @Override
        public double popNextPressurePsiValue() {
            return 0;
        }
    }
}
