package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;

import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);
      Car car1 = new Car("BMW", 330);
      Car car2 = new Car("AUDI", 6);
      Car car3 = new Car("Porsche", 911);
      Car car4 = new Car("BMW",540);
      Car car5 = new Car("toyota",300);


      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));


      carService.addCar(car5);
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }


      System.out.println(carService.getCarById(3));
      System.out.println();
      System.out.println(userService.getUserByModelSeries("BMW", 330).toString());
      System.out.println();
      System.out.println(userService.getUserByModelSeries("BMW", 540).toString());
      System.out.println();

      context.close();
   }
}
