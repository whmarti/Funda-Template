package data

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.FirestoreOptions
import utils.Credentials

public class dataB {
    private var db: Firestore? = null

    public fun dataB() {

        val firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
            .setProjectId(Credentials.PROJECT_ID)
            .setCredentials(GoogleCredentials.getApplicationDefault())
            .build()
        db = firestoreOptions.service
    }

    fun getDb(): Firestore? {
        return db
    }

    /** Closes the gRPC channels associated with this instance and frees up their resources.  */
    @Throws(Exception::class)
    fun close() {
        db!!.close()
    }

}