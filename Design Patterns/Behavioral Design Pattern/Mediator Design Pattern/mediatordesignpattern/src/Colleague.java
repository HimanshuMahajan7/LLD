package mediatordesignpattern.src;

public interface Colleague {
    void placeBid(int bidAmount);
    void receivedBidNotification(int bidAmount);
    String getName();
}
