package com.kreitek.files;

public abstract class FileSystemItemBase {
    private static final String PATH_SEPARATOR = "/";
    private String name;
    private DirectoryImp directoryImpParent;
    private String PATH = PATH_SEPARATOR;

    protected FileSystemItemBase(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public FileSystemItemBase getParent() {
        return directoryImpParent;
    }

    public void setParent(DirectoryImp directoryImp) {
        this.directoryImpParent = directoryImp;
    }

    public String getFullPath() {
        if (directoryImpParent != null) {
            String parentFullPath = directoryImpParent.getFullPath();
            PATH = directoryImpParent.getFullPath() + (parentFullPath.length() > 1 ? PATH_SEPARATOR : "");
        }
        PATH += getName();
        return PATH;
    }

    public abstract int getSize();

}
