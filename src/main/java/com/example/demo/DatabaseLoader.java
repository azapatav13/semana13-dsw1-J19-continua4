package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final ProductoRepository pro;
	private final CategoriaRepository cat;

	@Autowired
	public DatabaseLoader(
		ProductoRepository pro,
		CategoriaRepository cat
		) {
		this.pro=pro;
		this.cat=cat;
	}

	@Override
	public void run(String... strings) throws Exception {
		Categoria categoria1=new Categoria("Deportes");
		Categoria categor2=new Categoria("Armario");
		this.cat.save(categoria1);
		this.cat.save(categor2);
		Producto zapatillas=new Producto("Zapattillas Start",30.50f,categoria1);
		Producto chimpunes=new Producto("Chimpunes",99.99f,categoria1);
		Producto vestido=new Producto("Vestido Azul",45.50f,categor2);
		Producto sunga=new Producto("Sunga",15.50f,categor2);
		this.pro.save(zapatillas);
		this.pro.save(chimpunes);
		this.pro.save(vestido);
		this.pro.save(sunga);
	}
}