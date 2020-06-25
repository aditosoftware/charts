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
import com.google.gwt.core.client.JsArray;

/** JS overlay for Chart chart. Needed for dynamic modifications, e.g. adding/removing points. */
public class HighchartJsOverlay extends JavaScriptObject {

  protected HighchartJsOverlay() {}

  /** @param doubleAttribute */
  public final native void addPoint(
      String pointJson, int seriesIndex, boolean redraw, boolean shift)
      /*-{
          var newPointData = $wnd.eval('('+pointJson+')');
          this.series[seriesIndex].addPoint(newPointData,redraw,shift);
      }-*/ ;

  public final native void removePoint(int pointIndex, int seriesIndex) /*-{
        this.series[seriesIndex].data[pointIndex].remove();
    }-*/;

  public final native void setSeriesEnabled(int index, boolean enabled) /*-{
        var ser = this.series[index];
        if(enabled) {
            ser.show();
        } else {
            ser.hide();
        }
    }-*/;

  public final native JsArray<HighchartSeries> getSeries() /*-{
        return this.series;
    }-*/;

  public final native JsArray<HighchartAxis> getxAxes() /*-{
         return this.xAxis;
    }-*/;

  public final native JsArray<HighchartAxis> getyAxes() /*-{
         return this.yAxis;
    }-*/;

  public final native JsArray<HighchartAxis> getzAxes() /*-{
         return this.zAxis;
    }-*/;

  public final native JsArray<HighchartAxis> getColorAxes() /*-{
         return this.colorAxis;
    }-*/;

  public final native void setAnimation(boolean animation) /*-{
        this.animation = animation;
    }-*/;

  public final native void setSize(
      int offsetWidth, int offsetHeight, boolean animate, boolean clearUserSize)
      /*-{
          this.setSize(offsetWidth,offsetHeight,animate);
          if(clearUserSize) {
              this.hasUserSize = null;
          }
      }-*/ ;

  public final native String getSubTitle() /*-{
        if(this.subtitle==null) {
            return "";
        }
        return this.subtitle.textStr;
    }-*/;

  public final native String getTitle() /*-{
        if(this.title==null) {
            return "";
        }
        return this.title.textStr;
    }-*/;

  public final native void setTitle(String title, String subtitle) /*-{
        this.setTitle(title,subtitle,true);
    }-*/;

  public final native void destroy() /*-{
        this.destroy();
    }-*/;

  public final native void addDrilldown(String series, int seriesIndex, int pointIndex) /*-{
    var newDrilldownData = $wnd.eval('('+series+')');
    var point = this.series[seriesIndex].data[pointIndex];
    console.log(this.series[seriesIndex].data)
    for (var i = 0; i < newDrilldownData.length;i++)
        this.addSingleSeriesAsDrilldown(point, newDrilldownData[i]);

    this.applyDrilldown();
    }-*/;

  public final native void updateSeries(int seriesIndex, String seriesJson) /*-{
        var seriesData = $wnd.eval('('+seriesJson+')');
        this.series[seriesIndex].setData(seriesData.data, true);
    }-*/;

  public final native void showLoading() /*-{
      this.showLoading();
    }-*/;

  public final native void hideLoading() /*-{
    this.hideLoading();
  }-*/;
}
