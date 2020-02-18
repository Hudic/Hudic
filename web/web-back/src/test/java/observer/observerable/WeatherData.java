package observer.observerable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class WeatherData extends Observable {
    private List obs;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        obs = new ArrayList();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        if (o == null)
            throw new NullPointerException();
        if (!obs.contains(o)) {
            obs.add(o);
        }
    }

    @Override
    public void notifyObservers() {
        Object[] arrLocal;
        synchronized (this) {

//            if (!super.changed)
//                return;
            arrLocal = obs.toArray();
            clearChanged();
        }
        for (int i = 0; i < arrLocal.length; i++)
            ((Observer) arrLocal[i]).update(this, null);
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
