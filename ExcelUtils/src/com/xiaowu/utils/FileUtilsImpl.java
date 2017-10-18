package com.xiaowu.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtilsImpl  implements FileUtils{
		private File file;

		public File getFile() {
			return file;
		}

		public void setFile(File file) {
			this.file = file;
		}

		@Override
		public void OpenFile(String file) throws FileNotFoundException, IOException {
			this.file = new File(file);
		}

		@Override
		public void CreateFile(String file) {
			this.file = new File(file);
		}

		@Override
		public boolean DeleteFile(final String fileName) {
			// TODO Auto-generated method stub
			File file = new File(fileName);
	        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
	        if (file.exists() && file.isFile()) {
	            if (file.delete()) {
	                System.out.println("删除单个文件" + fileName + "成功！");
	                return true;
	            } else {
	                System.out.println("删除单个文件" + fileName + "失败！");
	                return false;
	            }
	        } else {
	            System.out.println(  fileName + "不存在！");
	            return false;
	        }
		}
		
}
