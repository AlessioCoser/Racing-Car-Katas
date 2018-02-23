package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private Sensor sensor;

    private boolean alarmOn = false;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
    }

    public Alarm() {
        this(new RealSensor());
    }

    public void check()
    {
        double pressure = sensor.popNextPressurePsiValue();

        if (isOutOfRange(pressure)) {
            alarmOn = true;
        }
    }

    private boolean isOutOfRange(double pressure) {
        double highPressureThreshold = 21;
        double lowPressureThreshold = 17;

        return pressure < lowPressureThreshold || pressure > highPressureThreshold;
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }
}
