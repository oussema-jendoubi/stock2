package org.sid.web;

import org.sid.Repository.StructureRepository;
import org.sid.entities.Structure;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
@RequestMapping("/api")
public class StructureRestService {
    
	@Autowired
	private StructureRepository  structureRepository ;
	
	// **** find all
	
	@RequestMapping(value="/structures",method=RequestMethod.GET)
	public List<Structure> getStructures(){
		return structureRepository.findAll();	
	}
//	 **** chercheer ***
	@RequestMapping(value="/chercherStructures",method=RequestMethod.GET)
	public Page<Structure> chercher(
			
			@RequestParam(name="mc",defaultValue = "") String mc ,
			@RequestParam(name="page",defaultValue = "0") int page ,
			@RequestParam(name="size",defaultValue = "5")int size){
//		return structureRepository.chercher("%"+mc+"%",new PageRequest(page,size));	
		return structureRepository.chercher("%"+ mc+"%", PageRequest.of(page, size));

	}
	
	// **** find one
	
	@RequestMapping(value="/structures/{id}",method=RequestMethod.GET)
	public Optional<Structure>  getStructure(@PathVariable Long id){
		return structureRepository.findById(id);
	}
	
	// **** add
	
	@RequestMapping(value="/structures",method=RequestMethod.POST)
	public Structure addStructure(@RequestBody Structure s){
		return structureRepository.save(s);
          }
	
	// **** delete
	
	@RequestMapping(value="/structures/{id}",method=RequestMethod.DELETE)
	public boolean deleteStructure(@PathVariable Long id){
		structureRepository.deleteById(id);
		return true ;
          }
	
	// **** update
	
	@RequestMapping(value="/structures/{id}",method=RequestMethod.PUT)
	public Structure updateStructure(@PathVariable Long id, @RequestBody Structure s){
		s.setId(id);
		return structureRepository.save(s);
          }
}

	
	
	
	
	
	