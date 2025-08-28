# Design Patterns
    Reusable solution for a commonly occuring problem
    Useful in writing more structured, managable, extinsibe and scalable code


## Types of Design Pattern
* Creational Design Pattern
* Structural Design Pattern
* Behavioral Design Pattern

## Creational Design Pattern
1. Singleton Pattern
2. Prototype Pattern
3. Builder Pattern
4. Factory Pattern
5. Abstract Pattern
6. Object Pool Pattern

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


## Creational Design Pattern
    ⟶ Creational Design Patterns are responsible to create objects / controls the creation of object.
    ⟶ Creational Design Patterns are a category of design patterns focused on object creation.
        They provide ways to create objects in a manner that is flexible, reusable, and hides the complexities of object instantiation.
        These patterns address the problem of creating objects in a way that decouples the client code from the specific object types and their creation logic.
    ⟶ Creational patterns deal with object creation mechanisms, trying to make the system independent of how objects are created, composed, and represented.
    ⟶ They provide more flexibility & reuse compared to direct object instantiation using new.

#### 🔹 Types of Creational Design Patterns
1. Singleton Pattern
2. Prototype Pattern
3. Builder Pattern
4. Factory Pattern
5. Abstract Pattern
6. Object Pool Pattern

#### 👷 Builder
* Separates construction of a complex object from its representation.
* Example: StringBuilder, building House step by step.

#### 🏭 Factory Method
* Defines an interface for creating objects, but lets subclasses decide which class to instantiate.
* Example: Calendar.getInstance().

#### 🏢 Abstract Factory
* Provides an interface to create families of related objects without specifying concrete classes.
* Example: GUIFactory → creates Button & Checkbox for different OS.

#### 👤 Singleton
* Ensures only one instance of a class exists and provides a global access point.
* Example: Runtime.getRuntime().

#### 📦 Prototype
* Creates new objects by cloning an existing object.
* Example: Object.clone().

### 🏗️ Creational Design Patterns — Comparison
| Pattern                 | Purpose                                                                    | When to Use                                                                    | Example in Java                            | ✅ Pros                                     | ⚠️ Cons                                     |
| ------------------------| -------------------------------------------------------------------------- | ------------------------------------------------------------------------------ | ------------------------------------------ | ------------------------------------------ | --------------------------------------------  |
| **👷 Builder**          | Separate object construction from representation                           | When an object has **many optional params** or needs **step-by-step creation** | `StringBuilder`, `Lombok @Builder`         | Clear, readable code; immutable objects    | More complex code                            |
| **🏭 Factory Method**   | Define interface for creating objects, subclasses decide implementation    | When a class can't anticipate the type of objects it needs                     | `Calendar.getInstance()`                   | Loose coupling, easy extension             | Class explosion if too many types            |
| **🏢 Abstract Factory** | Create **families of related objects** without specifying concrete classes | When products must be used together & are platform dependent                   | `javax.xml.parsers.DocumentBuilderFactory` | Ensures compatibility across products      | Hard to add new product families             |
| **👤 Singleton**        | Ensure **only one instance** exists, provide global access                 | When you need a single point of control (e.g., config, cache)                  | `Runtime.getRuntime()`                     | Controlled access, saves memory            | Harder to unit test, risk of misuse          |
| **📦 Prototype**        | Clone objects instead of creating new ones                                 | When object creation is costly or complex                                      | `Object.clone()`                           | Efficient cloning, dynamic object creation | Cloning may be tricky (deep vs shallow copy) |

✅ Quick Recall:
* **Builder** → step-by-step, complex objects.
* **Factory** Method → one product, subclass decides.
* **Abstract** Factory → family of products.
* **Singleton** → only one instance.
* **Prototype** → clone existing objects.


## 📖 Detailed Explanation

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

// Main
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

---

### Prototype Design Pattern
    It is used when we have to make Copy/Clone from existing Object.
    Prototype is a creational design pattern that allows you to create new objects by cloning an existing object (prototype) instead of instantiating from scratch.

* The Prototype Design Pattern is a creational design pattern that facilitates the creation of new objects by copying an existing object, known as the prototype.
* Instead of instantiating new objects from scratch, this pattern allows for the efficient creation of duplicates, particularly when object creation is a complex, time-consuming, or resource-intensive process. 

#### 🔹 Key Points:
* Helps when object creation is costly/complex.
* Supports deep copy (clone full object graph) and shallow copy (copy only references).
* Uses clone() method in Java (Cloneable interface).

#### ✅ Advantages:
* Faster object creation.
* Reduces subclassing (no need for multiple factory classes).
* Flexible — can clone complex objects easily.

#### ⚠️ Disadvantages:
* Cloning can be tricky (deep vs shallow).
* Requires handling mutable references carefully.

