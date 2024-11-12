package Part4.Fan.src;

public class Fan {
    private int speed;
    private final String[] speedString = {"SLOW", "MEDIUM", "FAST"};
    private boolean on;
    private double radius;
    private String color;

    public Fan(){
        this.speed = 1;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public void setSpeed(int speed){
        if (speed >= 1 && speed <= 3){
            this.speed = speed;
        }
    }

    public void setOn(){
        this.on = !this.on;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public void setColor(String color){
        this.color = color;
    }

    public String getSpeed(){
        return this.speedString[this.speed-1];
    }
    public String getColor(){
        return this.color;
    }
    public int getSpeedInt(){
        return this.speed;
    }
    public double getRadiusInt(){
        return this.radius;
    }
    public boolean getOn(){
        return this.on;
    }

    public String toString(){
        if (this.getOn()){
            String str = "";
            str += this.getSpeed() + " ";
            str += this.getColor() + " ";
            str += this.getRadiusInt() + " ";
            str += " Fan is on";
            return str;
        }
        else{
            String str = "";
            str += this.getColor() + " ";
            str += this.getRadiusInt() + " ";
            str += " Fan is off";
            return str;
        }
    }
}
