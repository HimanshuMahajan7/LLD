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

---

### Builder Design Pattern
    The Builder Pattern is a creational design pattern that lets you construct complex objects step-by-step.
    It separates the construction process from the representation so that the same construction process can create different representations.

💡 When to Use
* When an object has many optional parameters.
* When object creation is complex and should be isolated from its representation.
* To avoid telescoping constructors (constructors with too many parameters).

🔑 Key Components
* **Product** → The complex object that is being built.
* **Builder Interface** → Defines the steps required to build the Product.
* **ConcreteBuilder** → Implements the Builder interface, providing specific implementations for building parts of the Product and returning the final Product instance.
* **Director** (Optional) → Controls the order of construction steps.

📦 Real-Life Example:
* StringBuilder

✅ Advantages of the Builder Pattern:
* Improves readability and maintainability.
* Encapsulation of Construction Logic.
* Flexibility
* Immutability
* Centralized Validation

✅ Advantages of the Builder Pattern:
| Benefit                                       | Explanation                                                                                                                                                   |
| ----------------------------------------------| ------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Improves readability and maintainability.     | It makes the object creation process more readable, especially for objects with many parameters, by providing a fluent API (often using method chaining).     |
| Encapsulation of Construction Logic.          | The complex construction logic is encapsulated within the builder, keeping the Product class clean and focused on its core responsibilities.                  |
| Flexibility                                   | Allows for the creation of different representations of the same complex object using the same construction process.                                          |
| Immutability                                  | Facilitates the creation of immutable objects by constructing them completely before they are returned to the client.                                         |
| Centralized Validation                        | Validation rules related to the object's construction can be centralized within the builder.                                                                  |

---

### Facade Design Pattern
    The Facade Pattern is a structural design pattern that provides a simplified interface to a complex subsystem.
    It hides the complexity of multiple classes and exposes a single entry point for the client to use.

✅ When to Use
* When we want to hide the system complexities from the client.
* When you have a complex system with multiple classes and APIs, but you want to provide a simple interface to the client.
* To decouple client code from the underlying implementation details.
* To reduce dependencies between subsystems.

📦 Example:
```java
// Subsystem 1
class AudioPlayer {
    void playAudio() { System.out.println("Playing audio..."); }
}

// Subsystem 2
class VideoPlayer {
    void playVideo() { System.out.println("Playing video..."); }
}

// Subsystem 3
class SubtitleService {
    void loadSubtitles() { System.out.println("Loading subtitles..."); }
}

// Facade
class MediaFacade {
    private AudioPlayer audioPlayer;
    private VideoPlayer videoPlayer;
    private SubtitleService subtitleService;

    public MediaFacade() {
        audioPlayer = new AudioPlayer();
        videoPlayer = new VideoPlayer();
        subtitleService = new SubtitleService();
    }

    public void playMovie() {
        audioPlayer.playAudio();
        videoPlayer.playVideo();
        subtitleService.loadSubtitles();
        System.out.println("Movie started successfully!");
    }
}

// Client
public class FacadePatternExample {
    public static void main(String[] args) {
        MediaFacade mediaFacade = new MediaFacade();
        mediaFacade.playMovie();
    }
}
```

🔑 Key Points
* Hides complexity — Client doesn’t need to interact with multiple subsystem classes directly.
* Promotes loose coupling — Client only depends on the facade, not the subsystems.
* Improves readability — A single method can perform multiple complex actions internally.

---

### Bridge Design Pattern
    The bridge design pattern is a structural design pattern that separates an abstraction from its implementation, allowing them to vary independently.
    This means that you can change either the abstraction (the interface) or the implementation (the details of how it's done) without affecting the other.
* Decouples an abstraction from its implementation so both can evolve independently without affecting each other.

🔹 Key Points
* Avoids rigid inheritance hierarchies.
* Useful when both abstraction and implementation can have multiple variations.
* Promotes flexibility and scalability.

```java
// abstraction in bridge pattern
abstract class Vehicle {
    protected Workshop workShop1;
    protected Workshop workShop2;

    protected Vehicle(Workshop workShop1, Workshop workShop2)
    {
        this.workShop1 = workShop1;
        this.workShop2 = workShop2;
    }

    abstract public void manufacture();
}

// Implementer for bridge pattern
interface Workshop
{
    abstract public void work();
}

// Concrete implementation 1 for bridge pattern
class Produce implements Workshop {
    @Override
    public void work()
    {
        System.out.print("Produced");
    }
}

// Concrete implementation 2 for bridge pattern
class Assemble implements Workshop {
    @Override
    public void work()
    {
        System.out.print(" And");
        System.out.println(" Assembled.");
    }
}

// Refine abstraction 1 in bridge pattern
class Car extends Vehicle {
    public Car(Workshop workShop1, Workshop workShop2)
    {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture()
    {
        System.out.print("Car ");
        workShop1.work();
        workShop2.work();
    }
}

// Refine abstraction 2 in bridge pattern
class Bike extends Vehicle {
    public Bike(Workshop workShop1, Workshop workShop2)
    {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture()
    {
        System.out.print("Bike ");
        workShop1.work();
        workShop2.work();
    }
}

// Demonstration of bridge design pattern
class BridgePattern {
    public static void main(String[] args)
    {
        Vehicle vehicle1 = new Car(new Produce(), new Assemble());
        vehicle1.manufacture();
        Vehicle vehicle2 = new Bike(new Produce(), new Assemble());
        vehicle2.manufacture();
    }
}
```

✅ Advantages
* Abstraction & implementation can evolve separately.
* Reduces code duplication.