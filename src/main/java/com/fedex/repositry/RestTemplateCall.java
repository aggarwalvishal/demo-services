package com.fedex.repositry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fedex.dto.EmpSkills;

@Configuration
public class RestTemplateCall {
	@Autowired
	private RestTemplate restTemplate;

	//ObjectMapper mapper = new ObjectMapper();
	//List<EmpSkills> emp = new ArrayList<EmpSkills>();

	/*
	 * public List<EmpSkills> getAllSkill() throws JsonMappingException,
	 * JsonProcessingException {
	 * 
	 * EmpSkills[] result =
	 * restTemplate.getForObject("http://localhost:8083/skills", EmpSkills[].class);
	 * // mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	 * List<EmpSkills> e2 = Arrays.asList(result); return e2; }
	 */

	public EmpSkills getSkillByName(String name) throws JsonMappingException, JsonProcessingException {

		EmpSkills result = restTemplate.getForObject("http://localhost:8083/v1/getSkillByName/" + name,
				EmpSkills.class);
		return result;
	}
}
