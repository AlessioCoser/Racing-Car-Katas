package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private final double LowPressureThreshold = 17;
    private final double HighPressureThreshold = 21;

    RealSensor sensor;

    boolean alarmOn = false;

    public Alarm(RealSensor sensor) {
        this.sensor = sensor;
    }

    public Alarm() {
        this(new RealSensor());
    }

    public void check()
    {
        double psiPressureValue = pressureValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    protected double pressureValue() {
        return sensor.popNextPressurePsiValue();
    }

    public boolean isAlarmOn()
    {
        return alarmOn;
    }
}
