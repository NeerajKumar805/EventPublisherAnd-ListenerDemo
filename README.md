
# Spring Boot Event Publishing and Listening

This project demonstrates how Spring Boot handles **events** internally, and how you can use the `ApplicationEventPublisher` and `@EventListener` annotations in your own applications.

---

## 📌 What are Spring Events?

- Spring uses the **Observer Pattern** internally.  
- A component publishes an event → Spring’s event dispatcher delivers it → one or more listeners consume it.  
- Events are synchronous by default (unless configured otherwise).

---

## 🔧 How It Works

1. **Event Class**  
   Create a custom event that extends `ApplicationEvent` (or just use a POJO with `@EventListener`).

   ```java
   public class UserCreatedEvent {
       private final String username;

       public UserCreatedEvent(String username) {
           this.username = username;
       }

       public String getUsername() {
           return username;
       }
   }
````

2. **Publisher**
   Use `ApplicationEventPublisher` to publish the event.

   ```java
   @Service
   public class UserService {

       private final ApplicationEventPublisher publisher;

       public UserService(ApplicationEventPublisher publisher) {
           this.publisher = publisher;
       }

       public void createUser(String username) {
           // business logic...
           System.out.println("User created: " + username);

           // publish event
           publisher.publishEvent(new UserCreatedEvent(username));
       }
   }
   ```

3. **Listener**
   Listen to the event with `@EventListener`.

   ```java
   @Component
   public class UserCreatedListener {

       @EventListener
       public void handleUserCreated(UserCreatedEvent event) {
           System.out.println("Handling event for user: " + event.getUsername());
       }
   }
   ```

---

## ⚙️ Internal Flow in Spring

1. Publisher calls `publishEvent(...)`.
2. Event is wrapped in a `PayloadApplicationEvent` (if needed).
3. Spring’s `ApplicationEventMulticaster` finds all matching listeners.
4. Each listener method is invoked (synchronously by default).
5. Async support: mark listener with `@Async` and enable `@EnableAsync`.

---

## 🚀 Running the Demo

```bash
./mvnw spring-boot:run
```

Output:

```
User created: Neeraj
Handling event for user: Neeraj
```

---

## ✅ Key Takeaways

* Events decouple components in Spring.
* Use `@EventListener` for clean listener methods.
* Events are synchronous unless you enable async execution.
* This mechanism powers many internal Spring Boot features (context refresh, lifecycle events, etc).

---

```
