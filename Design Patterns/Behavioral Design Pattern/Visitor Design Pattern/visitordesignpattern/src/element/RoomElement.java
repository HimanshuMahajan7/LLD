package visitordesignpattern.src.element;

import visitordesignpattern.src.visitor.RoomVisitor;

public interface RoomElement {
    void accept(RoomVisitor visitor);
}
