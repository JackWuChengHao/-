package com.xiaowu.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileUtils {
	public void OpenFile(final String filename) throws FileNotFoundException, IOException ;
	public void CreateFile(final String filename);
	boolean DeleteFile(final String filename);
}
