package com.vaadin.addon.charts.model;

import com.vaadin.addon.charts.model.style.Color;

public class DrillUpButtonThemeState extends AbstractConfigurationObject {
  private Color fill;
  private Color stroke;

  public Color getFill() {
    return fill;
  }

  public void setFill(Color fill) {
    this.fill = fill;
  }

  public Color getStroke() {
    return stroke;
  }

  public void setStroke(Color stroke) {
    this.stroke = stroke;
  }
}
