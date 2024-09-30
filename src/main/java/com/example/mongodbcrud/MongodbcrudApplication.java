package com.example.mongodbcrud;

import com.example.mongodbcrud.services.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbcrudApplication implements CommandLineRunner {

	@Autowired
	private IndexService indexService;

	public static void main(String[] args) {
		SpringApplication.run(MongodbcrudApplication.class, args);
	}

	@Override
	public void run (String... args) throws Exception{
		indexService.createNormalIndexes();
		indexService.createCompoundIndex();
	}

}
