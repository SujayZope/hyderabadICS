package com.jpa.test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		/*
		 * User user = new User();
		 * 
		 * user.setName("Sujay Zope"); user.setCity("Jalgaon");
		 * user.setStatus("Java programmer");
		 * 
		 * User user1 = userRepository.save(user); System.out.println(user1);
		 */

		User user1 = new User();
		user1.setName("Rushikesh Pawar");
		user1.setCity("Nandel");
		user1.setStatus("React Developer");

		User user2 = new User();
		user2.setName("Akshay Patil");
		user2.setCity("Jalgaon");
		user2.setStatus("Java programmer");

		/*
		 * Save // User resulUser = userRepository.save(user2); List<User> users =
		 * List.of(user1, user2); Iterable<User> result = userRepository.saveAll(users);
		 * 
		 * result.forEach(user -> { System.out.println(user); }); //
		 * System.out.println("saved user " + result); System.out.println("done");
		 */

		// update

		/*
		 * Optional<User> optional = userRepository.findById(53);
		 * 
		 * User user = optional.get();
		 * 
		 * user.setStatus("React Developer");
		 * 
		 * User result = userRepository.save(user);
		 * 
		 * System.out.println(result);
		 */

		// how to get data
		// findById(id) - return optional containing your data

		// Iterable<User> itr = userRepository.findAll();

		/*
		 * Iterator<User> iterator = itr.iterator();
		 * 
		 * while(iterator.hasNext()) { User user = iterator.next();
		 * System.out.println(user); }
		 */

		/*
		 * itr.forEach(new Consumer<User>() {
		 * 
		 * @Override public void accept(User t) { // TODO Auto-generated method stub
		 * System.out.println(t); }
		 * 
		 * });
		 */

		/*
		 * itr.forEach(user -> { System.out.println(user); });
		 */

		// delete

		/*
		 * userRepository.deleteById(52); System.out.println("deleted");
		 */

		/*
		 * Iterable<User> allusers = userRepository.findAll();
		 * 
		 * allusers.forEach(user->System.out.println(user));
		 * userRepository.deleteAll(allusers);
		 */

		/*
		 * List<User> users = userRepository.findByName("Akshay Patil");
		 * 
		 * users.forEach(e -> System.out.println(e));
		 */

		/*
		 * List<User> users = userRepository.findByNameAndCity("Akshay Patil",
		 * "Jalgaon");
		 * 
		 * users.forEach(e -> System.out.println(e));
		 */

		List<User> allUsers = userRepository.getAllResult();
		
		allUsers.forEach(e->{
			System.out.println(e);
		});
		
	}

}
