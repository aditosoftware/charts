package com.vaadin.addon.charts.examples.themes;

import com.vaadin.addon.charts.ChartOptions;
import com.vaadin.addon.charts.examples.columnandbar.BarWithNegativeStack;
import com.vaadin.addon.charts.themes.SkiesTheme;
import com.vaadin.ui.Component;

@SuppressWarnings("serial")
public class SkiesThemedBarChart extends BarWithNegativeStack {

  @Override
  public String getDescription() {
    return "Skies themed: " + super.getDescription();
  }

  @Override
  protected Component getChart() {
    ChartOptions.get().setTheme(new SkiesTheme());
    return super.getChart();
  }
}
