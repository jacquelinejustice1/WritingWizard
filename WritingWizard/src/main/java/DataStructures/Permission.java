package DataStructures;


import java.io.Serializable;

/**
 * @author benbruyns
 * Contains username and corresponding permission level for a file
 */
public class Permission implements Serializable {
    private final String username;
    private final String fileName;
    private final String ownerName;
    private PermissionLevel permissionLevel;

    /**
     * Constructor for Permission class
     * @param username of user
     * @param permissionLevel of user
     */
    public Permission(String username, PermissionLevel permissionLevel, String fileName, String ownerName) {
        this.username = username;
        this.permissionLevel = permissionLevel;
        this.fileName = fileName;
        this.ownerName = ownerName;
    }

    /**
     * username accessor
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * filename accessor
     * @return filename
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * ownerName accessor
     * @return name of file owner
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * permissionLevel accessor
     * @return permission level
     */
    public PermissionLevel getPermissionLevel() {
        return permissionLevel;
    }

    /**
     * permissionLevel mutator
     * @param permissionLevel desired permission level
     */
    public void setPermissionLevel(PermissionLevel permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    @Override
    public boolean equals(Object o) {
        if(o != null && o.getClass() == Permission.class) {
            Permission p = (Permission) o;
            return username.equals(p.username) && fileName.equals(p.fileName) && ownerName.equals(p.ownerName);
        }

        return false;
    }
}
