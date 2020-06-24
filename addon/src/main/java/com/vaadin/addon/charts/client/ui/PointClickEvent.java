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

public class PointClickEvent extends AbstractClickEvent {
  protected PointClickEvent() {}

  public final native double getX() /*-{
        if(this.point.x){
          return this.point.x;
        } else{
          return 0;
        }
    }-*/;

  public final native double getY() /*-{
        if(this.point.y){
          return this.point.y;
        } else{
          return 0;
        }
    }-*/;

  public final native String getCategory() /*-{
        return "" + this.point.category;
    }-*/;

  public final native String getName() /*-{
        return this.point.name;
    }-*/;

  public final native String getId() /*-{
        return this.point.id;
    }-*/;

  public final native HighchartPoint getPoint() /*-{
        return this.point;
    }-*/;

  public final native HighchartAxis getXAxis() /*-{
    	return this.point.series.xAxis;
    }-*/;

  public final native HighchartAxis getYAxis() /*-{
    	return this.point.series.yAxis;
    }-*/;
}
