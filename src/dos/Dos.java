package dos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Dos {
	String path = "C:\\Temp";
	Scanner sc = null;
	File file = null;

	public static void main(String[] args) {
		Dos dos = new Dos();
		dos.start();

	}
	void start() {

		do {
			try {
				System.out.println("rename 파일명 새로운파일명");
				System.out.println("type 파일명");
				System.out.println("mkdir 생성디렉토리명");
				sc = new Scanner(System.in);
				String str = sc.nextLine();
				String arr[] = str.split(" ");

				switch (arr[0]) {
				case "rename":
					rename(arr);
					break;
				case "type":
					type(arr);
					break;
				case "mkdir":
					mkdir(arr);
					break;
				default:
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (true);
	}

	void rename(String[] arr) {
		String path1 = path + "\\" + arr[1];
		String path2 = path + "\\" + arr[2];

		file = new File(path1);
		if (file.exists()) {
			file.renameTo(new File(path2));
		} else
			System.out.println("존재하지 않는 파일");
	}

	void type(String[] arr) {
		file = new File(path + "\\" + arr[1]);
		if (file.exists()) {
			// 존재
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String data = "";
				while ((data = br.readLine()) != null) {
					System.out.println(data);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			System.out.println("존재하지 않는 파일");
	}

	void mkdir(String[] arr) {
		file = new File(path + "\\" + arr[1]);
		file.mkdir();
	}
	
	void dir(String[] args) {
		file = new File(path);
	}
}
