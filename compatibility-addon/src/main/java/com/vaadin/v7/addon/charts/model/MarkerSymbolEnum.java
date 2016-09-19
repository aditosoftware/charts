package com.vaadin.v7.addon.charts.model;

/*
 * #%L
 * Vaadin Charts
 * %%
 * Copyright (C) 2012 - 2015 Vaadin Ltd
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

import com.vaadin.addon.charts.model.ChartEnum;
import com.vaadin.addon.charts.model.MarkerSymbol;

/**
 * A predefined shape or symbol for the marker. When null, the symbol is pulled
 * from options.symbols. Other possible values are "circle", "square",
 * "diamond", "triangle" and "triangle-down". Additionally, the URL to a graphic
 * can be given on this form: URL.setUrl("url(graphic.png)").
 * 
 */
public enum MarkerSymbolEnum implements MarkerSymbol, ChartEnum {
    CIRCLE("circle"), SQUARE("square"), DIAMOND("diamond"), TRIANGLE("triangle"), TRIANGLE_DOWN(
            "triangle-down");

    private String symbol;

    private MarkerSymbolEnum(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
