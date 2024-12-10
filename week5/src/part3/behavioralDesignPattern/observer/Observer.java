package part3.behavioralDesignPattern.observer;

abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
