# Design Patterns
    Reusable solution for a commonly occuring problem
    Useful in writing more structured, managable, extinsibe and scalable code


## Types of Design Pattern
* Creational Design Pattern
* Structural Design Pattern
* Behavioral Design Pattern

## Creational Design Pattern
* Singleton Pattern
* Prototype Pattern
* Builder Pattern
* Factory Pattern
* Abstract Pattern
* Object Pool Pattern

## Structural Design Pattern
1. Adapter Pattern
2. Bridge Pattern
3. Composite Pattern
4. Decorator Pattern
5. Facade Pattern
6. Proxy Pattern
7. Fly Weight Pattern
8. Private Class Data Pattern

## Behavioral Design Pattern
1. Observer Pattern
2. Strategy Pattern
3. State Pattern
4. Command Pattern
5. Chain of Responsibility Pattern
6. Template Pattern
7. Interpreter Pattern
8. Visitor Pattern
9. Mediator Pattern
10. Memento Pattern
11. Null Object Pattern
12. Iterator Pattern

---
### Proxy Pattern
    The Proxy Pattern is a structural design pattern that provides a placeholder or surrogate for another object to control access to it.

🔍 Purpose:
* Add extra behavior (like logging, security, caching) without changing the actual object.
* Control access to the real subject (expensive or sensitive objects).

🧱 Types of Proxy:
| Type                 | Description                                        |
| -------------------- | -------------------------------------------------- |
| **Virtual Proxy**    | Delays creation until needed (lazy initialization) |
| **Protection Proxy** | Controls access (e.g., based on user roles)        |
| **Remote Proxy**     | Represents an object in a different JVM/machine    |
| **Smart Proxy**      | Adds extra behavior (logging, counting, etc.)      |

✅ Example:
```java
interface Service {
    void doWork();
}

class RealService implements Service {
    public void doWork() {
        System.out.println("RealService: Working...");
    }
}

class ProxyService implements Service {
    private RealService realService = new RealService();

    public void doWork() {
        System.out.println("Proxy: Logging before");
        realService.doWork();
        System.out.println("Proxy: Logging after");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Service service = new ProxyService();
        service.doWork();
    }
}

// Output:
/*
Proxy: Logging before
RealService: Working...
Proxy: Logging after
*/
```

---
### Chain of Responsibility Pattern
    Chain of Responsibility Pattern is a behavioral design pattern that lets you pass request along a chain of handlers.
    Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.
* Examples
  1. Logging System
  2. ATM Machine - Cash Withdrawal

---
### Null Object Pattern
    The Null Object Pattern is a behavioral design pattern used to encapsulate the absence of an object by providing a substitutable alternative that offers suitable default "do nothing" behavior.
    Instead of returning null or requiring explicit null checks throughout the client code, this pattern introduces a special "null object" that implements the same interface as the real object but provides empty or default implementations for its methods.

* A null object replaces `NULL` return type.
* No need to put if check for checking null
* Null Object reflects do nothing or default behaviour.

* In short, the Null Object Pattern is a behavioral design pattern that provides a non-functional default object in place of null.
* It helps avoid NullPointerException and eliminates the need to check for null everywhere.

💡 Intent:
* Replace null with a neutral object that does nothing but conforms to the expected interface.

✅ Benefits:
| Feature              | Description                               |
| -------------------- | ----------------------------------------- |
| Avoids `null` checks | Eliminates `if (obj != null)` everywhere  |
| Cleaner code         | No risk of `NullPointerException`         |
| Implements interface | Behaves polymorphically with real objects |

🧱 Structure:
* Interface (e.g., NotificationService)
* Real Implementation (e.g., EmailNotification)
* Null Implementation (e.g., NullNotification) – does nothing

✅ Example:
```java
interface NotificationService {
    void send(String message);
}

class EmailNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

class NullNotification implements NotificationService {
    public void send(String message) {
        // do nothing
    }
}

// Usage
public NotificationService getService(User user) {
    if (user == null) {
        return new NullNotification();  // no-op object
    } else {
        return new EmailNotification();
    }
}

```

---

### State Pattern
    The State Design Pattern is a behavioral design pattern that allows an object to alter its behavior when its internal state changes.

🔍 Intent:
* Allow an object to behave differently based on its current state, and to change its behavior at runtime without using many if-else or switch statements.

🧱 Structure:
* **Context**: Maintains a reference to a State object and delegates behavior to it.
* **State** (interface): Declares methods that concrete states will implement.
* **ConcreteState**: Implements state-specific behavior.

✅ Example: Document State (Draft → Moderation → Published)
```java
// State interface
interface State {
    void handle();
}

// Concrete States
class DraftState implements State {
    public void handle() {
        System.out.println("Document is in Draft State.");
    }
}

class ModerationState implements State {
    public void handle() {
        System.out.println("Document is under Moderation.");
    }
}

class PublishedState implements State {
    public void handle() {
        System.out.println("Document is Published.");
    }
}

// Context
class Document {
    private State currentState;

    public void setState(State state) {
        this.currentState = state;
    }

    public void applyState() {
        currentState.handle();
    }
}
```

💡 Real-World Examples:
| Scenario                | States                          |
| ----------------------- | ------------------------------- |
| TCP Connection          | Open, Closed, Listening         |
| Media Player            | Playing, Paused, Stopped        |
| Order Processing System | New, Packed, Shipped, Delivered |

✅ Benefits:
| Advantage             | Description                                    |
| --------------------- | ---------------------------------------------- |
| Avoids if-else chains | No need for long conditionals for state logic  |
| Clean separation      | Each state is self-contained                   |
| Easy to extend        | Add new states without modifying existing code |

🚫 Drawbacks:
* Can result in lots of classes if there are many states.
* Slightly complex setup compared to simple switch statements.

---

### Composite Pattern
    The Composite Design Pattern is a structural pattern used to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly.
    In other words, whether dealing with a single object or a group of objects (composite), clients can use them interchangeably.

💡 Intent:
* "Compose objects into tree structures to represent part-whole hierarchies."

🔍 Real-World Examples:
| Scenario                    | States                                           |
| --------------------------- | ------------------------------------------------ |
| File System                 | File System, Folder, File                        |
| Arithmetic Expression       | Expression, Number, Operation                    |
| Graphical User Interfaces   | UI elements like panels, buttons and text fields |

✅ Benefits:
| Benefit        | Explanation                                                                       |
| -------------- | --------------------------------------------------------------------------------- |
| Tree structure | Represents hierarchical structures clearly                                        |
| Uniformity     | Clients treat single and composite objects uniformly                              |
| Extensibility  | New components (Leaf or Composite) can be added easily                            |
| Recursive      | It enables operations to be applied recursively across the entire tree structure. |

---

### Adapter Design Pattern
    The Adapter Design Pattern is a structural pattern that allows incompatible interfaces to work together.
    It acts as a bridge between two incompatible interfaces.

💡 Intent:
* Convert the interface of a class into another interface that clients expect.

🧱 Key Components:
| Component | Role                                                                  |
| --------- | --------------------------------------------------------------------- |
| `Client`  | The object that needs to use the functionality of another object.     |
| `Adaptee` | Existing class with incompatible interface                            |
| `Target`  | Expected interface (what client understands)                          |
| `Adapter` | Converts Adaptee to Target                                            |

📦 Real-Life Example:
* Power Adapter & Socket
* Memory Card, Card Reader, USB Socket
* XML to JSON Parser
* Weight Machine shownig reading only in pound, need an adapter