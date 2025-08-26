package visitordesignpattern.src;

import visitordesignpattern.src.element.DeluxeRoom;
import visitordesignpattern.src.element.DoubleRoom;
import visitordesignpattern.src.element.RoomElement;
import visitordesignpattern.src.element.SingleRoom;
import visitordesignpattern.src.visitor.RoomMaintenanceVisitor;
import visitordesignpattern.src.visitor.RoomPricingVisitor;
import visitordesignpattern.src.visitor.RoomVisitor;

public class Main {
    public static void main(String[] args) {
        RoomElement singleRoom = new SingleRoom();
        RoomElement doubleRoom = new DoubleRoom();
        RoomElement deluxeRoom = new DeluxeRoom();

        RoomVisitor roomPricingVisitor = new RoomPricingVisitor();

        singleRoom.accept(roomPricingVisitor);
        int singleRoomPrice = ((SingleRoom) singleRoom).roomPrice;
        System.out.println(singleRoomPrice);

        doubleRoom.accept(roomPricingVisitor);
        int doubleRoomPrice = ((DoubleRoom) doubleRoom).roomPrice;
        System.out.println(doubleRoomPrice);

        deluxeRoom.accept((roomPricingVisitor));
        int deluxeRoomPrice = ((DeluxeRoom) deluxeRoom).roomPrice;
        System.out.println(deluxeRoomPrice);

        RoomVisitor roomMaintenanceVisitor = new RoomMaintenanceVisitor();
        singleRoom.accept(roomMaintenanceVisitor);
        doubleRoom.accept(roomMaintenanceVisitor);
        deluxeRoom.accept(roomMaintenanceVisitor);
    }
}
