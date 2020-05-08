package ua.yurii.zhurakovskyi.springfileupload.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javassist.NotFoundException;
import ua.yurii.zhurakovskyi.springfileupload.domain.Student;
import ua.yurii.zhurakovskyi.springfileupload.dto.StudentUploadResponse;
import ua.yurii.zhurakovskyi.springfileupload.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@PostMapping("/uploadStudent")
	public StudentUploadResponse uploadStudent(@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("age") Integer age,
			@RequestParam("file") MultipartFile file) throws IOException {
		Student student = studentService.storeStudent(firstName, lastName, age, file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadStudent/")
				.path(student.getId()).toUriString();
		return new StudentUploadResponse(student.getFirstName(), student.getLastName(), student.getAge(),
				student.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
	}

	@GetMapping("/downloadStudent/{studentId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String studentId) throws NotFoundException {
		Student student = studentService.getStudent(studentId);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(student.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + student.getFileName() + "\"")
				.body(new ByteArrayResource(student.getData()));
	}
}
