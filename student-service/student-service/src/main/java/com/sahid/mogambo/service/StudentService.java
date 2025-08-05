package com.sahid.mogambo.service;

import com.sahid.mogambo.entity.Student;
import com.sahid.mogambo.feignclients.AddressFeignClient;
import com.sahid.mogambo.jpa.StudentRepository;
import com.sahid.mogambo.req_res.AddressResponse;
import com.sahid.mogambo.req_res.CreateStudentRequest;
import com.sahid.mogambo.req_res.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	WebClient webClient;

	@Autowired
	AddressFeignClient addressFeignClient;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		student.setAddressId(createStudentRequest.getAddressId());
		student = studentRepository.save(student);

		StudentResponse studentResponse = new StudentResponse(student);

//		Using WebClient Bean
//		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

//		Using FeignClient interface
		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));

		return studentResponse;
	}
	
	public StudentResponse getById (long id) {
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);

//		Using WebClient Bean
//		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));

//		Using FeignClient interface
		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));
		return studentResponse;
	}

	//Using WebClient Bean
	public AddressResponse getAddressById(long addressId){

		Mono<AddressResponse> addressResponseMono =  webClient.get().uri("/getById/" + addressId)
				.retrieve().bodyToMono(AddressResponse.class);

		return addressResponseMono.block();

	}

}
