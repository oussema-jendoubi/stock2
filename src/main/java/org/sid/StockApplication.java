package org.sid;

import org.sid.Repository.StructureRepository;
import org.sid.entities.Structure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StockApplication implements CommandLineRunner  {
	@Autowired
        private StructureRepository structureRepository ;
        
	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		structureRepository.save(new Structure("aaa"));
		structureRepository.save(new Structure("bbb"));
		structureRepository.save(new Structure("ccc"));
		structureRepository.save(new Structure("ddd"));
		structureRepository.save(new Structure("eee"));
		structureRepository.findAll().forEach(s->{
			System.out.println(s.getNom());
		}
		);
		
		
		
		};
	}


