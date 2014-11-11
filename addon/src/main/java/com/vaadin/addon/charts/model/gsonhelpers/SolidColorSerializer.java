package com.vaadin.addon.charts.model.gsonhelpers;

/*
 * #%L
 * Vaadin Charts
 * %%
 * Copyright (C) 2014 Vaadin Ltd
 * %%
 * This program is available under Commercial Vaadin Add-On License 3.0
 * (CVALv3).
 * 
 * See the file licensing.txt distributed with this software for more
 * information about licensing.
 * 
 * You should have received a copy of the CVALv3 along with this program.
 * If not, see <https://vaadin.com/license/cval-3>.
 * #L%
 */

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.vaadin.addon.charts.model.style.SolidColor;

/**
 * Serializer for SolidColors
 */
public class SolidColorSerializer implements JsonSerializer<SolidColor> {
    @Override
    public JsonElement serialize(SolidColor src, Type typeOfSrc,
            JsonSerializationContext context) {
        return new JsonPrimitive(src.toString());
    }

}