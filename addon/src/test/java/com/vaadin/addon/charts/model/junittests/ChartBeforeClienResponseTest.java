package com.vaadin.addon.charts.model.junittests;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/** Tests for the JSON serialization in {@link Configuration} */
@RunWith(Parameterized.class)
public class ChartBeforeClienResponseTest {

  @Parameterized.Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {ChartType.PIE},
          {ChartType.GAUGE},
          {ChartType.SOLIDGAUGE},
          {ChartType.FUNNEL},
          {ChartType.PYRAMID}
        });
  }

  @Parameterized.Parameter public ChartType timelineNotSupported;

  @Test(expected = RuntimeException.class)
  public void beforeClientResponse_timelineIsSetButNotSupported_throwException()
      throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
    TestChart chart = new TestChart(timelineNotSupported);
    chart.setTimeline(true);

    chart.beforeClientResponse(true);
  }

  @Test
  public void beforeClientResponse_timelineIsNotSetAndItIsNotSupported_chartIsSerialized()
      throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
    TestChart chart = new TestChart(timelineNotSupported);

    chart.beforeClientResponse(true);

    assertNotNull(chart.getSerializedConfiguration());
    assertNotEquals("", chart.getSerializedConfiguration());
  }

  @Test
  public void beforeClientResponse_timelineIsSetAndSupported_chartIsSerialized()
      throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
    TestChart chart = new TestChart(ChartType.LINE);
    chart.setTimeline(true);

    chart.beforeClientResponse(true);

    assertNotNull(chart.getSerializedConfiguration());
    assertNotEquals("", chart.getSerializedConfiguration());
  }

  @Test(expected = RuntimeException.class)
  public void
      beforeClientResponse_lineChartWithTimelineButFirstSeriesDoesNotSupportIt_throwException()
          throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
    TestChart chart = new TestChart(ChartType.LINE);
    chart.setTimeline(true);
    ListSeries series = new ListSeries();
    series.setPlotOptions(new TimelineNotSupportedPlotOptions(timelineNotSupported));
    chart.getConfiguration().addSeries(series);

    chart.beforeClientResponse(true);
  }

  @Test
  public void
      beforeClientResponse_chartWithTimelineAndNoSupportForItButLineAsFirstSeries_chartIsSerialized()
          throws IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
    TestChart chart = new TestChart(timelineNotSupported);
    chart.setTimeline(true);
    ListSeries series = new ListSeries();
    series.setPlotOptions(new PlotOptionsLine());
    chart.getConfiguration().addSeries(series);

    chart.beforeClientResponse(true);

    assertNotNull(chart.getSerializedConfiguration());
    assertNotEquals("", chart.getSerializedConfiguration());
  }

  // TestChart adds functionality to verify that configuration has
  // been serialized
  private class TestChart extends Chart {

    private boolean serializedConfiguration;

    public TestChart(ChartType type) {
      super(type);
    }

    public String getSerializedConfiguration() {
      return getState().confState;
    }
  }

  private static class TimelineNotSupportedPlotOptions extends AbstractPlotOptions {

    private ChartType type;

    public TimelineNotSupportedPlotOptions(ChartType type) {
      this.type = type;
    }

    @Override
    public ChartType getChartType() {
      return type;
    }
  }
}
