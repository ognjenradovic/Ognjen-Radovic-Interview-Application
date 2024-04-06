package rs.raf.ognjenradovic.data.models
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AllJobsResponse(
    val jobs: List<Job>
) {
    @JsonClass(generateAdapter = true)
    data class Job(
        val id: String,
        val name: String,
        val salary: String,
        val imageURL: String,
        val technologies: String,
        val description: String,
        val logoURL: String,
        val companyName: String,
        val companyDescription: String
    )
}