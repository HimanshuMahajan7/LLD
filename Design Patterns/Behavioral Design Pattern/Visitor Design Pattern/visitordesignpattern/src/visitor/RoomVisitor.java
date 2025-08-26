package visitordesignpattern.src.visitor;

import visitordesignpattern.src.element.DeluxeRoom;
import visitordesignpattern.src.element.DoubleRoom;
import visitordesignpattern.src.element.SingleRoom;

public interface RoomVisitor {
    void visit(SingleRoom singleRoomObj);
    void visit(DoubleRoom doubleRoomObj);
    void visit(DeluxeRoom deluxeRoomObj);
}
