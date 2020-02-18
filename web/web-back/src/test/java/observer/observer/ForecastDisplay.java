package observer.observer;

import observer.DisplayElement;
import observer.observerable.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * 预报
 */
public class ForecastDisplay implements Observer, DisplayElement {
    private float lastPressure;
    private float currentPressure = 29.92f;

    public ForecastDisplay(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            lastPressure = currentPressure;
            currentPressure = weatherData.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current pressure:" + currentPressure + " and lastPressure" + lastPressure);
    }
}
