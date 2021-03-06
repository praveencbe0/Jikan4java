package com.github.doomsdayrs.jikan4java.core.search.animemanga

import com.github.doomsdayrs.jikan4java.data.enums.genres.AnimeGenres
import com.github.doomsdayrs.jikan4java.data.enums.search.Types
import com.github.doomsdayrs.jikan4java.data.enums.search.animemanga.orderby.AnimeOrderBy
import com.github.doomsdayrs.jikan4java.data.enums.status.AnimeStati
import com.github.doomsdayrs.jikan4java.data.model.main.anime.Anime
import com.github.doomsdayrs.jikan4java.data.model.main.anime.animePage.AnimePage

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
 * 13 / 05 / 2019
 *
 * @author github.com/doomsdayrs
 */
class AnimeSearch : AnimeMangaSearch<AnimePage, Anime, AnimeSearch, AnimeStati, AnimeGenres, AnimeOrderBy>(Types.ANIME)