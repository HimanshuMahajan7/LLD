package visitordesignpattern.src.visitor;

import visitordesignpattern.src.element.DeluxeRoom;
import visitordesignpattern.src.element.DoubleRoom;
import visitordesignpattern.src.element.SingleRoom;

public class RoomMaintenanceVisitor implements RoomVisitor {

    @Override
    public void visit(SingleRoom singleRoomObj) {
        System.out.println("Performing maintenance of SingleRoom");
    }

    @Override
    public void visit(DoubleRoom doubleRoomObj) {
        System.out.println("Performing maintenance of DoubleRoom");
    }

    @Override
    public void visit(DeluxeRoom deluxeRoomObj) {
        System.out.println("Performing maintenance of DeluxeRoom");
    }
}
