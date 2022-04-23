package com.kreitek.utils;

import com.kreitek.files.DirectoryImp;
import com.kreitek.files.FileSystemItemBase;
import com.kreitek.service.FileManager;

public class FileSystemPrinter {

    public static void print(FileSystemItemBase item, int nivel) {
        String indentation = "\t".repeat(nivel);
        String message = String.format("%s%s = %d bytes", indentation, item.getFullPath(), FileManager.calculateSize(item));
        System.out.println(message);

        if (item instanceof DirectoryImp) {
            for (FileSystemItemBase subitem : ((DirectoryImp) item).listFiles()) {
                FileSystemPrinter.print(subitem, nivel + 1);
            }
        }

    }

}
