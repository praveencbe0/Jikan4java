package com.github.Doomsdayrs.Jikan4java.connection;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

/**
 * This file is part of Jikan4java.
 * Jikan4java is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Foobar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with Jikan4java.  If not, see <https://www.gnu.org/licenses/>.
 * ====================================================================
 * Jikan4java
 * 03 / May / 2019
 *
 * @author github.com/doomsdayrs
 */
public abstract class Connection {
    public final OkHttpClient client;
    public final String baseURL = "https://api.jikan.moe/v3";
    public final ObjectMapper objectMapper;
    public final JSONParser jsonParser;

    public Connection() {
        client = new OkHttpClient();
        objectMapper = new ObjectMapper();
        jsonParser = new JSONParser();
    }

    public Object search(String string) throws IOException, ParseException {
        return null;
    }

    public Object searchPage(String title, int page) throws IOException, ParseException {
        return null;
    }

}