#### 👉 Interview Tip:
* If asked — “When would you use Prototype?” → Answer:
    * ✔️ When creating objects is resource-intensive (e.g., DB connection configs, large object graphs).
    * ✔️ When you need many similar objects with slight modifications.

#### 📌 Example in Java:
```java
// Prototype Interface
interface Prototype extends Cloneable {
    Prototype clone();
}

// Concrete Prototype
class Document implements Prototype {
    private String content;

    Document(String content) { this.content = content; }

    @Override
    public Prototype clone() {
        return new Document(this.content); // shallow copy
    }

    public String getContent() { return content; }
}

// Usage
public class PrototypeDemo {
    public static void main(String[] args) {
        Document doc1 = new Document("Original Content");
        Document doc2 = (Document) doc1.clone();

        System.out.println(doc1.getContent()); // Original Content
        System.out.println(doc2.getContent()); // Original Content
    }
}
```

---

### Singleton Design Pattern
**`Singleton`** is a creational design pattern that ensures:
1. Only one instance of a class exists in the application.
2. Provides a global access point to that instance.

#### 🔹 Key Concept:
* Private constructor (prevents direct instantiation).
* Static instance reference.
* Public static method to return the instance.

#### ✅ Advantages:
* Controlled access to a single instance.
* Saves memory (only one object created).
* Useful for logging, caching, configuration.

#### ⚠️ Disadvantages:
* Harder to unit test (due to global state).
* Can become a God object (too many responsibilities).
* Risk of multithreading issues if not implemented properly.

#### 🏆 Real-World Examples in Java:
* Runtime.getRuntime()
* Logger frameworks (Log4j, SLF4J)
* Spring Beans (default scope = Singleton)

#### Ways to achieve:
1. Eager Initialization
2. Lazy Initialization
3. Synchronozed Method
4. Double-Checked Locking
5. Double-Checked Locking with `volatile`
7. Bill Pugh Singleton (Inner Class) (Best Practice)
8. Enum Singleton

#### ⚠️ Issues with Double-Checked Locking:
* Partial Thread safe or no thread safe because of
    1. Instruction Reordering
    2. L1 Caching
* Fix:
    1. Use of `volatile` keyword

#### 👉 Interview Tip:
* “Which Singleton implementation is best?”
    * ➡️ Answer: Bill Pugh Singleton (uses inner static helper class, thread-safe, lazy-loaded, efficient).
* Best Practical Choice → Bill Pugh Singleton (simple, lazy, thread-safe).
* Most Robust → Enum Singleton (safe from serialization + reflection).
* Worst for Real Projects → Lazy without synchronization (race conditions).
* Can we create Singleton Pattern with `synchronised` keyword?
    * Yes, we can. Using following ways -
        * Eager Initialization
        * Bill Pugh Singleton (Static Inner Class)
        * Enum Singleton

#### 📝 Singleton Implementation Comparison
| Approach                    | Implementation                                               | Thread-Safety            | Lazy Loading   | Pros ✅                                     | Cons ⚠️                                                     |
| --------------------------- | ------------------------------------------------------------ | -----------------------  | ------------   | -------------------------------------------- | ----------------------------------------------------------- |
| **Eager Initialization**    | `private static final Singleton instance = new Singleton();` | ✅ Yes                   | ❌ No         | Simple, thread-safe without sync overhead    | Instance created even if not used (wastes memory/resources) |
| **Lazy Initialization**     | Instance created on first call                               | ❌ No                    | ✅ Yes        | Saves memory until needed                    | Not thread-safe, multiple instances in multithreaded env    |
| **Synchronized Method**     | `synchronized getInstance()`                                 | ✅ Yes                   | ✅ Yes        | Simple fix for thread-safety                 | Performance overhead (every call is synchronized)           |
| **Double-Checked Locking**  | `if (instance == null) { synchronized ... }`                 | ✅ Yes (with `volatile`) | ✅ Yes        | Efficient, synchronization only once         | Slightly complex, `volatile` required                       |
| **Bill Pugh (Inner Class)** | Static inner helper class                                    | ✅ Yes                   | ✅ Yes        | Best practice, efficient, simple             | None significant                                            |
| **Enum Singleton**          | `enum Singleton { INSTANCE; }`                               | ✅ Yes                   | ✅ Yes        | Easiest, serialization-safe, reflection-safe | Can’t extend class (enums can’t inherit other classes)      |

#### 📌 Example in Java
1. Eager Initialization
    ```java
        class EagerSingleton {
            private static final EagerSingleton instance = new EagerSingleton();

            private EagerSingleton() {}  // private constructor

            public static EagerSingleton getInstance() {
                return instance;
            }
        }
    ```

2. Lazy Initialization (Thread-Unsafe)
    ```java
        class LazySingleton {
            private static LazySingleton instance;

            private LazySingleton() {}

            public static LazySingleton getInstance() {
                if (instance == null) {
                    instance = new LazySingleton(); // not thread-safe
                }
                return instance;
            }
        }
    ```

