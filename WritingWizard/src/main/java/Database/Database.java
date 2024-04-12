package Database;

import java.io.*;
import DataStructures.*;

public class Database {
    private static String userFile = "Users.dat";
    private static String fileFile = "TextFiles.dat";

    /***
     * Read from user file
     * @return all users
     */
    public User[] readUsers() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(userFile));
            User[] users = (User[]) in.readObject();
            in.close();
            return users;
        } catch (ClassNotFoundException ex) {
        } catch (Exception e) {
        }
        return new User[0];
    }

    /***
     * Write to user file
     * @param users updated users array
     */
    public void writePermissions(User[] users) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(userFile, false));
            out.writeObject(users);
            out.close();
        } catch (IOException ex) {
            System.out.println("Error writing updated Permissions!");
        }
    }

    /***
     * Read from user file
     * @return all users
     */
    public TextFile[] readFiles() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileFile));
            TextFile[] files = (TextFile[]) in.readObject();
            in.close();
            return files;
        } catch (ClassNotFoundException ex) {
        } catch (Exception e) {
        }
        return new TextFile[0];
    }

    /***
     * Write to user file
     * @param files updated files array
     */
    public void writeFiles(TextFile[] files) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileFile, false));
            out.writeObject(files);
            out.close();
        } catch (IOException ex) {
            System.out.println("Error writing updated Permissions!");
        }
    }
}
