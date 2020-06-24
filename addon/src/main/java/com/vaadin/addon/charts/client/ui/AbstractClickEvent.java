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

/** Abstract class with common attributes for click events */
public class AbstractClickEvent extends JavaScriptObject {
  protected AbstractClickEvent() {}

  public final native boolean isAltKey() /*-{
        return this.altKey;
    }-*/;

  public final native boolean isCtrlKey() /*-{
        return this.ctrlKey;
    }-*/;

  public final native boolean isShiftKey() /*-{
        return this.shiftKey;
    }-*/;

  public final native boolean isMetaKey() /*-{
        return this.metaKey;
    }-*/;

  public final native int getButton() /*-{
        return this.button;
    }-*/;

  public final native int getChartX() /*-{
        if (this.chartX) {
          return this.chartX;
        } else {
          return 0;
        }
    }-*/;

  public final native int getChartY() /*-{
        if (this.chartY) {
          return this.chartY;
        } else {
          return 0;
        }
    }-*/;
}
