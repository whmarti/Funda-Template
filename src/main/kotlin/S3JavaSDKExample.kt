import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.PutObjectRequest
import com.amazonaws.services.s3.model.PutObjectResult
import org.apache.commons.io.FileUtils
import utils.Credentials
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by William Martin on 27/05/2021.
 */
object S3JavaSDKExample : Throwable() {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        println("Get in...")
        //BringFiles(Credentials.FILE_TO_COPY)
       // Prueba()
                PopulateSimpleBucket()

      //  PopulateBucket(donations)

//        val donations = listOf(donationLink("8uutxhfsTseQnUetuWax","https://drive.google.com/uc?export=download&id=1w_yIZSDbFFfQ5fPYfhaX_oHs_kBpWkMn"),
//            donationLink("56OpQxFvd2SuPlJ1xnwP","https://drive.google.com/uc?export=download&id=1lwN4M7QDcXtpIdMLlrAUhyjszqmwD44H"),
//            donationLink("C9kHvpN64zz8O9NABpes","https://drive.google.com/uc?export=download&id=1jvgzvUgsp6ZdtxIglooFxHvyhjyWqv2Y"),
//            donationLink("DIl3neHSd0BhA3kaPjBf","https://drive.google.com/uc?export=download&id=1f3YbJv5_c2582-qUcdttJXHyZoVr_3MQ"),
//            donationLink("F9i6rzAz6DC43c3UYVZW","https://drive.google.com/uc?export=download&id=1sKXbLuuF4ILOj-DHWxNipu3QJCW1DHEx") )
//        DBloadFiles(donations)
    }




    fun DBloadFiles(pDonations:List<donationLink>){
//        var url = URL(Credentials.FILE_URL)
         lateinit  var destination : File
        println("Downloading files from google...")
        for (donationLink in pDonations) {
            destination = File(Credentials.SAVE_DIR + donationLink.id + ".json")
            FileUtils.copyURLToFile(URL(donationLink.link.toString()) , destination)
        }

    }

    @Throws(Exception::class)
    fun BringFiles(pFileN : String) {
        val fileURL = Credentials.FILE_URL
        val saveDir = Credentials.SAVE_DIR
        try {
            HttpDownloadUtility.downloadFile(fileURL, saveDir, pFileN);
        } catch (e: Exception) {
            e.printStackTrace()
            println("It was not able to store the google files in this folder: " + e.message)
            System.exit(1)
        }

    }

    @Throws(Exception::class)
    fun PopulateSimpleBucket() {
        val awsCreds = BasicAWSCredentials(Credentials.ACCESS_KEY_ID, Credentials.SECRET_ACCESS_KEY)
        val s3Client = AmazonS3Client(awsCreds)
        val bucketName = "donaciones"
        val fileName = Credentials.FILE_TO_COPY
        val file = File( Credentials.PATH_FILE + fileName)
        try {
            val putRequest1 = PutObjectRequest(bucketName, fileName, file)
            val response1: PutObjectResult = s3Client.putObject(putRequest1)
            System.out.println(
                "Uploaded object encryption status is " +
                        response1.getSSEAlgorithm()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            println("It was not able to store an unencrypted file in this folder: " + e.message)
            System.exit(1)
        }
    }

    @Throws(Exception::class)
    fun PopulateBucket(donations : List<donationLink>) {
        val awsCreds = BasicAWSCredentials(Credentials.ACCESS_KEY_ID, Credentials.SECRET_ACCESS_KEY)
        val s3Client = AmazonS3Client(awsCreds)
        val bucketName = "donaciones"
        var i : Int = 0

        try {
            var fileName = ""
            lateinit var file : File
            lateinit var putRequest : PutObjectRequest
            lateinit var response: PutObjectResult
            println("Uploading files to ES3...")
            donations.forEach {
                if (i < 5){
                    fileName = it.id + ".json"
                    file = File(Credentials.SAVE_DIR + fileName)
                    putRequest = PutObjectRequest(bucketName, fileName, file)
                    response = s3Client.putObject(putRequest)
                    i += 1
                 }
            }


            System.out.println("Files Uploaded!! ")
//            System.out.println(
//                "Files Uploaded!! Object encryption status is " +  response.getSSEAlgorithm()
//            )
        } catch (e: Exception) {
            e.printStackTrace()
            println("It was not able to store an unencrypted file in this folder: " + e.message)
            System.exit(1)
        }
    }

    object HttpDownloadUtility {
        private const val BUFFER_SIZE = 4096

        /**
         * Downloads a file from a URL
         */
        @Throws(IOException::class)
        fun downloadFile(fileURL: String, saveDir: String, pfileN: String) {
            val url = URL(fileURL)
            val httpConn: HttpURLConnection = url.openConnection() as HttpURLConnection
            val responseCode: Int = httpConn.getResponseCode()

            // always check HTTP response code first
            if (responseCode == HttpURLConnection.HTTP_OK) {
                var fileName = ""
                val disposition: String = if(httpConn.getHeaderField("Content-Disposition")==null) "No disposition" else httpConn.getHeaderField("Content-Disposition")
                val contentType: String = httpConn.getContentType()
                val contentLength: Int = httpConn.getContentLength()
                if (disposition != "No disposition") {
                    // extracts file name from header field
                    val index = disposition.indexOf("filename=")
                    if (index > 0) {
                        fileName = disposition.substring(
                            index + 10,
                            disposition.length - 1
                        )
                    }
                } else {
                    // extracts file name from URL
//                    fileName = fileURL.substring(
//                        fileURL.lastIndexOf("/") + 1,
//                        fileURL.length
//                    )
                    fileName = pfileN
                }
                println("Content-Type = $contentType")
                println("Content-Disposition = $disposition")
                println("Content-Length = $contentLength")
                println("fileName = $fileName")

                // opens input stream from the HTTP connection
                val inputStream: InputStream = httpConn.getInputStream()
                val saveFilePath = saveDir + File.separator + fileName

                // opens an output stream to save into file
                val outputStream = FileOutputStream(saveFilePath)
                var bytesRead = -1
                val buffer = ByteArray(BUFFER_SIZE)
                while (inputStream.read(buffer).also { bytesRead = it } != -1) {
                    outputStream.write(buffer, 0, bytesRead)
                }
                outputStream.close()
                inputStream.close()
                println("File downloaded")
            } else {
                println("No file to download. Server replied HTTP code: $responseCode")
            }
            httpConn.disconnect()
        }
    }



}

data class donationLink(val id:String,val link: String){}

//    fun Prueba(){
//        val url = URL(Credentials.FILE_URL)
//        val destination = File(Credentials.SAVE_DIR +"temp.json")
//
//        // Copy bytes from the URL to the destination file.
//
//        // Copy bytes from the URL to the destination file.
//        FileUtils.copyURLToFile(url, destination)
//    }