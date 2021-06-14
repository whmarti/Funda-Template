import com.google.api.services.drive.Drive
import com.google.api.services.drive.model.File
import utils.Credentials
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream


object APIGoogle : Throwable() {
    /**
     * Download a file's content.
     *
     * @param service Drive API service instance.
     * @param file Drive File instance.
     * @return InputStream containing the file's content if successful,
     * `null` otherwise.
     */

    val GOOGLE_DRIVE_DOMAIN = "drive.google.com"
    val GOOGLE_DRIVE_DOMAIN2 = "https://drive.google.com"

//    private fun downloadFile(service: Drive, file: java.io.File) {
//
//        val destinationFolder = Credentials.SAVE_DIR //"/tmp/downloadedfiles/"
//        val files: List<File> = result.getFiles()
//        var newFile: File
//        if (files == null || files.isEmpty()) {
//            println("No files found.")
//        } else {
//            println("Files:")
//            for (file in files) {
//                System.out.printf("%s (%s)\n", file.name, file.id)
//                val fileId = file.id
//                val fileName = file.name
//                val outputstream: OutputStream = FileOutputStream(destinationFolder + fileName)
//                service.files()[fileId]
//                    .executeMediaAndDownloadTo(outputstream)
//                outputstream.flush()
//                outputstream.close()
//            }
//        }
//    }
//    private fun downloadFile(pFile : String) {
//
//        val destinationFolder = Credentials.SAVE_DIR //"/tmp/downloadedfiles/"
//        val files: List<File> = result.getFiles()
//        var newFile= "https://drive.google.com/file/d/1N4NQlT6sjeGqIdSsv8pWDkCakzX_6HUj"
//
//                val fileId = file.id
//                val fileName = file.name
//                val outputstream: OutputStream = FileOutputStream(destinationFolder + fileName)
//                service.files()[fileId]
//                    .executeMediaAndDownloadTo(outputstream)
//                outputstream.flush()
//                outputstream.close()
//            }
//        }
//    }






}
