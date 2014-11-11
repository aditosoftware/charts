package com.vaadin.addon.charts.model;

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

/**
 * A wrapper object for all the series options in specific states.
 */
@SuppressWarnings("serial")
public class States extends AbstractConfigurationObject {

    private State hover;

    /**
     * Constructs a States object with the given hover state.
     * 
     * @param hoverState
     */
    public States(State hoverState) {
        hover = hoverState;
    }

    /**
     * Constructs an empty States object
     */
    public States() {
    }

    /**
     * @see #setHover(State)
     */
    public State getHover() {
        return hover;
    }

    /**
     * Sets the hover state used for mouse hover events.
     * 
     * @param hover
     */
    public void setHover(State hover) {
        this.hover = hover;
    }
}
