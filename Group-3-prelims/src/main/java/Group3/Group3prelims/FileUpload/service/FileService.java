package Group3.Group3prelims.FileUpload.service;

import java.io.BufferedReader;
import java.util.List;

import Group3.Group3prelims.FileUpload.entity.File;


public interface FileService {
	public File saveFile(File file);
	public List<File> getAllFiles();
}
