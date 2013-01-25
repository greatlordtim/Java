import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Music {
	final double TWELVE_ROOT_TWO;
	private int bpm;
	public Music(int b) {
		TWELVE_ROOT_TWO = Math.pow(2, 1./12.);
		bpm = b;
	}

	public void execShellCmd(String cmd) {
		try {
			Runtime runtime = Runtime.getRuntime();
			Process process = runtime.exec(new String[] {"/bin/bash", "-c", cmd});
			int exitValue = process.waitFor();
			BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = "";
			while ((line = buf.readLine()) != null) {
				System.out.println("exec response: " + line);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public int NoteToFreq(char note, char acc, int scale) {
		int dif = 0;
		boolean stop = false;
		switch (note) {
			case 'a': dif = 0; break;
			case 'b': dif = 2; break;
			case 'c': dif = -9; break;
			case 'd': dif = -7; break;
			case 'e': dif = -5; break;
			case 'f': dif = -4; break;
			case 'g': dif = -2; break;
			case 'A': dif = 0; break;
			case 'B': dif = 2; break;
			case 'C': dif = -9; break;
			case 'D': dif = -7; break;
			case 'E': dif = -5; break;
			case 'F': dif = -4; break;
			case 'G': dif = -2; break;
			case 'R': stop = true; break;
			case 'r': stop = true; break;
		}
		switch (acc) {
			case '#': dif++; break;
			case 'b': dif--; break;
		}
		dif += (scale-4)*12;
		if (stop)
			return -1;
		else
			return (int)(Math.round((440*Math.pow(TWELVE_ROOT_TWO,dif))));
	}

	public void PlayNote(int freq, double dur) {
		try {
			if (freq != -1) {
				execShellCmd("xset b 100 "+freq+" "+(int)((bpm/60)*200*dur));
				System.out.print("\007");
			}
			Thread.sleep((int)((1000./(bpm/60.)*dur)*.9));
		} catch (InterruptedException ie) {}
	}

	public static void main (String[]args) {
		///create file scanner
		Scanner input, file = null;
		String filename;
		input = new Scanner(System.in);
		System.out.print("Enter filename: ");
		filename = input.nextLine();
		try {
			file = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.err.println("Error: file not found");
			System.exit(1);
		}
		///play music
		String[] currentNote;
		char note, accidental;
		int scale;
		double duration;
		Music music = new Music(file.nextInt());
		file.nextLine();
		while (file.hasNextLine()) {
			String temp = file.nextLine();
			System.out.println(temp);
			currentNote = temp.split(" ");
			///get note
			note = currentNote[0].charAt(0);
			///get accidental
			if (currentNote[0].length() == 2)
				accidental = currentNote[0].charAt(1);
			else
				accidental = ' ';
			///get scale
			scale = Integer.parseInt(currentNote[1]);
			///get duration
			duration = Double.parseDouble(currentNote[2]);
			///play note
			music.PlayNote(music.NoteToFreq(note, accidental, scale), duration);
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException ie) {}
		music.execShellCmd("xset b off");
	}
}
