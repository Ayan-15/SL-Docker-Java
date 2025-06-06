package Yamingym;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String user_file = "participants_detail.txt";
		String continue_add = "yes";
		FileWriter file_writer = null;
		try {
			// file_writer = new FileWriter(user_file);
			file_writer = new FileWriter(user_file, true);
			do {

				// Accept name from operator;
				System.out.println("Please add participant's name: \n");
				String name = scanner.nextLine();

				// Accept id from operator;
				System.out.println("Please add participant's id: \n");
				int id = Integer.valueOf(scanner.nextLine());
				// Integer.toString(id);

				// Accept the batch from operator;
				System.out.println("Please add participant's batch: \n");
				String batch = scanner.nextLine();

				file_writer.write(name + "," + id + "," + batch + "\n");
				System.out.print("Data written to file. ");

				System.out.print("Do you want to add another person? (yes/no):");
				continue_add = scanner.nextLine();

			} while (continue_add.equalsIgnoreCase("yes"));

		} catch (IOException e) {
			System.out.println("Error occurred while opening the file");
			e.printStackTrace();
		} finally {
			try {
				if (file_writer != null) {
					file_writer.flush(); // to ensure it's written to the file
					file_writer.close(); // Close the file to release the resources
				}
			} catch (IOException e) {
				System.out.println("Error while closing the file.");
				e.printStackTrace();
			}
		}

		// Read from file now -
		// one way of doing...
		try {
			File myObj = new File(user_file);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String[] parsed_data = data.split(",");
				if (parsed_data.length == 3) {
					Participant participant = new Participant(parsed_data[0], Integer.valueOf(parsed_data[1]));
					if (parsed_data[2].contentEquals("E")) {
						Batch batch = new Evening();
						batch.SaveParticipants(participant);
						System.out.println(participant); 
						batch.SendSMS();
					}else if (parsed_data[2].contentEquals("M")) {
						Batch batch = new Morning();
						batch.SaveParticipants(participant);
						System.out.println(participant); 
						batch.SendSMS();
					}
				}
				//System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred while reading the file");
			e.printStackTrace();
		}
		
		// another way of doing...
		/*Files.lines(Paths.get(user_file))
		.map(row->row.split(","))
		.filter(parts->parts.length >= 3)
		.filter(parts->parts[2].equals("E"))
		.map(parts -> new Participant(parts[0], Integer.valueOf(parts[1])))*/

	}

}
