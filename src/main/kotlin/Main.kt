import com.google.api.core.ApiFuture
import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.QueryDocumentSnapshot
import com.google.cloud.firestore.QuerySnapshot
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import java.io.FileInputStream

fun main(args: Array<String>) {
    initializeFirebase()

    val db: Firestore = FirestoreClient.getFirestore()
    showStock(db = db)

    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

private fun initializeFirebase() {
    val serviceAccount = FileInputStream("firebase/serviceAccountKey.json")
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build()
    FirebaseApp.initializeApp(options)
}

private fun showStock(db: Firestore) {
    val query: ApiFuture<QuerySnapshot> = db.collection(Stock.DB_TABLE_NAME).get()
    val querySnapshot: QuerySnapshot = query.get()
    val documents: List<QueryDocumentSnapshot> = querySnapshot.documents
    for (document in documents) {
        println("Id: " + document.id)
        println("Code: " + document.getString("code"))
        println("Country Code: " + document.getString("countryCode"))
        println("Symbol: " + document.getString("symbol"))
        if (document.contains("name")) {
            println("Name: " + document.getString("name"))
        }
        println("Category: " + document.getString("category"))
    }
}
