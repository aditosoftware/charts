package com.vaadin.addon.charts.examples.columnandbar;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.model.*;
import com.vaadin.ui.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColumnWithNativeLazyDrilldownMultiSeriesPerCategory
    extends AbstractVaadinChartExample {
  private Map<String, List<Series>> drillSeries;
  private Configuration conf;

  @Override
  public String getDescription() {
    return "Column chart with laxy loading drilldown by id";
  }

  @Override
  protected Component getChart() {
    final Chart chart = new Chart(ChartType.COLUMN);
    chart.setId("chart");

    conf = chart.getConfiguration();

    conf.setTitle("Browser market share, April, 2011");
    conf.setSubTitle("Click the columns to view versions. Click again to view brands.");
    conf.getLegend().setEnabled(false);

    XAxis x = new XAxis();
    x.setType(AxisType.CATEGORY);
    conf.addxAxis(x);

    YAxis y = new YAxis();
    y.setTitle("Total percent market share");
    conf.addyAxis(y);

    PlotOptionsColumn column = new PlotOptionsColumn();
    column.setCursor(Cursor.POINTER);
    column.setDataLabels(new DataLabels(true));
    column.getDataLabels().setFormatter("this.y +'%'");

    conf.setPlotOptions(column);

    Tooltip tooltip = new Tooltip();
    tooltip.setHeaderFormat("<span style=\"font-size:11px\">{series.name}</span><br>");
    tooltip.setPointFormat(
        "<span style=\"color:{point.color}\">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>");
    conf.setTooltip(tooltip);

    createSeries(1);
    createSeries(2);

    drillSeries = new HashMap<>();

    addDrillSeries(1, 1);
    addDrillSeries(1, 2);
    addDrillSeries(2, 1);
    addDrillSeries(2, 2);
    addDrillSeries(3, 1);
    addDrillSeries(3, 2);

    chart.setDrilldownCallback(event -> {
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return getPointDrilldown(event.getItem());
    });
    return chart;
  }

  private void createSeries(int index) {
    DataSeries series = new DataSeries();
    DataSeriesItem item = new DataSeriesItem("MSIE", 55.11 - index - index - index);
    item.setId("MSIE" + index);
    series.addItemWithDrilldown(item);

    item = new DataSeriesItem("Firefox", 21.63 - index);
    item.setId("Firefox" + index);
    series.addItemWithDrilldown(item);

    item = new DataSeriesItem("Chrome", 11.94 + index);
    item.setId("Chrome" + index);
    series.addItemWithDrilldown(item);

    item = new DataSeriesItem("Safari", 7.15 + index + index);
    item.setId("Safari" + index);
    series.addItemWithDrilldown(item);

    item = new DataSeriesItem("Opera", 2.14 + index);
    item.setId("Opera" + index);
    series.addItemWithDrilldown(item);

    conf.addSeries(series);
  }

  private void addDrillSeries(int index, int subIndex) {
    DataSeries drill = new DataSeries("MSIE versions" + index + subIndex);
    String[] categories = new String[] {"MSIE 6.0", "MSIE 7.0", "MSIE 8.0", "MSIE 9.0"};
    Number[] ys =
        new Number[] {10.85 + subIndex, 7.35 + subIndex, 33.06 + subIndex, 2.81 + subIndex};
    drill.setData(categories, ys);
    if (!drillSeries.containsKey("MSIE" + index))
      drillSeries.put("MSIE" + index, new ArrayList<>());
    drillSeries.get("MSIE" + index).add(drill);

    drill = new DataSeries("Firefox versions" + index + subIndex);
    categories =
        new String[] {"Firefox 2.0", "Firefox 3.0", "Firefox 3.5", "Firefox 3.6", "Firefox 4.0"};
    ys =
        new Number[] {
          0.20 + subIndex, 0.83 + subIndex, 1.58 + subIndex, 13.12 + subIndex, 5.43 + subIndex
        };
    drill.setData(categories, ys);
    if (!drillSeries.containsKey("Firefox" + index))
      drillSeries.put("Firefox" + index, new ArrayList<>());
    drillSeries.get("Firefox" + index).add(drill);

    drill = new DataSeries("Chrome versions" + index);
    categories =
        new String[] {
          "Chrome 5.0",
          "Chrome 6.0",
          "Chrome 7.0",
          "Chrome 8.0",
          "Chrome 9.0",
          "Chrome 10.0",
          "Chrome 11.0",
          "Chrome 12.0"
        };
    ys =
        new Number[] {
          0.12 + subIndex,
          0.19 + subIndex,
          0.12 + subIndex,
          0.36 + subIndex,
          0.32 + subIndex,
          9.91 + subIndex,
          0.50 + subIndex,
          0.22 + subIndex
        };
    drill.setData(categories, ys);
    if (!drillSeries.containsKey("Chrome" + index))
      drillSeries.put("Chrome" + index, new ArrayList<>());
    drillSeries.get("Chrome" + index).add(drill);

    drill = new DataSeries("Safari versions" + index);
    categories =
        new String[] {
          "Safari 5.0",
          "Safari 4.0",
          "Safari Win 5.0",
          "Safari 4.1",
          "Safari/Maxthon",
          "Safari 3.1",
          "Safari 4.1"
        };
    ys =
        new Number[] {
          4.55 + subIndex,
          1.42 + subIndex,
          0.23 + subIndex,
          0.21 + subIndex,
          0.20 + subIndex,
          0.19 + subIndex,
          0.14 + subIndex
        };
    drill.setData(categories, ys);
    if (!drillSeries.containsKey("Safari" + index))
      drillSeries.put("Safari" + index, new ArrayList<>());
    drillSeries.get("Safari" + index).add(drill);

    drill = new DataSeries("Opera versions" + index);
    categories = new String[] {"Opera 9.x", "Opera 10.x", "Opera 11.x"};
    ys = new Number[] {0.12 + subIndex, 0.37 + subIndex, 1.65 + subIndex};
    drill.setData(categories, ys);
    if (!drillSeries.containsKey("Opera" + index))
      drillSeries.put("Opera" + index, new ArrayList<>());
    drillSeries.get("Opera" + index).add(drill);
  }

  private List<Series> getPointDrilldown(DataSeriesItem item) {
    return drillSeries.get(item.getId());
  }
}
