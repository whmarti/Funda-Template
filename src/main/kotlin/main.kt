import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseApp.initializeApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import model.usuario
import java.io.FileInputStream

public final class Quickstart {

//    private Firestore db
//    public Quickstart(String projectId) throws Exception
//    {
//
//        FirestoreOptions firestoreOptions =
//        FirestoreOptions.getDefaultInstance().toBuilder()
//            .setProjectId(projectId)
//            .setCredentials(GoogleCredentials.getApplicationDefault())
//            .build();
//        Firestore db1 = firestoreOptions . getService ();
//        // [END firestore_setup_client_create_with_project_id]
//        // [END fs_initialize_project_id]
//        db = db1
//    }

//    Firestore getDb()
//    {
//        return db;
//    }


    @Throws(Exception::class)
    fun close() {
//        db.close()
    }
}

private var database: DatabaseReference? = null
fun main(args: Array<String>) {
        val collection = listOf("1", "2", "3", "4", "5", "6")
    //prueba(collection)

 //       val db: dataB = new.dataB()
//        var usuarios : List<usuario>
    //    usuarios = dateB.getDb().document("usuario")

//        Quickstart quickStart = new Quickstart(ACCESS_KEY_ID)
//        quickStart.run()
//        quickStart.close()

//     var db: Firestore? = null
//     val firestoreOptions = FirestoreOptions.getDefaultInstance().toBuilder()
//        .setProjectId(Credentials.PROJECT_ID)
//        .setCredentials(GoogleCredentials.getApplicationDefault())
//        .build()
//    db = firestoreOptions.service


    val serviceAccount = FileInputStream("appKey.json")
    val options = FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .setDatabaseUrl("https://sql-demos-9f9ce-default-rtdb.firebaseio.com/")
        .build()
    val fa = FirebaseApp.initializeApp(options)

//var optAppStr = firebase.initializeApp({ "type": "service_account",
//    "project_id": "sql-demos-9f9ce",
//    "private_key_id": "b6137019e97e12f8d4c185829784119793705021",
//    "private_key": "-----BEGIN PRIVATE KEY-----\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDQnUEoCeBorGmR\nHIkAsxluO8TDMic3KdypseLfmcZ0gY5FoHBpxpQ8rl004wGJNYW92UljvZFe9WJp\nilyv7CCNEMP5Ibf154TESUJLCOJd9bGlaotWLsEsvChBF7grcJoayQnmLi5L4pde\n2NkKNyCUdVplMG/PLlIpl+SeWcdpiDr+CZ9w4zaXxm0BpUGcjQ6WWzQJQ+bRatzY\n/FBD2LK6QacAy/Xc9iKTiSJvz/vlwDse9880tvti7yNqFslvjSMNd15nNa8oQuAQ\nt/uBz6IP+IdatHfuQkA8PAzstW66qaJIIUynQ1MmrGLXPFfrJA3raEnc41bsWeQI\nl3NW9VX5AgMBAAECggEAFM4ABd4RSiMarpj/zUjvQfP2PCjD6i+TtP07dOT9OpiC\nj61P1K60ESaq/zed6zkCHuQ8+lRZG3UhpMiilH1aJDNeNfnvwpd9oUU0li7bQ3dZ\nqXdqELTeOUfFBHPY/0UOK1puES19Gr6M7c22vHrxtfiLpLCLUAhMs571MvkdZufb\n39TwozCclZrcHb365lfxgrxOIKWrG4txvpIIjAWujlZ2I+ujj55NTbWLVdQ3uEo/\nukI7hm1TujuAyaZ3ms+RYY0gD3W1zI0E8DHlFGjxsBCv7lkjZXnD/gFp5hLYhHLv\nRH9AYMidYArY5SaDhxZr2+4iF0imT4Ck1X5CUg6OkQKBgQDz9oh0NZUQPmwL9UBX\n5ji9/KuUtUQq9WzxkPhjzEFL58q2J7SIFHnPVEYY+rd9N1+D4DZHwi0p03YBNDXp\nk3IkGTHfOxBQoMtGFNdeXjHVLvl+NsdZvoHT+eRwZgCTbeJH3ngAWajrYlkNMaRi\nJluLIoKdBE88+v/6DJ2Sj0PPCQKBgQDa6DxgKGbR7/38ndZnHyy55c1qU0cGbDzF\n6L3uFKccKpQGNE8LOaxQgUB/wYVhlWd8gcKSFI35ZHULbZIiyuseowQsk9u48vZY\nmTa4QtjvmLD5IPxjkGX4M8Z3fPBmHbH7s4R+kc4zCj9F4bN9DC81LGUkpBpctY64\nLl9XZOkbcQKBgQDhEy76/8BBl0V5ls/BCJ6K8USfUsjMVVcoWtY+xF/tlrDXczRE\nY5ep5xcwzoZgmKifc0jA1W1zbCsvmyquDyE8Gp5/U++OY3qGco3r+z1AcDEv93vd\n2TvQBHl0FTcszTD5m07dC9sjJr3/xS/ieX71k2YrVKGCIhPtbpwlbdVieQKBgQDR\nFI1N/miuTX2WQR7d4Z2zdHTs/9tPnCOzl2eItPsjYNt+zYlNnGkjf0AehbSijrOH\n7Nvs8Grl73gHUUEJsCw/V84N0a9EB/MYjkYAWgCfX4RwfnvxkKKEHNeLmq51qhkr\n4btDtHlwsHHcigUIA5I3RE7aX066i8Jj0g7IBx7KUQKBgFxrb26H11s2qRAD4VZX\n1YUrUqd6uTwVm7zewGcCKFZ6Ij6SjeZAkuc6I3QQaITK8NGNnfftZsqOl+SqVjUW\nRwRPxeS6XfNPkPhj6ArplQ69k7fuJqggHrc7m8Vkafosf3QbBPVKKMc9h4zpvHvm\nhTw8tS9cDH0EtyOJHmDLW1BK\n-----END PRIVATE KEY-----\n",
//    "client_email": "firebase-adminsdk-990cm@sql-demos-9f9ce.iam.gserviceaccount.com",
//    "client_id": "106246781628421537367",
//    "auth_uri": "https://accounts.google.com/o/oauth2/auth",
//    "token_uri": "https://oauth2.googleapis.com/token",
//    "auth_provider_x509_cert_url": "https://www.googleapis.com/oauth2/v1/certs",
//    "client_x509_cert_url": "https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-990cm%40sql-demos-9f9ce.iam.gserviceaccount.com",
//    "firebase_url":"https://sql-demos-9f9ce-default-rtdb.firebaseio.com/"})

    val database = FirebaseDatabase.getInstance("https://sql-demos-9f9ce-default-rtdb.firebaseio.com/")



// Shared Database reference
   // database = FirebaseApp.getInstance().name;
   // val database1 = FirebaseDatabase.getInstance()

//    val app = FirebaseApp.initializeApp(
//        FirebaseOptions.Builder()
//            .setDatabaseUrl("https://admin-java-sdk.firebaseio.com")
//            .build()
//    )

//    val  db=FirebaseDatabase.getInstance()
    var usuarios : List<usuario>
//    val db: Firestore = FirestoreClient.getFirestore()
   // FirebaseDatabase firebaseDatabase = FirebaseDatabase. (fa)

//    val db = FirebaseApp.getApps().
    // usuarios = database.reference.database.("usuario").get()

    //Willy: Fila nueva no debe aparecer en el Git en mla rama Dev-1
}




