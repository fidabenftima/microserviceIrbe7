package com.upload.app.web;

import java.util.List;
import com.upload.app.messages.ResponseMessage;
import com.upload.app.model.FileInfo;
import com.upload.app.service.FilesStorageService;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@Controller
@CrossOrigin("*")
public class FilesController {
	@Autowired
	FilesStorageService storageService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			String filename = storageService.save(file ,"");
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(filename));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@PostMapping("/upload/publication")
	public ResponseEntity<ResponseMessage> uploadFilePublication(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			String filename = storageService.save(file , "publication");
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(filename));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@PostMapping("/upload/profile")
	public ResponseEntity<ResponseMessage> uploadFileProfile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			String filename = storageService.save(file , "profile");
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(filename));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@PostMapping("/upload/groupe")
	public ResponseEntity<ResponseMessage> uploadFileGroupe(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			String filename = storageService.save(file , "groupe");
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(filename));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@PostMapping("/upload/article")
	public ResponseEntity<ResponseMessage> uploadFileArticle(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			String filename = storageService.save(file , "article");
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(filename));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@GetMapping("/files")
	public ResponseEntity<List<FileInfo>> getListFiles() {
		List<FileInfo> fileInfos = storageService.loadAll().map(path -> {
			String filename = path.getFileName().toString();
			String url = MvcUriComponentsBuilder
					.fromMethodName(FilesController.class, "getFile", path.getFileName().toString()).build().toString();
			return new FileInfo(filename, url);
		}).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	}

	@RequestMapping(value = "/files/**", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Resource> getFile(HttpServletRequest request) {
		String filename = request.getRequestURL().toString();
		filename = filename.substring(filename.indexOf("files") + 5);
		Resource file = storageService.load(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}
}