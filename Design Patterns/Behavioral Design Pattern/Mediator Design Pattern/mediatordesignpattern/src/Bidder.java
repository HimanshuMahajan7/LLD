package mediatordesignpattern.src;

public class Bidder implements Colleague {

    String name;
    AuctionMediator auctionMediator;

    public Bidder(String name, AuctionMediator auctionMediator) {
        this.name = name;
        this.auctionMediator = auctionMediator;
        auctionMediator.addBidder(this);
    }

    @Override
    public void placeBid(int bidAmount) {
        System.out.println("Bidder " + name + " have placed the bid of " + bidAmount);
        auctionMediator.placeBid(this, bidAmount);
    }

    @Override
    public void receivedBidNotification(int bidAmount) {
        System.out.println("Bidder: " + name + " got the notification that someone has put bid if amount: " + bidAmount);
    }

    @Override
    public String getName() {
        return name;
    }
}
