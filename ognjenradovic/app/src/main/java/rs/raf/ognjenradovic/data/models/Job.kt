package rs.raf.ognjenradovic.data.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
data class Job(
    @PrimaryKey
    @ColumnInfo(name = "idJob")
    val id: String,
    @ColumnInfo(name = "jobName")
    val name: String,
    @ColumnInfo(name = "jobSalary")
    val salary: String,
    @ColumnInfo(name = "jobImage")
    val imageURL: String,
    @ColumnInfo(name = "jobTechnologies")
    val technologies: String,
    @ColumnInfo(name = "jobDescription")
    val description: String,
    @ColumnInfo(name = "companyLogo")
    val logoURL: String,
    @ColumnInfo(name = "companyName")
    val companyName: String,
    @ColumnInfo(name = "companyDescription")
    val companyDescription: String

) : Parcelable