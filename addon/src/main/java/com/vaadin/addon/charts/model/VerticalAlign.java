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

/** Alignment of the title relative to the axis values and more generically vertical alignment. */
public enum VerticalAlign implements ChartEnum {
  BOTTOM("bottom"),
  LOW("low"),
  MIDDLE("middle"),
  HIGH("high"),
  TOP("top");

  private final String align;

  private VerticalAlign(String align) {
    this.align = align;
  }

  @Override
  public String toString() {
    return align;
  }
}
