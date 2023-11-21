package com.example.bitequestusuario;

import com.example.bitequestusuario.model.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BitequestusuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitequestusuarioApplication.class, args);
	}

}
