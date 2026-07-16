package spatularat.lonelynation.client.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonFileManager {

	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

	public static void createFile(String PATH, Object TYPE){

		Path path = Path.of(PATH);

		if (!Files.exists(path)) {
			try {
				Files.createDirectories(path.getParent());

				try (BufferedWriter writer = Files.newBufferedWriter(path)){
					GSON.toJson(TYPE, writer);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static <T> T loadFile(String PATH, Class<T> TYPE) {

		Path path = Path.of(PATH);

		try (BufferedReader reader = Files.newBufferedReader(path)) {
			return GSON.fromJson(reader,TYPE);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void saveFile(String PATH, Object TYPE) {

		Path path = Path.of(PATH);
		try {
			Files.createDirectories(path.getParent());

			try (BufferedWriter writer = Files.newBufferedWriter(path)) {
				GSON.toJson(TYPE,writer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}