@RestController
public class MyController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }

    @GetMapping("/goodbye")
    public String sayGoodbye() {
        return "Goodbye, see you again!";
    }

    @GetMapping("/morning")
    public String morningMessage() {
        return "Good morning!";
    }

    @GetMapping("/evening")
    public String eveningMessage() {
        return "Good evening!";
    }

    @GetMapping("/greet")
    public String greetBasedOnTime() {
        int hour = LocalTime.now().getHour();
        if (hour < 12) {
            return "Good morning!";
        } else if (hour < 18) {
            return "Good afternoon!";
        } else {
            return "Good evening!";
        }
    }
}