3. Synchronized Method
    ```java
        class SynchronizedMethodSingleton {
            private static volatile SynchronizedMethodSingleton instance;

            private SynchronizedMethodSingleton() {}

            public static SynchronizedMethodSingleton getInstance() {
                if (instance == null) {
                    synchronized (SynchronizedMethodSingleton.class) {
                        if (instance == null) {
                            instance = new SynchronizedMethodSingleton();
                        }
                    }
                }
                return instance;
            }
        }
    ```

4. Double-Checked Locking (PArtial Thread-Safe)
    ```java
        class DoubleCheckedLocking {
            private static DoubleCheckedLocking instance;

            private DoubleCheckedLocking() {}

            public static DoubleCheckedLocking getInstance() {
                if (instance == null) {
                    synchronized (DoubleCheckedLocking.class) {
                        if (instance == null) {
                            instance = new DoubleCheckedLocking();
                        }
                    }
                }
                return instance;
            }
        }
    ```

5. Double-Checked Locking (Thread-Safe)
    ```java
        class DoubleCheckedLockingWithVolatile {
            private static volatile DoubleCheckedLockingWithVolatile instance;

            private DoubleCheckedLockingWithVolatile() {}

            public static DoubleCheckedLockingWithVolatile getInstance() {
                if (instance == null) {
                    synchronized (DoubleCheckedLockingWithVolatile.class) {
                        if (instance == null) {
                            instance = new DoubleCheckedLockingWithVolatile();
                        }
                    }
                }
                return instance;
            }
        }
    ```

6. Bill Pugh Singleton (Best Practice)
    ```java
        class BillPughSingleton {
            private BillPughSingleton() {}

            private static class Helper {
                private static final BillPughSingleton INSTANCE = new BillPughSingleton();
            }

            public static BillPughSingleton getInstance() {
                return Helper.INSTANCE;
            }
        }
    ```

7. Enum Singleton
    ```java
        public enum EnumSingleton {
            INSTANCE;  // single instance

            public void showMessage() {
                System.out.println("Hello from Enum Singleton!");
            }
        }

        // Usage
        public class Main {
            public static void main(String[] args) {
                EnumSingleton singleton = EnumSingleton.INSTANCE;
                singleton.showMessage();
            }
        }
    ```

---

### Fly Weight Design Pattern
    The Flyweight Pattern is a structural design pattern that reduces memory usage by sharing objects instead of creating new ones for every request.
    It achieves this by separating the object's intrinsic state (shared and immutable) from its extrinsic state (unique and context-dependent). 

It is useful when:
* You have a huge number of similar objects.
* Many objects can share common (intrinsic) state, while the unique (extrinsic) state is supplied from outside.

#### 🏗️ Structure
* **`Intrinsic State`** → Data that is inherent to the object and can be shared between multiple instances. This data is typically immutable and doesn't change based on context. 
* **`Extrinsic State`** → Data that is specific to each object's context and cannot be shared. This data is often passed into the flyweight object when needed. 
* **`Flyweight`** → Interface for shared objects. The object that shares its intrinsic state. 
* **`ConcreteFlyweight`** → Implements Flyweight, stores intrinsic state.
* **`FlyweightFactory`** → Manages Flyweights, ensures sharing.
* **`Client`** → Uses Flyweights and supplies extrinsic state.

#### ✅ Advantages
* Reduced Memory Consumption:
    * By sharing intrinsic state, the pattern minimizes memory usage, especially when dealing with a large number of similar objects.
* Improved Performance:
    * Reduces the overhead of creating and managing numerous objects, leading to faster application performance. 
* Promotes object reuse.
* Faster creation (objects cached instead of new instantiation).

#### ⚠️ Disadvantages
* Code becomes complex (managing intrinsic vs extrinsic state).
* Works best only when there are lots of similar objects.

#### 🏆 Real-World Examples
* Java String Pool ("abc" literals are flyweights).
* Integer.valueOf(int) (caching small integers -128 to 127).
* GUI applications (reusing button/character shapes).
* Game development (e.g., trees in a forest, bullets in a shooter game).

#### 👉 Quick Interview Tip:
* “Is Flyweight used in Java?”
    * → Answer: Yes, String pool and Integer cache are real-world Flyweight implementations.

#### 📌 Example:
```java
// Flyweight
interface Shape {
    void draw(int x, int y);
}

// ConcreteFlyweight
class Circle implements Shape {
    private final String color;  // intrinsic (shared), must be private

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing " + color + " circle at (" + x + "," + y + ")");
    }
}

// FlyweightFactory
class ShapeFactory {
    private static final Map<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        return circleMap.computeIfAbsent(color, c -> new Circle(c));
    }
}

// Main
public class FlyweightDemo {
    public static void main(String[] args) {
        Shape red1 = ShapeFactory.getCircle("Red");
        red1.draw(10, 20);

        Shape red2 = ShapeFactory.getCircle("Red");
        red2.draw(30, 40);

        System.out.println("Same object? " + (red1 == red2));  // true
    }
}
```

