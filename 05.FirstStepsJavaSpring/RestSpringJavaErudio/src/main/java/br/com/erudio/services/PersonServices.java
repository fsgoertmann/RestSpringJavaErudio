package br.com.erudio.services;

import java.text.ParseException;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonServices {
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	PersonMapper mapper;
	
	public List<PersonVO> findAll() throws ParseException {
		logger.info("Finding all people!");
		return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class) ;
	}

	public PersonVO findById(Long id) throws ParseException {
		
		logger.info("Finding one Person");
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerMapper.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO create(PersonVO person) throws ParseException {
		logger.info("Registering a Person");
		Person entity = DozerMapper.parseObject(person, Person.class);
		PersonVO vo = DozerMapper.parseObject(repository.save(entity),PersonVO.class);
		return vo;		
	}
	
	public PersonVO update(PersonVO person) throws ParseException {
		logger.info("Updating a Person info");
		
		Person entity = repository.findById(person.getId())
		.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		entity.seteMail(person.geteMail());
		entity.setBirthDate(person.getBirthDate());
		
		PersonVO vo = DozerMapper.parseObject(repository.save(entity),PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) throws ParseException {
		logger.info("Deleting a Person");
		
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
	
	public PersonVOV2 createV2(PersonVOV2 person) throws ParseException {
		logger.info("Registering a Person");
		Person entity = mapper.convertVOToEntity(person);
		PersonVOV2 vo = mapper.convertEntityToVO(repository.save(entity));
		return vo;		
	}
}
