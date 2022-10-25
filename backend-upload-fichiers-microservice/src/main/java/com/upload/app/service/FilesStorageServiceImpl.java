package com.upload.app.service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {
	private final Path root = Paths.get("uploads");
	private final Path rootPublications = Paths.get("uploads/publications");
	private final Path rootProfile = Paths.get("uploads/profile");
	private final Path rootGroupe = Paths.get("uploads/groupe");
	private final File froot = new File("uploads/groupe");
	private final File frootPublications = new File("uploads/publications");
	private final File frootProfile = new File("uploads/profile");
	private final File frootGroupe = new File("uploads/groupe");
	
	
	@Override
	public void init() {
		//Files.createDirectory(root);
		//Files.createDirectory(rootPublications);
		//Files.createDirectory(rootProfile);
		//Files.createDirectory(rootGroupe);
		if(!froot.exists()) froot.mkdirs();
		if(!frootGroupe.exists()) frootGroupe.mkdirs();
		if(!frootProfile.exists()) frootProfile.mkdirs();
		if(!frootPublications.exists()) frootPublications.mkdirs();
	}


	@Override
	public String save(MultipartFile file, String type) {
		
		Calendar date = new GregorianCalendar();
		
		String finalString = "uploads/" + type + "/" + date.get(Calendar.YEAR) + "/"
				+ (date.get(Calendar.MONTH) + 1) + "/" + date.get(Calendar.DAY_OF_MONTH);
		File newFilePath = new File(Paths.get("uploads/" + type) + "/" + date.get(Calendar.YEAR) + "/"
				+ (date.get(Calendar.MONTH) + 1) + "/" + date.get(Calendar.DAY_OF_MONTH));
		
		if (!newFilePath.exists()) newFilePath.mkdirs();

		String newFilename = new Date().getTime() + "-" + UUID.randomUUID().toString() 
				+ file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
		
		try {
			Files.copy(file.getInputStream(), newFilePath.toPath().resolve(newFilename));
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
		return finalString + "/" + newFilename;
	}

	
	@Override
	public Resource load(String filename) {
		try {
			String folders = filename.substring(8);
			File file = new File("uploads" + folders);
			
			Resource resource = new UrlResource(file.toURI());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Could not read the file!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(root.toFile());
	}

	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
		} catch (IOException e) {
			throw new RuntimeException("Could not load the files!");
		}
	}
}