package com.github.doomsdayrs.jikan4java.enums.top

import com.github.doomsdayrs.jikan4java.model.main.top.model.anime.AnimeTop
import com.github.doomsdayrs.jikan4java.model.main.top.model.character.CharacterTop
import com.github.doomsdayrs.jikan4java.model.main.top.model.manga.MangaTop
import com.github.doomsdayrs.jikan4java.model.main.top.model.person.PersonTop

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
 * 11 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
enum class Tops(private val type: String, private val aClass: Class<*>) {
	ANIME("anime", AnimeTop::class.java), MANGA("manga", MangaTop::class.java), PEOPLE("people", PersonTop::class.java), CHARACTERS("characters", CharacterTop::class.java);

	fun compatible(topSubType: TopSubType?): Boolean {
		if (this == PEOPLE || this == CHARACTERS) return false
		if (topSubType != null) {
			if (this == ANIME || this == MANGA) if (topSubType.javaClass == SharedTops::class.java) return true
			if (this == ANIME) return topSubType.javaClass == AnimeTops::class.java
			if (this == MANGA) return topSubType.javaClass == MangaTops::class.java
		}
		return false
	}

	fun getaClass(): Class<*> {
		return aClass
	}

	override fun toString(): String {
		return type
	}

}