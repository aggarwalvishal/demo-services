package com.fedex.repositry;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fedex.dto.EmpSkills;

@RunWith(MockitoJUnitRunner.class)
public class RestTemplateCallTest 
{
	@Mock
	private RestTemplate restTemplate;
	@InjectMocks
	private RestTemplateCall restCall = new RestTemplateCall();
	
	
	
	EmpSkills skill = new EmpSkills();
	
	@Before
	public void createDummyCall()
	{
		skill.setSkillId(2);
		skill.setSkillName("Java");
	}
	@Test
	public void getSkillByNameTest() throws JsonMappingException, JsonProcessingException
	{
		when(restCall.getSkillByName(skill.getSkillName())).thenReturn(skill);
		
		assertEquals(restCall.getSkillByName(skill.getSkillName()), skill);
		
	}
}
