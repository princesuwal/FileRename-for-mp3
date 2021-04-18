package rename;

import java.io.*;

public class RenameFolder {
	private File[] file;
	private File[] f_in;
	public int depth = 0;
	
	
	public RenameFolder(String s){
		file = new File(s).listFiles(File::isDirectory);
		for(int i = 0; i < file.length; i++){
			System.out.println(file[i]);
			insideFolder(file, i);
		}
	}
	
	/*public String getFile(int i){
		return this.file[i].getAbsolutePath();
	}*/
	
	public void readFiles(File[] afile, int i, int depth){
		File[] all_file = new File(afile[i].getAbsolutePath()).listFiles(File::isFile);
		if(all_file.length > 0){
			for(int j = 0; j < all_file.length; j++){
				for(int k = 0; k < depth + 1; k++){
					System.out.print("\t");
				}
					System.out.println(all_file[j].getName());
					//if(depth == 1)
						System.out.println("go to: " + all_file[j].getParentFile().getName());
			}
		}
	}
	
	public void renameFiles(File[] afile, int i, int depth){
		String Path = "";
		String OriginalName = "";
		String renameTo = "";
		File[] all_file = new File(afile[i].getAbsolutePath()).listFiles(File::isFile);
		if(all_file.length > 0){
			for(int j = 0; j < all_file.length; j++){
				for(int k = 0; k < depth + 1; k++){
					System.out.print("\t");
				}
					OriginalName = all_file[j].getName();  //mp3name
					Path =  f_in[0].getParent();  //goto
					renameTo = all_file[j].getParentFile().getAbsolutePath() + "--- " + OriginalName;
					File oldFile = new File(all_file[j].getAbsolutePath());
					File newFile = new File(renameTo);
					if(oldFile.renameTo(newFile)){
						System.out.println("Success");
						System.out.println(renameTo);
					}
					
			}
		}
	}
	
	public void insideFolder(File[] afile, int i){
		File[] f = new File(afile[i].getAbsolutePath()).listFiles(File::isDirectory);
		if(depth == 0){
			f_in = new File(afile[i].getAbsolutePath()).listFiles(File::isDirectory);
			if(f_in.length > 0){
				System.out.println("Parent Name  :  " + f_in[0].getName());
			}
		}
		if(f.length > 0){
			for(int j = 0; j < f.length; j++){
				for(int k = 0; k <= depth; k++)
					System.out.print("\t");
				if(f_in[0].getParent().contentEquals(f[j].getParent())){
					System.out.println("Album name:  " + f[j].getName());
				}else{
					System.out.println("Album name:  " + f[j].getName());
				}
				
				//System.out.println("     :  " + f_in[i].getAbsolutePath());
				
				depth += 1;
				insideFolder(f,j);
				renameFiles(f, j, depth);
				depth -= 1;
			}
		}
	}
	
	public static void main(String args[]){
		RenameFolder re = new RenameFolder("D:\\");
	}
}
