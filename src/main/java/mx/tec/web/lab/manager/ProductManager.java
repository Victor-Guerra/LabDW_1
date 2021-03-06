package mx.tec.web.lab.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mx.tec.web.lab.vo.Product;
import mx.tec.web.lab.vo.Sku;

@Service
public class ProductManager {
	private List<Product> products;
	
	public ProductManager() {
		products = new ArrayList<>();
		
		Product product1 = new Product("prod123", "Levi's 501 Original Fit Jeans Jeans para Hombre", "100% algodon, Cierre de Cremallera, Lavar a maquina, Jeans corte ajustado, Pierna ajustada, Stretch especial que te brinda mayor movilidad", Collections.emptyList());
		List<Sku> childSkus1 = new ArrayList<>();
		childSkus1.add(new Sku("sku1234", "Black", "29W X 32L", 1027.24, 1027.24, 500, "", "", ""));
		childSkus1.add(new Sku("sku1235", "Dark Stonewash", "29W X 32L", 1027.24, 706.93, 200, "", "", ""));
		product1.setChildSkus(childSkus1);
		products.add(product1); 
		
		Product product2 = new Product("prod124", "Levi's Innovation Super Skinny Jeans para Mujer", "85% Algodon, 9% Elastomultiester, 6% Elastano, Lavar a maquina, Pantalon, Mezclilla, Cintura Media, Ajustado Desde la Cadera al Muslo, Pierna Super Ajustada", Collections.emptyList());
		List<Sku> childSkus2 = new ArrayList<>();
		childSkus2.add(new Sku("sku1236", "Black Galaxy", "25W X 30L", 661.79, 661.79, 300, "", "", ""));
		childSkus2.add(new Sku("sku1237", "Black Galaxy", "26W X 30L", 661.79, 661.79, 400, "", "", ""));
		childSkus2.add(new Sku("sku1238", "Black Galaxy", "27W X 30L", 661.79, 661.79, 800, "", "", ""));
		product2.setChildSkus(childSkus2);
		products.add(product2); 
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public Optional<Product> getProduct(final String id) {
		Optional<Product> foundProduct = Optional.empty();
		for (final Product product : products) {
			if (product.getId().equals(id)) {
				foundProduct = Optional.of(product);
				break; 
				} 
			} 
		
		return foundProduct;
		} 
	
	public Optional<Integer> getIndex(final String id) {
		int i = 0;
		for ( Product product : products) {
			if (product.getId().equals(id)) {

				return Optional.of(i);
				} 
			i = i + 1;
			} 
		return Optional.empty();
		
	}
	
	public void deleteProduct(final String id) {
		
		if (getIndex(id).isPresent()) {
			products.remove(getProduct(id).get());
		}
		
	}
	
	public void setProduct(final String id, final Product replacement) {
		Optional<Integer> idx = this.getIndex(id);
		if (idx.isPresent()) {
			products.set(idx.get(), replacement);
		}
	} 
	
	public Optional<Product> addProduct(final Product newProduct) {
		products.add(newProduct);
		return Optional.of(newProduct);
	}
}
