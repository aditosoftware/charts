package com.vaadin.addon.charts.client.ui;

/*-
 * #%L
 * Vaadin Charts Addon
 * %%
 * Copyright (C) 2012 - 2019 Vaadin Ltd
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

import com.google.gwt.core.client.JavaScriptObject;

public class PointEvent extends JavaScriptObject {

  protected PointEvent() {}

  public final native String getCategory() /*-{
        return "" + this.target.category;
    }-*/;

  public final native String getName() /*-{
        return this.target.name;
    }-*/;

  public final native String getId() /*-{
        return this.target.id;
    }-*/;

  public final native HighchartPoint getPoint() /*-{
        return this.target;
    }-*/;

  public final native HighchartAxis getXAxis() /*-{
        return this.target.series.xAxis;
    }-*/;

  public final native HighchartAxis getYAxis() /*-{
        return this.target.series.yAxis;
    }-*/;
}
