package edu.cuny.csi.csc330.fileio;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONSerializer extends  BaseSerializer  {


	private void run() {
		ObjectMapper mapper = new ObjectMapper();

		Person person = createDummyObject();

		try {
			// Convert object to JSON string and save into a file directly
			mapper.writeValue(new File("C:\\tmp\\person.json"), person);

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(person);
			System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
			System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	

	public static void main(String[] args) {
		JSONSerializer tester = new JSONSerializer();
		tester.run();
	}

}






  