---

### Command Design Pattern
    The Command Pattern is a behavioral design pattern that turns a request into a standalone object (command).
    This decouples the sender (Invoker) of the request from the receiver (Executor).
    👉 In short: Encapsulates a request as an object.

#### 🏗️ Structure:
* Command → Interface declaring execute().
* ConcreteCommand → Implements Command, calls methods on Receiver.
* Receiver → The actual object that performs the action.
* Invoker → Calls execute() on the command object.
* Client → Creates commands and associates them with receivers.

#### ✅ Advantages:
* Decouples sender and receiver.
* Supports undo/redo operations (by keeping history of commands).
* Easy to add new commands without modifying existing code.

#### ⚠️ Disadvantages:
* Can lead to creation of many small classes.
* Increases complexity if overused.

#### 🏆 Real-World Examples:
* GUI buttons & menu actions (ActionListener in Swing).
* Job queues (commands scheduled and executed later).
* Macro recording (a sequence of commands stored and replayed).
* Spring Batch uses similar command encapsulation.

#### 👉 Interview Tip:
* “How is it different from Strategy?”
    * Strategy: Encapsulates an algorithm.
    * Command: Encapsulates a request/action.

#### 📌 Example: Remote Control
```java
// Command Interface
interface Command {
    void execute();
}

// Receiver
class Light {
    public void turnOn() { System.out.println("Light is ON"); }
    public void turnOff() { System.out.println("Light is OFF"); }
}

// Concrete Commands
class TurnOnLightCommand implements Command {
    private Light light;
    public TurnOnLightCommand(Light light) { this.light = light; }
    public void execute() { light.turnOn(); }
}

class TurnOffLightCommand implements Command {
    private Light light;
    public TurnOffLightCommand(Light light) { this.light = light; }
    public void execute() { light.turnOff(); }
}

// Invoker
class RemoteControl {
    private Command command;
    public void setCommand(Command command) { this.command = command; }
    public void pressButton() { command.execute(); }
}

// Main
public class CommandPatternDemo {
    public static void main(String[] args) {
        Light light = new Light();
        Command on = new TurnOnLightCommand(light);
        Command off = new TurnOffLightCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(on);
        remote.pressButton();   // Light is ON

        remote.setCommand(off);
        remote.pressButton();   // Light is OFF
    }
}
```

---

### Decorator Design Pattern
    The Decorator Pattern is a structural design pattern that lets you add new behaviors to objects dynamically without altering their class.

    👉 In short: Wrap objects to extend their functionality.

#### Issue it resolves:
* Class Explosion

#### 🏗️ Structure
* Component (Interface/Abstract class) → defines the base behavior.
* ConcreteComponent → the actual object.
* Decorator (Abstract) → wraps a component, implements the same interface.
* ConcreteDecorator → adds extra behavior before/after delegating to wrapped object.

#### ✅ Advantages
* Flexible → add/remove responsibilities at runtime.
* Promotes composition over inheritance.
* Open/Closed Principle → extend functionality without modifying existing code.

#### ⚠️ Disadvantages
* Can lead to many small classes.
* Debugging becomes harder because of multiple wrappers.

#### 🏆 Real-World Examples
* java.io package → BufferedReader, DataInputStream, LineNumberReader all decorate InputStream/Reader.
* Spring’s BeanPostProcessor and AOP Proxies.
* UI frameworks → decorators for styling components.

#### 👉 Interview Tip:
* If asked “Difference between Decorator and Proxy?”
    * Decorator: Adds new behavior/features.
    * Proxy: Controls access (e.g., security, lazy loading).

#### 📌 Example
Coffee ☕ Example (classic for interviews):
```java
// Component
interface Coffee {
    String getDescription();
    double getCost();
}

// ConcreteComponent
class SimpleCoffee implements Coffee {
    public String getDescription() { return "Simple Coffee"; }
    public double getCost() { return 5.0; }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;
    public CoffeeDecorator(Coffee coffee) { this.coffee = coffee; }
}

// ConcreteDecorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) { super(coffee); }
    public String getDescription() { return coffee.getDescription() + ", Milk"; }
    public double getCost() { return coffee.getCost() + 1.5; }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) { super(coffee); }
    public String getDescription() { return coffee.getDescription() + ", Sugar"; }
    public double getCost() { return coffee.getCost() + 0.5; }
}

// Main
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());
    }
}
```

---

### Iterator Design Pattern
    The Iterator Pattern is a behavioral design pattern that provides a way to sequentially access elements of a collection (aggregate object) without exposing its underlying representation (like arrays, lists, trees, etc.).
    👉 In short: It decouples traversal logic from the collection itself.

