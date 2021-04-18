package rename;

import java.io.*;

public class MP3Rename {
	private File[] file;
	public int depth = 0;
	
	public MP3Rename(String s){
		file = new File(s).listFiles(File::isDirectory);
		for(int i = 0; i < file.length; i++){
			System.out.println(file[i]);
			insideFolder(file, i);
		}
	}
	
	/*public String getFile(int i){
		return this.file[i].getAbsolutePath();
	}*/
	
	public void insideFolder(File[] afile, int i){
		File[] f = new File(afile[i].getAbsolutePath()).listFiles(File::isDirectory);
		//File[] f_in = new File(f[i].getAbsolutePath()).listFiles(File::isDirectory);
		if(f.length > 0){
			for(int j = 0; j < f.length; j++){
				for(int k = 0; k <= depth; k++)
					System.out.print("\t");
				System.out.println(f[j].getName());
				depth += 1;
				insideFolder(f,j);
				depth -= 1;
			}
		}
	}
	
	public static void main(String args[]){
		MP3Rename re = new MP3Rename("C:\\Users\\princ\\Music\\pas");
	}
}
