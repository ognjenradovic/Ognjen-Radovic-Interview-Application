package rs.raf.ognjenradovic.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jobs")
data class JobEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val salary: String,
    val imageURL: String,
    val technologies: String,
    val description: String,
    val logoURL: String,
    val companyName: String,
    val companyDescription: String
) {
}