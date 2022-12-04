package Group3.Group3prelims.FileUpload.service;


import java.io.BufferedReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Group3.Group3prelims.FileUpload.entity.File;
import Group3.Group3prelims.FileUpload.repository.IFileRepository;


@Service
public class FileServiceImpl implements FileService {
	@Autowired
	private IFileRepository fileRepository;
	
	public File saveFile(File file) {
		return fileRepository.saveAndFlush(file);
	}
}
