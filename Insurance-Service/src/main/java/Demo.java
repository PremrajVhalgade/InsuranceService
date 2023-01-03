import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.insurance.model.Insurance;
import com.insurance.model.Policy;
import com.insurance.model.User;

public class Demo {
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
	
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		
		Policy policy = new Policy();
		
		User user1 = new User();
		user1.setFullName("Laxman Mule");
		user1.setDob(LocalDate.of(1991, 03, 27));
		user1.setRelation("self");
		user1.setPolicy(policy);

		User user2 = new User();
		user2.setFullName("Vinita Mule");
		user2.setDob(LocalDate.of(1995, 05, 15));
		user2.setRelation("wife");
		user2.setPolicy(policy);

		User user3 = new User();
		user3.setFullName("Shruti Mule");
		user3.setDob(LocalDate.of(2020, 04, 12));
		user3.setRelation("daughter");
		user3.setPolicy(policy);

		List userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);

//		Insurance insurance = new Insurance();
//		insurance.setPolicy(policy);
		
		ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(policy);
		System.out.println(json);
		
	}

}
