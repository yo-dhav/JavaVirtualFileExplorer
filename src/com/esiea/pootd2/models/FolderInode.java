package com.esiea.pootd2.models;

public class FolderInode extends Inode{

    public FolderInode(String name){  
        super(name);
        super.setSize(0);
    }

    public void addSubInodes(Inode inode){
        inode.setParentInode(this);
        super.addSubInode(inode);
        this.updateFolderSize();
    }

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

    public FileInode getSubFile(String name){
        Inode matchingInode = this.getSubInode(name);
        if (matchingInode instanceof FileInode){
            return (FileInode)matchingInode;
        }
        return null;
    }

    public FolderInode getSubFolder(String name){
        Inode matchingInode = this.getSubInode(name);
        if (matchingInode instanceof FolderInode){
            return (FolderInode)matchingInode;
        }
        return null;
    }

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
            }
        }
        return result.toString();
    }
}
