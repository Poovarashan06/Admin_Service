package com.project.ShoppingMall;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class AdminServiceForShoppingMallApplicationTests {

	@Autowired
	AdminRepository aRepo;
	

		@Test
		@Order(1)
			public void testCreate() {
				AdminClass a=new AdminClass();
				a.setId(1);
				a.setName("Poovarasan");
				a.setPassword("12345");
				a.setMall("LULUs");
				a.setPhone(833452332);
				aRepo.save(a);
				assertNotNull(aRepo.findById(1).get());	
			}
		//Retrieval
		@Test
		@Order(2)
		public void testReadall() {
			List<AdminClass> list = aRepo.findAll();
			assertThat(list).size().isGreaterThan(0);
		}
		//Retrieval of single method
		@Test
		@Order(3)
		public void testSingleAdmin() {
			AdminClass admin = aRepo.findById(1).get();
			assertEquals("lulu",admin.getMall());
		}
		//Update
		@Test
		@Order(4)
		public void testUpadate() {
			AdminClass a = aRepo.findById(1).get();
			a.setMall("bda");
			aRepo.save(a);
			assertNotEquals("forum",aRepo.findById(1).get().getMall());
		}
		//Delete
		@Test
		@Order(5)
		public void testDelete() {
			aRepo.deleteById(1);
			assertThat(aRepo.existsById(1)).isFalse();
		}

}
