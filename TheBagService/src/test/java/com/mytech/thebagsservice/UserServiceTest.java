package com.mytech.thebagsservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.mytech.thebagsservice.entities.Role;
import com.mytech.thebagsservice.entities.User;
import com.mytech.thebagsservice.helpers.AppConstant;
import com.mytech.thebagsservice.services.UserService;

@DataJpaTest(showSql = true)
@Rollback(false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserServiceTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private UserService userService;

	@Test
	public void testCreateNewuserWithoutRole() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode("");
		User adminUser = new User("admin1@abc.com", password, "Hoang", "Nguyen");

		User savedDbUser = userService.save(adminUser);

		if (savedDbUser == null) {
			System.out.println("Test case testCreateNewuserWithoutRole: failed");
		} else {
			System.out.println("Test case testCreateNewuserWithoutRole: success");
		}

		assertThat(savedDbUser).isNotNull();
	}

	@Test
	public void testCreateNewuserWithRole() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode("Abcd@123");

		Role role = testEntityManager.find(Role.class, 1);
		User savedDbUser = null;

		if (role != null) {

			User modUser = new User("mod@abc.com", password, "An", "Nguyen");
			modUser.addRole(role);

			savedDbUser = userService.save(modUser);

			if (savedDbUser == null) {
				System.out.println("Test case testCreateNewuserWithRole: failed");
			} else {
				System.out.println("Test case testCreateNewuserWithRole: success");
			}
		}

		assertThat(savedDbUser).isNotNull();
	}

	@Test
	public void testCreateManyUser() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String password = encoder.encode("Abcd@123");

		Role role = testEntityManager.find(Role.class, 2);
		long count = 0;

		System.out.println("testCreateManyUser: " + role.getName());
		
		if (role != null) {

			for (int i = 100; i < 200; i++) {
				User normalUser = new User("user" + i + "@abc.com", password, "User", "Nguyen");
				normalUser.addRole(role);
				userService.save(normalUser);
			}

			count = userService.getCount();
		}

		assertThat(count).isGreaterThan(99);
	}
	
	@Test
	public void testUserPaging() {
		List<User> listUser = userService.getUserPage(1);
		
		int count = listUser.size();
		
		assertThat(count).isEqualTo(AppConstant.pageSize);
	}
}
