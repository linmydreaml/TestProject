import com.google.gson.annotations.SerializedName

data class Items (
	@SerializedName("name") val name : String,
	@SerializedName("full_name") val full_name : String,
	@SerializedName("stargazers_count") val stargazers_count : Int
)