package observer.observer;

import observer.DisplayElement;
import observer.observerable.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * 当前
 */
public class CurrentConditionsDisplay implements Observer , DisplayElement {
    Observable observable;
    private  float temperature;
    private  float humidity;

    /**
     * 观察者需要确定它的被观察者，同时这个被观察者需要登记这个观察者
     * @param observable
     */
    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }


    @Override
    public void update(Observable o, Object arg) {
    if(o instanceof WeatherData){
        WeatherData weatherData = (WeatherData)o;
        this.temperature = weatherData.getTemperature();
        this.humidity = weatherData.getHumidity();
        display();
    }

    }

    @Override
    public void display(){
        System.out.println("Current conditions:"+temperature+"F degrees and "+humidity+"% humidity");
    }
}
