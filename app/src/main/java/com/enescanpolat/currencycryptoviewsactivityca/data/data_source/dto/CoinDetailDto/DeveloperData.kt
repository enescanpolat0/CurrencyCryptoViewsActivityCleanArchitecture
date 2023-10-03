package com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto

data class DeveloperData(
    val closed_issues: Int,
    val code_additions_deletions_4_weeks: com.enescanpolat.currencycryptoviewsactivityca.data.data_source.dto.CoinDetailDto.CodeAdditionsDeletions4Weeks,
    val commit_count_4_weeks: Int,
    val forks: Int,
    val last_4_weeks_commit_activity_series: List<Any>,
    val pull_request_contributors: Int,
    val pull_requests_merged: Int,
    val stars: Int,
    val subscribers: Int,
    val total_issues: Int
)