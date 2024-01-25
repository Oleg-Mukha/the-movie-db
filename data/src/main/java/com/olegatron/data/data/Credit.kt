package com.olegatron.data.data

import com.google.gson.annotations.SerializedName
import com.olegatron.domain.model.Credit

data class Credit(
    @SerializedName("id") val id: Int?,
    @SerializedName("character") val character: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("profile_path") val profilePath: String?
) {
    fun convert(): Credit {
        val credit = this
        return Credit(
            credit.id,
            credit.character,
            credit.name,
            credit.profilePath
        )
    }
}

data class CreditResponse(
    @SerializedName("cast") val cast: List<com.olegatron.data.data.Credit>
)
