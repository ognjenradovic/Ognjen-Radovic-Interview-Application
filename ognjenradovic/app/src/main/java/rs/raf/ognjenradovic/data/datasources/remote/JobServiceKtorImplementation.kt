//import io.ktor.client.HttpClient
//import io.ktor.client.request.get
//import io.ktor.client.statement.*
//import org.json.JSONObject
//import rs.raf.ognjenradovic.data.models.AllJobsResponse
//import java.util.ArrayList
//
//class JobServiceBackup(private val client: HttpClient) {
//
//
//    suspend fun getAll(): AllJobsResponse {
//        val response = getAllHttp()
//        val responseBody = response.bodyAsText()
//        return deserializeJsonToAllJobsResponse(responseBody)
//    }
//
//    private suspend fun getAllHttp(): HttpResponse {
//        return client.get("https://c051d8b188ea43ac9680529542d1dd51.api.mockbin.io/")
//    }
//
//    private fun deserializeJsonToAllJobsResponse(jsonString: String): AllJobsResponse {
//        return try {
//            val jsonObject = JSONObject(jsonString)
//            val jobsArray = jsonObject.getJSONArray("jobs")
//
//            val jobList = ArrayList<AllJobsResponse.Job>()
//
//            for (i in 0..jobsArray.length() - 1) {
//                val jobObject = jobsArray.getJSONObject(i)
//                val job = AllJobsResponse.Job(
//                    id = jobObject.getString("id"),
//                    name = jobObject.getString("name"),
//                    salary = jobObject.getString("salary"),
//                    imageURL = jobObject.getString("imageURL"),
//                    technologies = jobObject.getString("technologies"),
//                    description = jobObject.getString("description"),
//                    logoURL = jobObject.getString("logoURL"),
//                    companyName = jobObject.getString("companyName"),
//                    companyDescription = jobObject.getString("companyDescription")
//                )
//                jobList.add(job)
//            }
//
//            AllJobsResponse(jobList)
//        } catch (e: Exception) {
//            e.printStackTrace()
//            val defaultJob = AllJobsResponse.Job(
//                id = "Not Found",
//                name = "Not Found",
//                salary = "Not Found",
//                imageURL = "Not Found",
//                technologies = "Not Found",
//                description = "Not Found",
//                logoURL = "Not Found",
//                companyName = "Not Found",
//                companyDescription = "Not Found"
//            )
//            val jobList = ArrayList<AllJobsResponse.Job>()
//            jobList.add(defaultJob);
//            jobList.add(defaultJob);
//
//            return AllJobsResponse(jobList);
//        }
//    }
//    }
//
