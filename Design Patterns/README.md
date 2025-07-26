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