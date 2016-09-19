package com.vaadin.v7.addon.charts;

import java.io.Serializable;

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

/**
 * Listener interface for click events on the chart's area
 */
public interface ChartClickListener extends Serializable {

    /**
     * Called when the user clicks somewhere on the chart.
     * 
     * @param event
     *            the {@link ChartClickEvent} containing information on the
     *            click.
     */
    public void onClick(ChartClickEvent event);

}