#### 🏗️ Structure
* Iterator (interface) → defines methods like hasNext() and next().
* ConcreteIterator → implements the traversal logic.
* Aggregate (interface) → defines createIterator().
* ConcreteAggregate → collection that provides an iterator.
* Client → uses iterator to traverse elements.

#### ✅ Advantages
* Provides a uniform way to iterate over different collections.
* Hides internal representation (array, list, tree, etc.).
* Supports multiple simultaneous traversals on the same collection.

#### ⚠️ Disadvantages
* Adds extra classes (Iterator + Aggregate).
* Sometimes iteration logic is so simple (like for-each) that pattern feels like overkill.

#### 🏆 Real-World Examples
* Java’s built-in Iterator: Iterator<T> with hasNext(), next(), and remove().
* Enhanced for-each loop → uses Iterable under the hood.
* ResultSet in JDBC.
* Spliterator in Java 8 for parallel iteration.

#### 👉 Interview Tip:
* If asked: “How is Iterator different from Enumeration in Java?”
    * Enumeration (legacy) → methods: hasMoreElements(), nextElement(). Only read.
    * Iterator (modern) → methods: hasNext(), next(), remove(). Read + Remove.

#### 📌 Example
Custom Book Collection example 📚:
```java
// Iterator interface
interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Aggregate interface
interface BookCollection {
    Iterator<String> createIterator();
}

// ConcreteAggregate
class Library implements BookCollection {
    private String[] books = {"Design Patterns", "Java in Action", "Effective Java"};

    @Override
    public Iterator<String> createIterator() {
        return new BookIterator(books);
    }
}

// ConcreteIterator
class BookIterator implements Iterator<String> {
    private String[] books;
    private int index = 0;

    public BookIterator(String[] books) {
        this.books = books;
    }

    public boolean hasNext() {
        return index < books.length;
    }

    public String next() {
        return hasNext() ? books[index++] : null;
    }
}

// Main
public class IteratorPatternDemo {
    public static void main(String[] args) {
        Library library = new Library();
        Iterator<String> iterator = library.createIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

---

### Mediator Design Pattern
    The Mediator Pattern is a behavioral design pattern.
    It encourage loose coulping by keeping objects from referring to each other explicitly and allows them to communicate through a mediator object.

* The Mediator Pattern is a behavioral design pattern that defines an object (mediator) to encapsulate how a set of objects interact.
    * It promotes loose coupling by preventing direct communication between objects.
    * Instead, objects communicate through the mediator, which handles coordination.
* 👉 In simple words: Instead of all objects talking to each other directly (chaos 🌀), they talk only to a Mediator, which organizes the communication.

#### 🏗️ Structure
* Mediator (interface) → defines methods for communication.
* ConcreteMediator → central class that coordinates communication.
* Colleagues (components) → objects that interact, but only via the mediator.
* Client → configures mediator and components.

#### ✅ Advantages
* Reduces tight coupling between components.
* Centralizes control of interactions.
* Makes communication logic easier to maintain.

#### ⚠️ Disadvantages
* Mediator can become a God object (too much logic in one place).
* If too many colleagues → mediator logic gets complex & bloated.

#### 🏆 Real-World Examples
* Auction System (AuctionMediator, Bidder)
* Chat applications (like WhatsApp, Slack, etc.).
* Air traffic control system 🛫 (planes communicate via control tower, not directly).
* GUI frameworks (dialog boxes, buttons, text fields coordinated via a mediator).
* Spring Framework’s DispatcherServlet (acts as a mediator between requests & controllers).

#### 👉 Interview Tip:
* If asked Mediator vs Observer:
    * Their intent is different
    * Mediator → central authority controls communication.
    * Observer → objects communicate by broadcasting notifications, no central authority, change to state is communicated.

#### 📌 Example
Let’s model a Chat Room 💬 using the Mediator pattern.

```java
// Mediator
interface ChatMediator {
    void sendMessage(String msg, User user);
    void addUser(User user);
}

// ConcreteMediator
class ChatRoom implements ChatMediator {
    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String msg, User sender) {
        for (User u : users) {
            // Don't send message to the sender
            if (u != sender) {
                u.receive(msg);
            }
        }
    }
}

// Colleague
abstract class User {
    protected ChatMediator mediator;
    protected String name;

    public User(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    abstract void send(String msg);
    abstract void receive(String msg);
}

// ConcreteColleague
class ConcreteUser extends User {
    public ConcreteUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String msg) {
        System.out.println(this.name + " sends: " + msg);
        mediator.sendMessage(msg, this);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.name + " received: " + msg);
    }
}

// Client
public class MediatorPatternDemo {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        User u1 = new ConcreteUser(chatRoom, "Alice");
        User u2 = new ConcreteUser(chatRoom, "Bob");
        User u3 = new ConcreteUser(chatRoom, "Charlie");

        chatRoom.addUser(u1);
        chatRoom.addUser(u2);
        chatRoom.addUser(u3);

