package com.github.doomsdayrs.jikan4java.data.model.support.reviews.anime

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.data.model.support.reviews.Reviewer

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
 * ====================================================================*/
/**
 * Jikan4java
 * 30 / December / 2018
 *
 * @author github.com/doomsdayrs
 */
data class AnimeReviewer(
		@JsonProperty("url") override val url: String,
		@JsonProperty("image_url") override val imageURL: String = "",
		@JsonProperty("username") override val username: String = "",
		@JsonProperty("episodes_seen") override val seen: Int,
		@JsonProperty("scores") override val scores: AnimeScore
) : Reviewer()