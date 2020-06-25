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

public class ChartDrilldownEvent extends JavaScriptObject {
  protected ChartDrilldownEvent() {}

  public final native boolean isCategory() /*-{
      return this.points && this.points.length > 1;
  }-*/;

  public final native boolean hasDrilldownSeries() /*-{
      return this.seriesOptions;
  }-*/;

  public final native HighchartPoint getPoint() /*-{
      return this.point;
  }-*/;

  public final native HighchartPoint[] getPoints()/*-{
      return this.points;
  }-*/ ;

  public final native int getCategory()/*-{
    return this.category;
  }-*/;
}