        u1.send("Hi everyone!");
        u2.send("Hello Alice!");
    }
}

/*
    Alice sends: Hi everyone!
    Bob received: Hi everyone!
    Charlie received: Hi everyone!
    Bob sends: Hello Alice!
    Alice received: Hello Alice!
    Charlie received: Hello Alice!
*/
```

---

### Visitor Design Pattern

The Visitor Pattern is a behavioral design pattern that lets you add new operations to a set of objects without modifying their classes.
* It achieve this by separating the operation/algorithm from the objects on which it operates.
* The new operation is put inside a Visitor object, and the target objects just “accept” the visitor.

👉 In simple terms: Instead of changing your objects every time you want a new operation, you create a visitor that performs that operation.

#### 🏗️ Structure
* **Visitor** (interface) → Declares visit methods for each type of element.
* **ConcreteVisitor** → Implements the operations.
* **Element** (interface) → Defines accept(Visitor v) method.
* **ConcreteElement** → Implements accept by calling visitor’s visit(this).
* **Client** → Traverses objects and applies visitors.

#### ✅ Advantages
* Add new operations without modifying existing classes.
* Promotes Open/Closed Principle.
* Separates algorithms from object structure.

#### ⚠️ Disadvantages
* Adding a new element type requires changing Visitor interface + all visitors.
* Increases complexity with many visitor methods.

#### 🏆 Real-World Examples
* Compilers/Interpreters: Parsing AST nodes (Abstract Syntax Tree).
* Object serialization/deserialization.
* Code analysis tools (static analysis, linting).
* Document processing (e.g., visiting different document elements: text, image, table).

#### 👉 Interview Tip:
* Use Visitor when the set of element classes is stable but operations keep changing.
* Use Strategy/Command when operations vary but element structure is stable.

#### 📌 Code Example
Document Editor 📝

```java
// Visitor
interface DocumentVisitor {
    void visit(Text text);
    void visit(Image image);
    void visit(Table table);
}

// Concrete Visitor 1: Rendering
class RenderVisitor implements DocumentVisitor {
    public void visit(Text text) {
        System.out.println("Rendering Text: " + text.getContent());
    }
    public void visit(Image image) {
        System.out.println("Rendering Image: " + image.getFileName());
    }
    public void visit(Table table) {
        System.out.println("Rendering Table with " + table.getRows() + " rows");
    }
}

// Concrete Visitor 2: Exporting
class ExportVisitor implements DocumentVisitor {
    public void visit(Text text) {
        System.out.println("Exporting Text to HTML: <p>" + text.getContent() + "</p>");
    }
    public void visit(Image image) {
        System.out.println("Exporting Image to HTML: <img src='" + image.getFileName() + "'/>");
    }
    public void visit(Table table) {
        System.out.println("Exporting Table to HTML: <table rows='" + table.getRows() + "'/>");
    }
}

// Element
interface DocumentElement {
    void accept(DocumentVisitor visitor);
}

// Concrete Elements
class Text implements DocumentElement {
    private String content;
    public Text(String content) { this.content = content; }
    public String getContent() { return content; }
    public void accept(DocumentVisitor visitor) { visitor.visit(this); }
}

class Image implements DocumentElement {
    private String fileName;
    public Image(String fileName) { this.fileName = fileName; }
    public String getFileName() { return fileName; }
    public void accept(DocumentVisitor visitor) { visitor.visit(this); }
}

class Table implements DocumentElement {
    private int rows;
    public Table(int rows) { this.rows = rows; }
    public int getRows() { return rows; }
    public void accept(DocumentVisitor visitor) { visitor.visit(this); }
}

// Client
public class VisitorPatternDemo {
    public static void main(String[] args) {
        DocumentElement[] document = {
            new Text("Hello World"),
            new Image("design.png"),
            new Table(5)
        };

        DocumentVisitor renderVisitor = new RenderVisitor();
        DocumentVisitor exportVisitor = new ExportVisitor();

        System.out.println("=== Rendering Document ===");
        for (DocumentElement element : document) {
            element.accept(renderVisitor);
        }

        System.out.println("\n=== Exporting Document ===");
        for (DocumentElement element : document) {
            element.accept(exportVisitor);
        }
    }
}
```

---

### Memento Design Pattern
The Memento design pattern is a behavioral pattern that enables you to save and restore an object's previous state without violating its encapsulation.

* This pattern is specially meant to store the object history.
* When we want to build **UNDO** functionality then we can go with this pattern.
* It is also know as SNAPSHOT Design Pattern.
* It does not expose the objects internal implementation.

#### 🎯 Intent:
* Capture and store an object’s internal state without exposing its internals.
* Later, restore the object to this saved state (undo/rollback functionality).

#### 📌 Participants / Components:
* **`Originator`** → The object whose state we want to save/restore, or let say we want to maintain the history.
* **`Memento`** → Stores the internal state of Originator, or say holds the state of Originator.
* **`Caretaker`** → Manages Mementos but does not modify them.

#### 🏆 Advantages:
* ✔ Provides undo/rollback functionality.
* ✔ Keeps object encapsulation (no need to expose internal state).
* ✔ Clean separation of responsibilities (Originator vs Caretaker).

#### ⚠️ Disadvantages:
* ❌ If state is huge, storing many mementos may cause high memory usage.
* ❌ Managing history can get complex in large systems.

#### 💡 Real-World Use Cases:
* Browser Tabs (close/reopen)
* Text editors (Undo/Redo).
* Games (Save/Load checkpoints).
* Databases (Transaction rollback).
* IDE refactoring tools (Restore project to earlier state).

#### 📌 Code Example:
Text Editor 📖 (Undo Feature)
```java
// Memento - stores state
class TextMemento {
    private final String state;
    public TextMemento(String state) {
        this.state = state;
    }
    public String getSavedState() {
        return state;
    }
}

