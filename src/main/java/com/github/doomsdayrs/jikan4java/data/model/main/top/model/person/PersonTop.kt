package com.github.doomsdayrs.jikan4java.data.model.main.top.model.person

import com.fasterxml.jackson.annotation.JsonProperty
import com.github.doomsdayrs.jikan4java.data.model.main.top.base.Top
import java.util.*

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
 * 01 / November / 2018
 *
 * @author github.com/doomsdayrs
 */
data class PersonTop(
		@JsonProperty("request_hash") override val request_hash: String? = null,
		@JsonProperty("request_cached") override val request_cached: Boolean = false,
		@JsonProperty("request_cache_expiry") override val request_cache_expiry: Int = -1,
		@param:JsonProperty("top") override val topListings: ArrayList<TopPerson> = arrayListOf()
) : Top<TopPerson>("people")