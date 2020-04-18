package com.gbm.clvt;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.gbm.clvt.model.AppUser;
import com.gbm.clvt.service.AppUserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class ClvtApplicationTests {

	@Autowired
	private AppUserService userService;

	@Autowired
	BCryptPasswordEncoder encoder;

	@Test
	void createUsers() {
		AppUser frontUser = new AppUser("AppCalvoroto", encoder.encode("AppCalvoroto"), "USER");
		AppUser supportUser = new AppUser("SoporteCalvoroto", encoder.encode("sprtClvt100%"), "USER", "ADMIN");

		AppUser retrievedFrontUser = userService.register(frontUser);
		AppUser retrievedSupportUser = userService.register(supportUser);

		assertTrue(frontUser.equals(retrievedFrontUser));
		assertTrue(supportUser.equals(retrievedSupportUser));
	}

}
