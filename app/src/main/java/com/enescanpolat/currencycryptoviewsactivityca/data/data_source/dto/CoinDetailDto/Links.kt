package com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto

data class Links(
    val announcement_url: List<String>,
    val bitcointalk_thread_identifier: Any,
    val blockchain_site: List<String>,
    val chat_url: List<String>,
    val facebook_username: String,
    val homepage: List<String>,
    val official_forum_url: List<String>,
    val repos_url: com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.ReposUrl,
    val subreddit_url: String,
    val telegram_channel_identifier: String,
    val twitter_screen_name: String
)