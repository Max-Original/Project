package hw.project;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import hw.project.dao.BasketRepo;
import hw.project.dao.ProductRepo;
import hw.project.dao.UserRepo;
import hw.project.domain.Basket;
import hw.project.domain.Product;
import hw.project.domain.User;
import hw.project.domain.UserRole;
import hw.project.service.BasketService;
import hw.project.service.ProductService;
import hw.project.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan("hw.project")
class JavaAdvanced21ApplicationTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private BasketService basketService;
	
	@Autowired
	private BasketRepo basketRepo;

	@Test
	public void saveUser() {
	
	List<User> users = userRepo.findAll();
	
	assertThat(users, hasSize(0));
	
	User user = new User();
	user.setFirst_name("testovi");
	user.setLast_name("testovi");
	user.setEmail("testovu");
	user.setPassword("testovi");
	user.setRole(UserRole.ROLE_ADMIN);
	
	
	userService.save(user);
	
	 
    users = userRepo.findAll();
	
	assertThat(users, hasSize(1));
	
	User userFromDB = users.get(0);
	
	assertTrue(userFromDB.getEmail().equals(user.getEmail()));
	assertTrue(userFromDB.getPassword().equals(user.getPassword()));
	
	}
	
	@Test
	public void FindByEmail() {
		
		List<User> users = userRepo.findAll();
		
		assertThat(users, hasSize(0));
		
		User user = new User();
		user.setFirst_name("testovi");
		user.setLast_name("testovi");
		user.setEmail("testovu");
		user.setPassword("testovi");
		user.setRole(UserRole.ROLE_ADMIN);
		
		
		userService.save(user);
		
		 
	    users = userRepo.findAll();
		
		assertThat(users, hasSize(1));
	
		User userFindByEmail = userService.findByEmail(user.getEmail());
		
		assertTrue(userFindByEmail.getEmail().equals(user.getEmail()));
		assertTrue(userFindByEmail.getPassword().equals(user.getPassword()));
	}

	@Test
	public void saveProduct() {

		List<Product> products = productRepo.findAll();
		assertThat(products, hasSize(0));
		
		Product product = new Product();
		
		product.setId(1);
		product.setName("Bread");
		product.setDescription("taste nice");
		product.setPrice(10d);
		
		productService.save(product);
		
		products = productRepo.findAll();
		assertThat(products, hasSize(1));
		
	}

	@Test
	public void findByIdProduct() {
		
		List<Product> products = productRepo.findAll();
		assertThat(products, hasSize(0));
		
		Product product = new Product();
	
		product.setName("Bread");
		product.setDescription("taste nice");
		product.setPrice(10d);
		
		productService.save(product);
		
		products = productRepo.findAll();
		assertThat(products, hasSize(1));
		
		Product productFromDB = productService.findById(products.get(0).getId());
		
		assertTrue(productFromDB.getName().equals(product.getName()));
		assertTrue(productFromDB.getDescription().equals(product.getDescription()));
		assertTrue(productFromDB.getPrice().equals(product.getPrice()));
		
		
	}
	
	@Test
	public void GetAllProducts() {
		List<Product> products = productRepo.findAll();
		assertThat(products, hasSize(0));
		
		Product product = new Product();
	
		product.setName("Bread");
		product.setDescription("taste nice");
		product.setPrice(10d);
		
		productService.save(product);
		
		products = productRepo.findAll();
		assertThat(products, hasSize(1));
		
		Product product1 = new Product();
		
		product1.setName("Bread");
		product1.setDescription("taste nice");
		product1.setPrice(10d);
		
		productService.save(product1);
		
		products = productRepo.findAll();
		assertThat(products, hasSize(2));
		
		List<Product> productFromDB = productRepo.findAll();
		
		assertTrue(productFromDB.get(0).getName().equals(product.getName()));
		assertTrue(productFromDB.get(0).getDescription().equals(product.getDescription()));
		assertTrue(productFromDB.get(0).getPrice().equals(product.getPrice()));
		
		assertTrue(productFromDB.get(1).getName().equals(product1.getName()));
		assertTrue(productFromDB.get(1).getDescription().equals(product1.getDescription()));
		assertTrue(productFromDB.get(1).getPrice().equals(product1.getPrice()));
	}
	
	@Test
	public void deletefromBasket() {
			
		User user = new User();
		user.setFirst_name("testovi");
		user.setLast_name("testovi");
		user.setEmail("testovu");
		user.setPassword("testovi");
		user.setRole(UserRole.ROLE_ADMIN);
		
		userService.save(user);
		
		User userFromDb = userRepo.findAll().stream().findFirst().get();
		
		List<Product> products = productRepo.findAll();
		assertThat(products, hasSize(0));
		
		Product product = new Product();
		
		product.setId(1);
		product.setName("Bread");
		product.setDescription("taste nice");
		product.setPrice(10d);
		
		productRepo.saveAll(Arrays.asList(product));
		
		List<Product> productsFromdDB = productRepo.findAll();
		
		Date dateNow = new Date();
		
		Basket basket = new Basket();
		basket.setProduct(productsFromdDB.get(0));
		basket.setUser(userFromDb);
		basket.setPurchase_date(dateNow);
		
		Basket basket1 = new Basket();
		basket1.setProduct(productsFromdDB.get(0));
		basket1.setUser(userFromDb);
		basket1.setPurchase_date(dateNow);
		
		List<Basket> baskets = basketRepo.findAll();
		assertThat(baskets, hasSize(0));
	
		basketRepo.saveAll(Arrays.asList(basket, basket1));
		
		baskets = basketRepo.findAll();
		assertThat(baskets, hasSize(2));
		
		basketService.delete(baskets.get(0));
		
		baskets = basketRepo.findAll();
		assertThat(baskets, hasSize(1));
		
		
	}
	
	@Test
	public void addToBasket() {
		
		List<User> users = userRepo.findAll();
		assertThat(users, hasSize(0));
		
		User user = new User();
		user.setFirst_name("testovi");
		user.setLast_name("testovi");
		user.setEmail("testovu");
		user.setPassword("testovi");
		user.setRole(UserRole.ROLE_ADMIN);
		
		userService.save(user);
		
		List<User> userFromdDB = userRepo.findAll();
		
		List<Product> products = productRepo.findAll();
		assertThat(products, hasSize(0));
		
		Product product = new Product();
		
		product.setId(1);
		product.setName("Bread");
		product.setDescription("taste nice");
		product.setPrice(10d);

		productRepo.save(product);
		List<Product> productsFromdDB = productRepo.findAll();
		
		List<Basket> baskets = basketRepo.findAll();
		assertThat(baskets, hasSize(0));
		
		Date dateNow = new Date();

		Basket basket = new Basket();
		basket.setProduct(productsFromdDB.get(0));
		basket.setUser(userFromdDB.get(0));
		basket.setPurchase_date(dateNow);
	
		basketRepo.save(basket);
		
		baskets = basketRepo.findAll();
		assertThat(baskets, hasSize(1));
	}
	
	@Test
	public void GetAllBaskets() {
		
		List<User> users = userRepo.findAll();
		assertThat(users, hasSize(0));
		
		User user = new User();
		user.setFirst_name("testovi");
		user.setLast_name("testovi");
		user.setEmail("testovu");
		user.setPassword("testovi");
		user.setRole(UserRole.ROLE_ADMIN);
		
		
		userService.save(user);
		
		users = userRepo.findAll();
		assertThat(users, hasSize(1));
		
		User userFromDB = userRepo.findAll().stream().findFirst().get();
		
		List<Product> products = productRepo.findAll();
		assertThat(products, hasSize(0));
		
		Product product = new Product();
		product.setName("product");
		product.setDescription("some description words");
		product.setPrice(10d);
		
		Product product1 = new Product();
		product1.setName("product 1");
		product1.setDescription("some description words");
		product1.setPrice(101d);
		
		productRepo.saveAll(Arrays.asList(product,product1));
		
		products = productRepo.findAll();
		assertThat(products, hasSize(2));
		
		List<Product> productsFromDB = productRepo.findAll();
		
		List<Basket> baskets = basketRepo.findAll();
		assertThat(baskets, hasSize(0));
	
		Date date = new Date();
		
		Basket basket = new Basket();
		basket.setProduct(productsFromDB.get(0));
		basket.setUser(userFromDB);
		basket.setPurchase_date(date);
		
		Basket basket1 = new Basket();
		basket1.setProduct(productsFromDB.get(1));
		basket1.setUser(userFromDB);
		basket1.setPurchase_date(date);
		
		basketRepo.saveAll(Arrays.asList(basket,basket1));
		
		baskets = basketRepo.findAll();
		assertThat(baskets, hasSize(2));
	
	}
}
