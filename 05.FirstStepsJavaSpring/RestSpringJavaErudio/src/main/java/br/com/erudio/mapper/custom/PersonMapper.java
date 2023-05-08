package br.com.erudio.mapper.custom;

import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.model.Person;

@Service
public class PersonMapper {
	
	public PersonVOV2 convertEntityToVO(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setFirstName(person.getLastName());
		vo.setLastName(person.getLastName());
		vo.setAddress(person.getAddress());
		vo.setBirthDate(person.getBirthDate());
		vo.seteMail(person.geteMail());
		vo.setGender(person.getGender());
		vo.setDocument("");
		return vo;
	}
	
	public Person convertVOToEntity(PersonVOV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setBirthDate(person.getBirthDate());
		entity.seteMail(person.geteMail());
		entity.setGender(person.getGender());
		return entity;
	}
}
