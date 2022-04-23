package com.kreitek.utils;

import com.kreitek.files.DirectoryImp;
import com.kreitek.files.FileImp;
import com.kreitek.files.FileSystemItemBase;

public class FileSystemBuilder {

    private final DirectoryImp root;
    private DirectoryImp currentDirectoryImp;

    public static FileSystemBuilder getBuilder() {
        return new FileSystemBuilder();
    }

    public FileSystemBuilder() {
        root = new DirectoryImp("");
        currentDirectoryImp = root;
    }

    public FileSystemBuilder addFile(String name, int size) {
        FileImp fileImp = new FileImp(name);
        fileImp.open();
        fileImp.write(new byte[size]);
        fileImp.close();
        currentDirectoryImp.addFile(fileImp);
        return this;
    }

    public FileSystemBuilder addDirectory(String name) {
        DirectoryImp directoryImp = new DirectoryImp(name);
        currentDirectoryImp.addFile(directoryImp);
        currentDirectoryImp = directoryImp;
        return this;
    }

    public FileSystemBuilder upOneDirectory() {
        if (currentDirectoryImp.getParent() != null) {
            currentDirectoryImp = (DirectoryImp) currentDirectoryImp.getParent();
        }

        return this;
    }

    public FileSystemItemBase build() {
        return root;
    }
}
