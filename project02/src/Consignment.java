import java.util.ArrayList;

public class Consignment {
    private String name;
    private String transmitter;
    private String receiver;
    private int distance;
    public int randomNum;
    public Stack st = new Stack();

    public Consignment(String name, String transmitter, String receiver , int distance , int randomNum) {
        this.name = name;
        this.transmitter = transmitter;
        this.receiver = receiver;
        this.distance = distance;
        this.randomNum = randomNum;
    }

    public int Compare(Consignment con2){
        if(this.distance > con2.distance){
            return 1;
        } else if (this.distance < con2.distance) {
            return -1;
        }
        else {
            return 0;
        }
    }

    public String getTransmitter() {
        return transmitter;
    }

    public String getReceiver() {
        return receiver;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
