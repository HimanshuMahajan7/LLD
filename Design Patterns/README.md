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
  2. ATM Machine
