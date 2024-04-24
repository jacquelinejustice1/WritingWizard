package Database;

import DataStructures.*;

import java.util.*;

public class DatabaseManager {

    private static final Database db = new Database();

    /**
     * Determine if a username has already been used
     * @param username username to find
     * @return if username was found
     */
    public static boolean userExists(String username) {
        User[] users = db.readUsers();

        for(User user : users)
            if(user.getName().equals(username))
                return true;

        return false;
    }

    /**
     * Determines if a file exists
     * @param file TextFile to find
     * @return if file was found
     */

    //public static boolean fileExists(TextFile file) {

    //}

    /**
     * Verifies a user
     * @param username
     * @param password
     * @return User if valid, null if invalid
     */
    public static User validateAccount(String username, String password) {
        User[] users = db.readUsers();

        for(User user : users)
            if(user.getName().equals(username) && user.getPassword().equals(password))
                return user;

        return null;
    }

    /**
     * Adds user to database
     * @param user user to add to database
     */
    public static void createAccount(User user) {
        User[] users = db.readUsers();

        ArrayList<User> userList = new ArrayList<>(Arrays.asList(users));
        userList.add(user);
        users = new User[userList.size()];
        users = userList.toArray(users);

        db.writeUsers(users);
    }

    /**
     * Saves file to database by adding it to database or overwriting previous version
     * @param file textFile to save
     */
    public static void saveFile(TextFile file) {
        TextFile[] allFiles = db.readFiles();

        for(TextFile textFile : allFiles) {
            if(textFile.getFileName().equals(file.getFileName())
                    && textFile.getOwnerName().equals(file.getOwnerName())) {

                textFile.setContent(file.getContent());
                textFile.setPermissions(file.getPermissions());

                //Write textFiles
                db.writeFiles(allFiles);

                //Write permissions
                Permission[] allPerms = db.readPermissions();
                ArrayList<Permission> permsList = new ArrayList<>(Arrays.asList(allPerms));

                for(Permission perm : textFile.getPermissions()) {
                    if (!permsList.contains(perm)) {
                        permsList.add(perm);
                    } else {
                        permsList.remove(perm);
                        permsList.add(perm);
                    }
                }

                allPerms = new Permission[permsList.size()];
                allPerms = permsList.toArray(allPerms);

                db.writePermissions(allPerms);

                return;
            }
        }

        ArrayList<TextFile> fileList = new ArrayList<>(Arrays.asList(allFiles));
        fileList.add(file);
        TextFile[] files = new TextFile[fileList.size()];
        files = fileList.toArray(files);

        db.writeFiles(files);
    }

    /**
     * Gets all files a user has access to
     * @param user
     * @return files accessible to the user
     */
    public static TextFile[] getUserFiles(User user) {
        TextFile[] allFiles = db.readFiles();
        ArrayList<TextFile> userFilesList = new ArrayList<>();

        for(TextFile file : allFiles) {

            file.setPermissions(getFilePermissions(file));

            if(file.getOwnerName().equals(user.getName())) {
                userFilesList.add(file);
                continue;
            }

            for(Permission perm : file.getPermissions())
                if(perm.getUsername().equals(user.getName()) && perm.getPermissionLevel() != PermissionLevel.none){
                    userFilesList.add(file);
                    break;
                }
        }

        TextFile[] userFiles = new TextFile[userFilesList.size()];
        userFiles = userFilesList.toArray(userFiles);

        return userFiles;
    }

    /**
     * Deletes a file from storage
     * @param file file to be deleted
     * @return true if any files were deleted
     */
    public static boolean deleteFile(TextFile file) {
        TextFile[] allFiles = db.readFiles();
        ArrayList<TextFile> fileList = new ArrayList<>(Arrays.asList(allFiles));

        boolean success = fileList.removeIf(textFile -> (file.getOwnerName().equals(textFile.getOwnerName())
                && file.getFileName().equals(textFile.getFileName())));

        allFiles = new TextFile[fileList.size()];

        allFiles = fileList.toArray(allFiles);

        db.writeFiles(allFiles);

        return success;
    }

    private static Permission[] getFilePermissions(TextFile file) {
        Permission[] allPerms = db.readPermissions();
        ArrayList<Permission> filePermList = new ArrayList<>();
        Permission[] filePerms;

        for(Permission perm : allPerms) {
            if(perm.getFileName().equals(file.getFileName()) && perm.getOwnerName().equals(file.getOwnerName()))
                filePermList.add(perm);
        }

        filePerms = new Permission[filePermList.size()];
        filePerms = filePermList.toArray(filePerms);

        return filePerms;
    }
}