package com.github.doomsdayrs.jikan4java.data.model.main.character

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.common.jikanURL
import com.github.doomsdayrs.jikan4java.core.Retriever
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListID
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListImageURL
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListName
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListURL
import com.github.doomsdayrs.jikan4java.data.model.support.RequestHashing
import com.github.doomsdayrs.jikan4java.data.model.support.VoiceActors
import com.github.doomsdayrs.jikan4java.data.model.support.pictures.Pictures
import java.util.*
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
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
data class Character(
		@field:JsonProperty("request_hash") override val request_hash: String = "",
		@field:JsonProperty("request_cached") override val request_cached: Boolean = false,
		@field:JsonProperty("request_cache_expiry") override val request_cache_expiry: Int = 0,
		@field:JsonProperty("mal_id") override val malID: Int = 0,
		@field:JsonProperty("url") override val url: String,
		@field:JsonProperty("name") override val name: String,
		@field:JsonProperty("name_kanji") val name_kanji: String = "",
		@field:JsonProperty("nicknames") val nicknames: ArrayList<String> = arrayListOf(),
		@field:JsonProperty("about") val about: String = "",
		@field:JsonProperty("member_favorites") val member_favorites: Int = 0,
		@field:JsonProperty("image_url") override val imageURL: String = "",
		@field:JsonProperty("animeography") val animeography: ArrayList<Animeography>,
		@field:JsonProperty("mangaography") val mangaography: ArrayList<Mangaography>,
		@field:JsonProperty("voice_actors") val voice_actors: ArrayList<VoiceActors>
) : Retriever(), RequestHashing, MyAnimeListID, MyAnimeListURL, MyAnimeListName, MyAnimeListImageURL {

	/**
	 * Gets pictures
	 *
	 * @return pictures
	 */
	@get:JsonProperty
	val pictures: CompletableFuture<Pictures> by lazy { retrieve<Pictures>("$jikanURL/character/$malID/pictures") }
}