package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

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

        if (isOutOfRange(pressure))
        {
            alarmOn = true;
        }
    }

    private boolean isOutOfRange(double pressure) {
        return pressure < LowPressureThreshold || pressure > HighPressureThreshold;
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }
}
