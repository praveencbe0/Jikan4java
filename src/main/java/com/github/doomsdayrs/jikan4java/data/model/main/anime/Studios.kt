package com.github.doomsdayrs.jikan4java.data.model.main.anime

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListID
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListName
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListType
import com.github.doomsdayrs.jikan4java.data.base.MyAnimeListURL

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
class Studios(
		@field:JsonProperty("mal_id") override val malID: Int = 0,
		@field:JsonProperty("type") override val type: String? = null,
		@field:JsonProperty("name") override val name: String,
		@field:JsonProperty("url") override val url: String
) : MyAnimeListID, MyAnimeListURL, MyAnimeListName, MyAnimeListType