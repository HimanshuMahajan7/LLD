package mediatordesignpattern.src;

public class Main {
    public static void main(String[] args) {
        AuctionMediator auctionMediator = new Auction();
        Colleague bidder1 = new Bidder("A", auctionMediator);
        Colleague bidder2 = new Bidder("B", auctionMediator);
        Colleague bidder3 = new Bidder("C", auctionMediator);

        bidder1.placeBid(2000);
        bidder2.placeBid(3000);
        bidder3.placeBid(3001);
        bidder1.placeBid(4000);
    }
}
