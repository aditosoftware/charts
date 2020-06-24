package com.vaadin.addon.charts.model.junittests;

import com.vaadin.addon.charts.model.AbstractSeries;
import org.junit.Assert;
import org.junit.Test;

public class SeriesTest {

  @Test
  public void seriesVisibility_defaultVisibility_trueByDefault() {
    @SuppressWarnings("serial")
    AbstractSeries dataSeries = new AbstractSeries() {};

    Assert.assertTrue(dataSeries.isVisible());
  }
}
