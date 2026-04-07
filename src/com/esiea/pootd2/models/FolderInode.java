package com.esiea.pootd2.models;

public class FolderInode extends Inode{

<<<<<<< HEAD
=======
    /**
     * Constructor for the folder
     * @param name The name of the folder
     */
>>>>>>> 4d4b529f48490387c9297c734afe4d3c76b1ab1a
    public FolderInode(String name){  
        super(name);
        super.setSize(0);
    }

<<<<<<< HEAD
=======
    /**
     * Add a subInode to the folder
     * @param inode The inode to add
     */
>>>>>>> 4d4b529f48490387c9297c734afe4d3c76b1ab1a
    public void addSubInodes(Inode inode){
        inode.setParentInode(this);
        super.addSubInode(inode);
        this.updateFolderSize();
    }

<<<<<<< HEAD
=======
    /**
     * Update the folder size by getting all the subInodes sizes
     * When the size is updated, the parent size are being updated
     */
>>>>>>> 4d4b529f48490387c9297c734afe4d3c76b1ab1a
    public void updateFolderSize(){
        int tmpSize = 0;
        for (Inode inode : super.getSubInodes()) {
            tmpSize+= inode.getSize();
        }
        this.setSize(tmpSize);

        FolderInode parent = super.getParent();
        if (parent != null){
            parent.updateFolderSize();
        }
    }

<<<<<<< HEAD
=======
    /**
     * Get a specific file of this folder
     * @param name The name of the file
     * @return The file's inode
     */
>>>>>>> 4d4b529f48490387c9297c734afe4d3c76b1ab1a
    public FileInode getSubFile(String name){
        Inode matchingInode = this.getSubInode(name);
        if (matchingInode instanceof FileInode){
            return (FileInode)matchingInode;
        }
        return null;
    }

<<<<<<< HEAD
=======
    /**
     * Get a specific folder of this folder
     * @param name The name of the folder
     * @return The folder's inode
     */
>>>>>>> 4d4b529f48490387c9297c734afe4d3c76b1ab1a
    public FolderInode getSubFolder(String name){
        Inode matchingInode = this.getSubInode(name);
        if (matchingInode instanceof FolderInode){
            return (FolderInode)matchingInode;
        }
        return null;
    }

<<<<<<< HEAD
    public String displaySubInodes(String prefix, boolean isFirstCall) {
        StringBuilder result = new StringBuilder();

        if (isFirstCall) {
            result.append(this.getName()).append(" ").append(this.getSize()).append("\n");
        } else {
            result.append(prefix).append("|_ ").append(this.getName()).append(" ").append(this.getSize()).append("\n");
        }

        String childPrefix = prefix + (isFirstCall ? "" : "   ");

        for (Inode inode : this.getSubInodes()) {
            if (inode instanceof FolderInode) {
                result.append(((FolderInode) inode).displaySubInodes(childPrefix, false));
            } else {
                result.append(childPrefix).append("|_ ")
                      .append(inode.getName()).append(" ")
                      .append(inode.getSize()).append("\n");
=======
    /**
     * Display recursivly all the sub elements of this folder in a tree format
     * @param prefix The prefix to add before each line
     * @param isFirstCall A boolean used for the recusive loop to avoid displaying useless |_ for the first element (must be true when called)
     * @return The tree as a string
     */
    public String displaySubInodes(String prefix, boolean isFirstCall) {
        StringBuilder result = new StringBuilder();
        if (!isFirstCall) {
            result.append(prefix + "|_ ");
        }
        result.append(this.getName() + " " + this.getSize() + "\n");
        for (Inode inode : this.getSubInodes()) {
            if (inode instanceof FolderInode) {
                result.append(((FolderInode) inode).displaySubInodes(prefix + "  ", false));
            } else {
                result.append(prefix + "  |_ " + inode.getName() + " " + inode.getSize() + "\n");
>>>>>>> 4d4b529f48490387c9297c734afe4d3c76b1ab1a
            }
        }
        return result.toString();
    }
}
