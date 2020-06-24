package com.vaadin.addon.charts.testbenchtests;

import com.vaadin.addon.charts.examples.pointclickevent.PointClickCoordinatesColumnChart;
import org.junit.Ignore;

@Ignore("Absolute coordinates affected by Theme change")
public class PointClickCoordinatesColumnChartTBTest extends AbstractPointClickCoordinatesTest {

  @Override
  protected String getTestViewName() {
    return PointClickCoordinatesColumnChart.class.getSimpleName();
  }
}
