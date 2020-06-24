package com.vaadin.addon.charts.examples.columnandbar;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.examples.SkipFromDemo;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;

@SkipFromDemo
public class ChartWithLazyDrilldownInTabSheet extends AbstractVaadinChartExample {

  /**
   * Test UI for #483.
   *
   * <p>To reproduce issue:
   *
   * <ul>
   *   <li>Click on IE
   *   <li>Change to second tab
   *   <li>Change to first tab
   *   <li>Click on opera
   * </ul>
   */
  @Override
  protected Component getChart() {
    TabSheet tabs = new TabSheet();
    tabs.setSizeFull();
    Chart chart = (Chart) new ColumnWithNativeLazyDrilldown().getChart();
    tabs.addTab(chart, "First tab with chart");
    Label label = new Label("second tab content");
    tabs.addTab(label, "Other tab");
    return tabs;
  }
}