// Originator - the object whose state we want to save/restore
class TextEditor {
    private String text = "";

    public void write(String newText) {
        text += newText;
    }

    public String getText() {
        return text;
    }

    // Save current state to Memento
    public TextMemento save() {
        return new TextMemento(text);
    }

    // Restore state from Memento
    public void restore(TextMemento memento) {
        this.text = memento.getSavedState();
    }
}

// Caretaker - manages saved states
import java.util.Stack;
class History {
    private Stack<TextMemento> history = new Stack<>();

    public void save(TextEditor editor) {
        history.push(editor.save());
    }

    public void undo(TextEditor editor) {
        if (!history.isEmpty()) {
            editor.restore(history.pop());
        }
    }
}

// Client
public class MementoPatternDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.write("Hello ");
        history.save(editor);  // Save 1

        editor.write("World");
        history.save(editor);  // Save 2

        System.out.println("Current Text: " + editor.getText());

        history.undo(editor);
        System.out.println("After Undo: " + editor.getText());

        history.undo(editor);
        System.out.println("After Undo Again: " + editor.getText());
    }
}
```

---

### Template Method Design Pattern

Define the skeleton of an algorithm in a method, deferring some steps to subclasses.
* Ensures the algorithm structure is fixed.
* Allows subclasses to override only specific parts without changing the overall flow.

#### 📌 Key Idea
* Abstract class defines the template method (algorithm’s structure).
* Concrete subclasses provide implementation for the variable parts.

#### 🛠 Participants
* Abstract Class → Defines the template method & abstract steps.
* Concrete Class → Implements the abstract steps.

#### When to use (Identify):
* When you want all the classes to follow the specific steps to process the task.
* But also need to provide the flexibility that each class have thir own logic in that specific steps.

#### 🏆 Advantages
* ✔ Reuse of algorithm structure.
* ✔ Promotes code consistency across subclasses.
* ✔ Encourages inversion of control (parent controls structure, child customizes behavior).

#### ⚠️ Disadvantages
* ❌ Restrictive if subclasses need different algorithm structures.
* ❌ Increases inheritance usage (less flexible than composition sometimes).

#### 💡 Real-World Use Cases
* Frameworks & libraries (e.g., JUnit setUp() / tearDown()).
* Parsing algorithms.
* UI rendering frameworks.
* Building workflows where steps are fixed but details vary.

#### 📌 Code Example: 
Preparing a Beverage ☕🍵
```java
// Abstract Class
abstract class Beverage {
    
    // Template Method (final to prevent overriding)
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Steps left to subclasses
    protected abstract void brew();
    protected abstract void addCondiments();
}

// Concrete Class: Tea
class Tea extends Beverage {
    protected void brew() {
        System.out.println("Steeping the tea");
    }
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}

// Concrete Class: Coffee
class Coffee extends Beverage {
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

// Client
public class TemplateMethodDemo {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        tea.prepareRecipe();

        System.out.println("-----");

        Beverage coffee = new Coffee();
        coffee.prepareRecipe();
    }
}

Output:
/*
    Boiling water
    Steeping the tea
    Pouring into cup
    Adding lemon
    -----
    Boiling water
    Dripping coffee through filter
    Pouring into cup
    Adding sugar and milk
*/
```

---

### Interpreter Design Pattern

Defines a grammar for a language and provides an interpreter to evaluate sentences in that language.
* Used when you have repeatedly occurring problems expressed in a language-like format.
* Each grammar rule becomes a class.

#### 🛠 Participants / Components:
* **Abstract Expression** → Defines the interface for all expressions.
* **Terminal Expression** → Implements interpretation for basic symbols.
* **Non-terminal Expression** → Represents grammar rules composed of other expressions.
* **Context** → Contains information that is global to the interpreter.
* **Client** → Builds the expression tree and invokes interpretation.

#### 🏆 Advantages:
* ✔ Useful for DSLs (Domain-Specific Languages).
* ✔ Makes it easy to extend the grammar (just add new Expression classes).
* ✔ Clean separation of grammar rules into classes.

#### ⚠️ Disadvantages:
* ❌ Class explosion (many classes for each grammar rule).
* ❌ Not suitable for complex grammars (better use parser generators like ANTLR).

#### 💡 Real-World Use Cases:
* Rule engines (business rules).
* Mathematical expression evaluators.
* SQL query interpreters.
* Regular expression engines.

#### 📖 Code Example:
Simple Arithmetic Expression Evaluator ➕✖️
* Interpret mathematical expressions like 5 + 10 and 20 - 5.

```java
// Context: carries data for interpretation
class Context { }

