package com.vaadin.addon.charts.examples.threed;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.examples.AbstractVaadinChartExample;
import com.vaadin.addon.charts.examples.SkipFromDemo;
import com.vaadin.addon.charts.model.*;
import com.vaadin.addon.charts.model.style.SolidColor;
import com.vaadin.ui.Component;

import java.util.Random;

@SkipFromDemo
public class ThreeDAxisConfiguration extends AbstractVaadinChartExample {

  @Override
  public String getDescription() {
    return "3D Scatter";
  }

  @Override
  protected Component getChart() {
    return createScatterChart();
  }

  private Chart createScatterChart() {
    final Chart scatterChart = new Chart(ChartType.SCATTER);
    scatterChart.setWidth("450px");
    scatterChart.setId("chart");
    scatterChart.getConfiguration().disableCredits();
    scatterChart.getConfiguration().setTitle("Points of a sphere");
    PlotOptionsScatter scatterOptions = new PlotOptionsScatter();
    scatterOptions.setAnimation(false);
    scatterOptions.setPointStart(1);

    DataSeries higherX = new DataSeries();
    higherX.setName("Higher X");
    DataSeries higherY = new DataSeries();
    higherY.setName("Higher Y");
    DataSeries higherZ = new DataSeries();
    higherZ.setName("Higher Z");

    fillSeries(higherX, higherY, higherZ);

    scatterChart.getConfiguration().addSeries(higherX);
    scatterChart.getConfiguration().addSeries(higherY);
    scatterChart.getConfiguration().addSeries(higherZ);

    XAxis x = scatterChart.getConfiguration().getxAxis();
    x.setGridLineWidth(1);
    x.setExtremes(-3, 3);

    if (getCurrentTheme().getxAxis().getGridLineColor() != null) {
      x.setGridLineColor(getCurrentTheme().getxAxis().getGridLineColor());
    }

    setAxisConfiguration(scatterChart.getConfiguration().getxAxis());
    setAxisConfiguration(scatterChart.getConfiguration().getyAxis());
    setAxisConfiguration(scatterChart.getConfiguration().getzAxis());

    Options3d options3d = new Options3d();
    options3d.setEnabled(true);
    options3d.setAlpha(10);
    options3d.setBeta(60);
    options3d.setDepth(200);
    options3d.setViewDistance(40);

    Frame frame = new Frame();
    Bottom bottom = new Bottom();
    bottom.setSize(1);
    frame.setBottom(bottom);
    options3d.setFrame(frame);
    scatterChart.getConfiguration().getChart().setOptions3d(options3d);

    scatterChart.drawChart();
    return scatterChart;
  }

  private void setAxisConfiguration(Axis axis) {
    axis.setExtremes(-1, 1);
    axis.setTickAmount(10);
    axis.setGridLineColor(SolidColor.BROWN);
    axis.setGridLineWidth(1);
    axis.setGridLineDashStyle(DashStyle.DASH);
  }

  private void fillSeries(DataSeries higherX, DataSeries higherY, DataSeries higherZ) {
    Random random = new Random(7);
    for (int i = 0; i < 300; i++) {
      double lng = random.nextDouble() * 2 * Math.PI;
      double lat = random.nextDouble() * Math.PI - Math.PI / 2;
      double x = Math.cos(lat) * Math.sin(lng);
      double y = Math.sin(lat);
      double z = Math.cos(lng) * Math.cos(lat);

      DataSeriesItem3d point = new DataSeriesItem3d(x, y, z);
      if (x > y && x > z) {
        higherX.add(point);
      } else if (y > x && y > z) {
        higherY.add(point);
      } else {
        higherZ.add(point);
      }
    }
  }
}
