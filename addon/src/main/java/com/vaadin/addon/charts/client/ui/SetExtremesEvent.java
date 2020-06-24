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

public class SetExtremesEvent extends JavaScriptObject {

  protected SetExtremesEvent() {}

  public final native HighchartAxis getAxis() /*-{
         return this.target;
    }-*/;

  public final native double getMin() /*-{
        if (this.min) {
          return this.min;
        } else {
          return 0;
        }
    }-*/;

  public final native double getMax() /*-{
        if (this.max) {
          return this.max;
        } else {
          return 0;
        }
    }-*/;
}
