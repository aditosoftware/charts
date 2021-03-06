package com.vaadin.addon.charts.model;

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

import javax.annotation.Generated;
/**
 * Provides the option to draw a frame around the charts by defining a bottom, front and back panel.
 */
@Generated(
    value = "This class is generated and shouldn't be modified",
    comments =
        "Incorrect and missing API should be reported to https://github.com/vaadin/charts/issues/new")
public class Frame extends AbstractConfigurationObject {

  private Back back;
  private Bottom bottom;
  private Side side;

  public Frame() {}

  /** @see #setBack(Back) */
  public Back getBack() {
    if (back == null) {
      back = new Back();
    }
    return back;
  }

  /** Defines the back panel of the frame around 3D charts. */
  public void setBack(Back back) {
    this.back = back;
  }

  /** @see #setBottom(Bottom) */
  public Bottom getBottom() {
    if (bottom == null) {
      bottom = new Bottom();
    }
    return bottom;
  }

  /** The bottom of the frame around a 3D chart. */
  public void setBottom(Bottom bottom) {
    this.bottom = bottom;
  }

  /** @see #setSide(Side) */
  public Side getSide() {
    if (side == null) {
      side = new Side();
    }
    return side;
  }

  /** The side for the frame around a 3D chart. */
  public void setSide(Side side) {
    this.side = side;
  }
}
