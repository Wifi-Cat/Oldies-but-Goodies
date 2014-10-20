package song;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int records = Integer.parseInt(sc.nextLine().trim());
		LinkedList<Song> songs = new LinkedList<Song>();
		for (int i = 0; i < records; i++) {
			songs.add(new Song(sc.nextLine().trim()));
		}
		while (true) {
			String played = sc.nextLine();
			if (played.equals("PSEUDO_EOF")) {
				break;
			}
			Song song = null;
			for (int i = 0; i < songs.size(); i++) {
				song = songs.get(i);
				if (song.name.equals(played)) {
					break;
				}
			}
			if (song != null) {
				song.playCount++;
				songs.remove(song);
				songs.push(song);
			}
		}
		int total = 0;
		for (int i = 0; i < songs.size(); i++) {
			System.out.printf("%-20s%8d\n", songs.get(i).name,
					songs.get(i).playCount);
			total += songs.get(i).playCount;
		}
		System.out.println("----------------------------");
		System.out.printf("%-20s%8d\n", "TOTAL", total);
		sc.close();
	}
}

class Song {
	public final String name;
	public int playCount;

	public Song(String name) {
		this.name = name;
		this.playCount = 0;
	}

	@Override
	public String toString() {
		return name;
	}
}
