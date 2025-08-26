package visitordesignpattern.src.element;

import visitordesignpattern.src.visitor.RoomVisitor;

public class DoubleRoom implements RoomElement {

    public int roomPrice = 0;

    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }
}
