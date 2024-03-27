package DataStructures;

/**
 * @author benbruyns
 * Contains filename, content, owner name, and permission levels for non-owners of a file
 */
public class TextFile {
    private String fileName;
    private String content;
    private String ownerName;
    private Permission[] permissions;

    /**
     * Constructor for TextFile
     * @param fileName of file
     * @param content of file
     * @param ownerName of file
     * @param permissions of non-owners of file
     */
    public TextFile(String fileName, String content, String ownerName, Permission[] permissions) {
        this.fileName = fileName;
        this.content = content;
        this.ownerName = ownerName;
        this.permissions = permissions;
    }

    /**
     * fileName getter
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * fileName setter
     * @param fileName to replace previous fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * content getter
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * content setter
     * @param content to replace previous content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * ownerName getter
     * @return owner name
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * ownerName setter
     * @param ownerName to replace previous ownerName
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * permissions getter
     * @return permissions
     */
    public Permission[] getPermissions() {
        return permissions;
    }
}
