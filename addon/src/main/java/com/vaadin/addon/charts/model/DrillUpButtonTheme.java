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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vaadin.addon.charts.model.style.Color;

/** A collection of style attributes for the {@link DrillUpButton} */
public class DrillUpButtonTheme extends AbstractConfigurationObject {

  private Color fill;
  private Color stroke;
  private Number r;

  @JsonProperty("stroke-width")
  private Number strokeWidth;

  /**
   * @see #setFill(Color)
   * @return
   */
  public Color getFill() {
    return fill;
  }

  /**
   * SVG fill attribute for the button
   *
   * @param fill
   */
  public void setFill(Color fill) {
    this.fill = fill;
  }

  /**
   * @see #setStroke(Color)
   * @return
   */
  public Color getStroke() {
    return stroke;
  }

  /**
   * SVG stroke attribute for the button
   *
   * @param stroke
   */
  public void setStroke(Color stroke) {
    this.stroke = stroke;
  }

  /**
   * @see #setStrokeWidth(Number)
   * @return
   */
  public Number getStrokeWidth() {
    return strokeWidth;
  }

  /**
   * SVG stroke-width attribute
   *
   * @param strokeWidth
   */
  public void setStrokeWidth(Number strokeWidth) {
    this.strokeWidth = strokeWidth;
  }

  /**
   * @see #setR(Number)
   * @return
   */
  public Number getR() {
    return r;
  }

  /**
   * SVG border radius attribute for the button
   *
   * @param r
   */
  public void setR(Number r) {
    this.r = r;
  }
}