// Abstract Expression
interface Expression {
    int interpret(Context context);
}

// Terminal Expression: Number
class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Context context) {
        return number;
    }
}

// Non-Terminal Expression: Addition
class AddExpression implements Expression {
    private Expression left, right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }
}

// Non-Terminal Expression: Subtraction
class SubtractExpression implements Expression {
    private Expression left, right;

    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }
}

// Client
public class InterpreterDemo {
    public static void main(String[] args) {
        Context context = new Context();

        // Expression: (5 + 10) - (3 + 2)
        Expression expression = new SubtractExpression(
                new AddExpression(new NumberExpression(5), new NumberExpression(10)),
                new AddExpression(new NumberExpression(3), new NumberExpression(2))
        );

        System.out.println("Result = " + expression.interpret(context));  // Output: 10
    }
}
```

---

### Object Pool Design Pattern

The **Object Pool Pattern** is a *`creational design`* pattern that allows you to reuse objects that are expensive to create, instead of creating and destroying them repeatedly.

It aims to improve performance and reduce resource consumption by maintaining a pool of ready-to-use objects, rather than creating new ones on demand. 

Think of it as a pool of reusable resources (like a swimming pool 🏊):
* Objects are borrowed from the pool.
* After use, they are returned instead of being destroyed.

#### 📌 Components:
* **Resource/Reusable Object** → The actual resource (e.g., DB connection, thread, socket).
* **Pool** → Manages available and in-use objects.
* **Client** → Borrows and returns objects to the pool.

#### 🏆 Advantages:
* ✔ Improves performance (no repeated expensive creation).
* ✔ Efficient resource management.
* ✔ Useful when object creation is costly (DB connections, threads, sockets).
* ✔ Reducethe the overhead of creating and destroying the frequently required objects.
* ✔ Reducethe latency, as it uses the pre initialized objects.

#### ⚠️ Disadvantages:
* ❌ Extra complexity (must handle concurrency, lifecycle).
* ❌ Risk of stale/dirty objects if not reset properly.
* ❌ Overhead of maintaining pool logic.
* ❌ Resource leakage can happen, if object is not hadled properly and not being returned to the pool.
* ❌ Required more memory because of managing the pool.
* ❌ Pool management reuired thread safety, which is additional overhead.

#### 💡 Real-World Use Cases:
* Database Connection Pool (JDBC, HikariCP).
* Thread Pool (Java Executors).
* Socket Pool (network applications).
* Memory/cache management.

#### 🛠 Code Example:
Database Connection Pool
```java
import java.util.*;

class Connection {
    private String id;
    private boolean inUse;

    public Connection(String id) {
        this.id = id;
    }

    public String getId() { return id; }
    public boolean isInUse() { return inUse; }
    public void setInUse(boolean inUse) { this.inUse = inUse; }

    public void connect() {
        System.out.println("Using connection: " + id);
    }
}

class ConnectionPool {
    private List<Connection> availableConnections = new ArrayList<>();
    private List<Connection> usedConnections = new ArrayList<>();
    private static final int MAX_POOL_SIZE = 5;

    public ConnectionPool() {
        for (int i = 1; i <= MAX_POOL_SIZE; i++) {
            availableConnections.add(new Connection("Conn-" + i));
        }
    }

    // Borrow connection
    public synchronized Connection getConnection() {
        if (availableConnections.isEmpty()) {
            throw new RuntimeException("No connections available!");
        }
        Connection conn = availableConnections.remove(availableConnections.size() - 1);
        conn.setInUse(true);
        usedConnections.add(conn);
        return conn;
    }

    // Return connection
    public synchronized void releaseConnection(Connection conn) {
        conn.setInUse(false);
        usedConnections.remove(conn);
        availableConnections.add(conn);
    }
}

// Client
public class ObjectPoolDemo {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool();

        // Borrow connections
        Connection c1 = pool.getConnection();
        c1.connect();

        Connection c2 = pool.getConnection();
        c2.connect();

        // Return one connection
        pool.releaseConnection(c1);

        // Borrow again (reused)
        Connection c3 = pool.getConnection();
        c3.connect();
    }
}
```