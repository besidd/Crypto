package com.example.crypto.data.remote.dto


import com.example.crypto.domain.models.CoinDetail
import com.google.gson.annotations.SerializedName

data class CoinDetailDto(
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("development_status")
    val developmentStatus: String? = "",
    @SerializedName("first_data_at")
    val firstDataAt: String? = "",
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean? = false,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("is_active")
    val isActive: Boolean? = false,
    @SerializedName("is_new")
    val isNew: Boolean? = false,
    @SerializedName("last_data_at")
    val lastDataAt: String? = "",
    @SerializedName("links")
    val links: Links? = Links(),
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended?>? = listOf(),
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("open_source")
    val openSource: Boolean? = false,
    @SerializedName("org_structure")
    val orgStructure: String? = "",
    @SerializedName("proof_type")
    val proofType: String? = "",
    @SerializedName("rank")
    val rank: Int? = 0,
    @SerializedName("started_at")
    val startedAt: String? = "",
    @SerializedName("symbol")
    val symbol: String? = "",
    @SerializedName("tags")
    val tags: List<Tag>? = listOf(),
    @SerializedName("team")
    val team: List<TeamMember>? = listOf(),
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("whitepaper")
    val whitepaper: Whitepaper? = Whitepaper()
) {
    data class Links(
        @SerializedName("explorer")
        val explorer: List<String?>? = listOf(),
        @SerializedName("facebook")
        val facebook: List<String?>? = listOf(),
        @SerializedName("reddit")
        val reddit: List<String?>? = listOf(),
        @SerializedName("source_code")
        val sourceCode: List<String?>? = listOf(),
        @SerializedName("website")
        val website: List<String?>? = listOf(),
        @SerializedName("youtube")
        val youtube: List<String?>? = listOf()
    )

    data class LinksExtended(
        @SerializedName("stats")
        val stats: Stats? = Stats(),
        @SerializedName("type")
        val type: String? = "",
        @SerializedName("url")
        val url: String? = ""
    ) {
        data class Stats(
            @SerializedName("contributors")
            val contributors: Int? = 0,
            @SerializedName("followers")
            val followers: Int? = 0,
            @SerializedName("stars")
            val stars: Int? = 0,
            @SerializedName("subscribers")
            val subscribers: Int? = 0
        )
    }

    data class Tag(
        @SerializedName("coin_counter")
        val coinCounter: Int? = 0,
        @SerializedName("ico_counter")
        val icoCounter: Int? = 0,
        @SerializedName("id")
        val id: String? = "",
        @SerializedName("name")
        val name: String? = ""
    )

    data class TeamMember(
        @SerializedName("id")
        val id: String? = "",
        @SerializedName("name")
        val name: String? = "",
        @SerializedName("position")
        val position: String? = ""
    )

    data class Whitepaper(
        @SerializedName("link")
        val link: String? = "",
        @SerializedName("thumbnail")
        val thumbnail: String? = ""
    )
}

fun CoinDetailDto.toCoinDetails() = CoinDetail(
    coinId = id,
    name = name,
    description = description,
    symbol = symbol,
    rank = rank,
    isActive = isActive,
    tags = tags?.map { it.name },
    team = team ?: emptyList()
)