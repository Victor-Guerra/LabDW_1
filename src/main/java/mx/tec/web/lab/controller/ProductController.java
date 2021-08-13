package mx.tec.web.lab.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.web.lab.manager.ProductManager;
import mx.tec.web.lab.vo.Product; 

@RestController
public class ProductController {
	@Resource
	private ProductManager productManager;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = productManager.getProducts();
		ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(products, HttpStatus.OK);
		return responseEntity;
		} 
	
	@GetMapping("/products/{id}")		
	public ResponseEntity<Product> getProduct(@PathVariable(value = "id") String id) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		Optional<Product> product = productManager.getProduct(id);
		if (product.isPresent()) {
			responseEntity = new ResponseEntity<>(product.get(), HttpStatus.OK);
			}
		return responseEntity;
		}
	
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product newProduct) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		Optional<Product> product = productManager.addProduct(newProduct);
		
		if (product.isPresent()) {
			responseEntity = new ResponseEntity<>(product.get(), HttpStatus.CREATED);
		}
		return responseEntity;
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> modifyProduct(@RequestBody Product replacement, @PathVariable(value = "id") String id) {
		ResponseEntity<Product> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	
		productManager.setProduct(id, replacement);
		Optional<Product> replaced = productManager.getProduct(id);

		
		if (replaced.isPresent()) {
			responseEntity = new ResponseEntity<>(replaced.get(), HttpStatus.ACCEPTED);
		}
		return responseEntity;
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<List<Product>> deleteProduct(@PathVariable(value = "id") String id) {
		ResponseEntity<List<Product>> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		Optional<Product> product = productManager.getProduct(id);
		
		if (product.isPresent()) {
			productManager.deleteProduct(id);
			
			responseEntity = new ResponseEntity<List<Product>>(productManager.getProducts(), HttpStatus.ACCEPTED);
		}
		return responseEntity;
	}
} 

