package com.vaadin.addon.util.junittests;

import com.vaadin.addon.charts.util.Util;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.Assert.assertEquals;

/** Tests for Instant to Highcharts TS conversion. */
public class SerializationTest {

  @Test
  public void dateUtils_toAndFromHighchartsTS_equalValueObtained() {
    Instant instant = LocalDateTime.now().toInstant(ZoneOffset.UTC);
    long highchartsTS = Util.toHighchartsTS(instant);
    Instant serverInstant = Util.toServerInstant(highchartsTS);
    assertEquals(instant.toEpochMilli(), serverInstant.toEpochMilli());
  }
}
