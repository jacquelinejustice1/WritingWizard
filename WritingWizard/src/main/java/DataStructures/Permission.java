package DataStructures;


/**
 * @author benbruyns
 * Contains username and corresponding permission level for a file
 */
public class Permission {
    private final String username;
    private PermissionLevel permissionLevel;

    /**
     * Constructor for Permission class
     * @param username of user
     * @param permissionLevel of user
     */
    public Permission(String username, PermissionLevel permissionLevel) {
        this.username = username;
        this.permissionLevel = permissionLevel;
    }

    /**
     * username accessor
     * @return username
     */
    public String getUsername() {
        return username;
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
}
