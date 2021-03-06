package com.github.doomsdayrs.jikan4java.data.model.main.manga

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.common.jikanURL
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.*
import com.github.doomsdayrs.jikan4java.data.model.main.manga.published.Published
import com.github.doomsdayrs.jikan4java.data.model.support.MoreInfo
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Authors
import com.github.doomsdayrs.jikan4java.data.model.support.basic.meta.Genre
import com.github.doomsdayrs.jikan4java.data.model.support.forum.Forum
import com.github.doomsdayrs.jikan4java.data.model.support.news.News
import com.github.doomsdayrs.jikan4java.data.model.support.pictures.Pictures
import com.github.doomsdayrs.jikan4java.data.model.support.recommendations.RecommendationPage
import com.github.doomsdayrs.jikan4java.data.model.support.related.Related
import com.github.doomsdayrs.jikan4java.data.model.support.reviews.manga.MangaReviewPage
import com.github.doomsdayrs.jikan4java.data.model.support.stats.MangaStats
import com.github.doomsdayrs.jikan4java.data.model.support.userupdate.manga.MangaUserUpdatesPage
import java.util.concurrent.CompletableFuture

/*
 * This file is part of Jikan4java.
 *
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Jikan4java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 28 / October / 2018
 *
 * @author github.com/doomsdayrs
 */
data class Manga(
		@field:JsonProperty("request_hash") val request_hash: String? = "",
		@field:JsonProperty("request_cached") val request_cached: Boolean = false,
		@field:JsonProperty("request_cache_expiry") val request_cache_expiry: Int = 0,
		@field:JsonProperty("mal_id") override val malID: Int = 0,
		@field:JsonProperty("url") override val url: String,
		@field:JsonProperty("title") override val title: String,
		@field:JsonProperty("title_english") val title_english: String = "",
		@field:JsonProperty("title_synonyms") val title_synonyms: List<String>,
		@field:JsonProperty("title_japanese") val title_japanese: String?,
		@field:JsonProperty("status") override val status: String = "",
		@field:JsonProperty("image_url") override val imageURL: String = "",
		@field:JsonProperty("type") val type: String = "",
		@field:JsonProperty("volumes") val volumes: Int = 0,
		@field:JsonProperty("chapters") val chapters: Int = 0,
		@field:JsonProperty("publishing") val publishing: Boolean = false,
		@field:JsonProperty("published") val published: Published?,
		@field:JsonProperty("rank") val rank: Int = 0,
		@field:JsonProperty("score") val score: Double = 0.0,
		@field:JsonProperty("scored_by") val scored_by: Int = 0,
		@field:JsonProperty("popularity") val popularity: Int = 0,
		@field:JsonProperty("members") val members: Int = 0,
		@field:JsonProperty("favorites") override val favoritesCount: Int = 0,
		@field:JsonProperty("synopsis") val synopsis: String = "",
		@field:JsonProperty("background") val background: String = "",
		@field:JsonProperty("related") override val related: Related?,
		@field:JsonProperty("genres") override val genres: List<Genre>,
		@field:JsonProperty("authors") val authors: List<Authors>,
		@field:JsonProperty("serializations") val serializations: List<Serializations>
) :
		Retriever(),
		MyAnimeListID,
		MyAnimeListURL,
		MyAnimeListTitle,
		MyAnimeListImageURL,
		MyAnimeListStatus,
		MyAnimeListRelated,
		MyAnimeListGenres,
		MyAnimeListFavoriteCount {

	/**
	 * Returns MangaCharacters object
	 *
	 * @return MangaCharacters
	 */
	@get:JsonProperty
	val characters: CompletableFuture<MangaCharacters> by lazy { retrieve<MangaCharacters>("$jikanURL/manga/$malID/characters") }

	/**
	 * Gets news about Manga
	 *
	 * @return News object
	 */
	@get:JsonProperty
	val news: CompletableFuture<News> by lazy { retrieve<News>("$jikanURL/manga/$malID/news") }

	/**
	 * Gets pictures related to Manga
	 *
	 * @return Pictures object
	 */
	@get:JsonProperty
	val pictures: CompletableFuture<Pictures> by lazy { retrieve<Pictures>("$jikanURL/manga/$malID/pictures") }

	/**
	 * Gets stats about Manga object
	 *
	 * @return Stats object
	 */
	@get:JsonProperty
	val stats: CompletableFuture<MangaStats> by lazy { retrieve<MangaStats>("$jikanURL/manga/$malID/stats") }

	/**
	 * Returns forum object
	 *
	 * @return Forum object
	 */
	@get:JsonProperty
	val forum: CompletableFuture<Forum> by lazy { retrieve<Forum>("$jikanURL/manga/$malID/forum") }

	/**
	 * Returns Moreinfo object
	 *
	 * @return MoreInfo
	 */
	@get:JsonProperty
	val moreInfo: CompletableFuture<MoreInfo> by lazy { retrieve<MoreInfo>("$jikanURL/manga/$malID/moreinfo") }

	/**
	 * Gets manga reviews
	 *
	 * @return MangaReviewPage
	 */
	@get:JsonProperty
	val reviews: CompletableFuture<MangaReviewPage> by lazy { retrieve<MangaReviewPage>("$jikanURL/manga/$malID/reviews") }

	/**
	 * Gets recommendations for this manga
	 *
	 * @return RecommendationPage
	 */
	@get:JsonProperty
	val recommendationPage: CompletableFuture<RecommendationPage> by lazy { retrieve<RecommendationPage>("$jikanURL/manga/$malID/recommendations") }

	/**
	 * Gets first page of user updates
	 *
	 * @return MangaUserUpdatesPage
	 */
	@get:JsonProperty
	val userUpdatesPage: CompletableFuture<MangaUserUpdatesPage> by lazy { getUserUpdatesPage(1) }

	/**
	 * Gets a page of userUpdates
	 *
	 * @param page which page to get, default is 1
	 * @return MangaUserUpdatesPage
	 */
	@JsonProperty
	fun getUserUpdatesPage(page: Int): CompletableFuture<MangaUserUpdatesPage> =
			retrieve<MangaUserUpdatesPage>("$jikanURL/manga/$malID/userupdates/$page")
}