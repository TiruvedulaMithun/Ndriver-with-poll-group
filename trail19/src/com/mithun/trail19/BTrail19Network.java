/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

package com.mithun.trail19;

import java.util.List;
import java.util.ArrayList;

import javax.baja.naming.BOrd;
import javax.baja.ndriver.BNNetwork;
import javax.baja.ndriver.comm.*;
import javax.baja.ndriver.comm.http.*;
import javax.baja.ndriver.datatypes.*;
import javax.baja.ndriver.discover.*;
import javax.baja.ndriver.poll.*;
import javax.baja.nre.annotations.NiagaraAction;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.security.dashboard.*;
import javax.baja.sys.*;
import javax.baja.util.Lexicon;

import com.mithun.trail19.comm.Trail19Listener;
import com.mithun.trail19.comm.BTrail19SerialCommConfig;
import com.mithun.trail19.comm.BTrail19TcpCommConfig;

/**
 * BTrail19Network models a network of devices
 *
 * @author mithun on 27 May 2025
 */
@NiagaraType
@NiagaraProperty(
  name = "httpConfig",
  type = "BHttpCommConfig",
  defaultValue = "new BHttpCommConfig()"
)
@NiagaraProperty(
  name = "tcpConfig",
  type = "BTrail19TcpCommConfig",
  defaultValue = "new BTrail19TcpCommConfig()"
)
@NiagaraProperty(
  name = "udpConfig",
  type = "BUdpCommConfig",
  defaultValue = "new BUdpCommConfig()"
)
@NiagaraProperty(
  name = "serialConfig",
  type = "BTrail19SerialCommConfig",
  defaultValue = "new BTrail19SerialCommConfig()"
)
public class BTrail19Network
  extends BNNetwork
  implements BISecurityDashboardProviderAgent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.mithun.trail19.BTrail19Network(985222611)1.0$ @*/
/* Generated Tue May 27 15:03:53 EDT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "httpConfig"

  /**
   * Slot for the {@code httpConfig} property.
   * @see #getHttpConfig
   * @see #setHttpConfig
   */
  public static final Property httpConfig = newProperty(0, new BHttpCommConfig(), null);

  /**
   * Get the {@code httpConfig} property.
   * @see #httpConfig
   */
  public BHttpCommConfig getHttpConfig() { return (BHttpCommConfig)get(httpConfig); }

  /**
   * Set the {@code httpConfig} property.
   * @see #httpConfig
   */
  public void setHttpConfig(BHttpCommConfig v) { set(httpConfig, v, null); }

  //endregion Property "httpConfig"

  //region Property "tcpConfig"

  /**
   * Slot for the {@code tcpConfig} property.
   * @see #getTcpConfig
   * @see #setTcpConfig
   */
  public static final Property tcpConfig = newProperty(0, new BTrail19TcpCommConfig(), null);

  /**
   * Get the {@code tcpConfig} property.
   * @see #tcpConfig
   */
  public BTrail19TcpCommConfig getTcpConfig() { return (BTrail19TcpCommConfig)get(tcpConfig); }

  /**
   * Set the {@code tcpConfig} property.
   * @see #tcpConfig
   */
  public void setTcpConfig(BTrail19TcpCommConfig v) { set(tcpConfig, v, null); }

  //endregion Property "tcpConfig"

  //region Property "udpConfig"

  /**
   * Slot for the {@code udpConfig} property.
   * @see #getUdpConfig
   * @see #setUdpConfig
   */
  public static final Property udpConfig = newProperty(0, new BUdpCommConfig(), null);

  /**
   * Get the {@code udpConfig} property.
   * @see #udpConfig
   */
  public BUdpCommConfig getUdpConfig() { return (BUdpCommConfig)get(udpConfig); }

  /**
   * Set the {@code udpConfig} property.
   * @see #udpConfig
   */
  public void setUdpConfig(BUdpCommConfig v) { set(udpConfig, v, null); }

  //endregion Property "udpConfig"

  //region Property "serialConfig"

  /**
   * Slot for the {@code serialConfig} property.
   * @see #getSerialConfig
   * @see #setSerialConfig
   */
  public static final Property serialConfig = newProperty(0, new BTrail19SerialCommConfig(), null);

  /**
   * Get the {@code serialConfig} property.
   * @see #serialConfig
   */
  public BTrail19SerialCommConfig getSerialConfig() { return (BTrail19SerialCommConfig)get(serialConfig); }

  /**
   * Set the {@code serialConfig} property.
   * @see #serialConfig
   */
  public void setSerialConfig(BTrail19SerialCommConfig v) { set(serialConfig, v, null); }

  //endregion Property "serialConfig"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrail19Network.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public void started()
    throws Exception
  {
    super.started();
    getHttpConfig().setDefaultListener(new Trail19Listener(getHttpConfig()));
    getTcpConfig().setDefaultListener(new Trail19Listener(getTcpConfig()));
    getUdpConfig().setDefaultListener(new Trail19Listener(getUdpConfig()));
    getSerialConfig().setDefaultListener(new Trail19Listener(getSerialConfig()));
  }

  /**
   * Specify name for network resources.
   */
  public String getNetworkName()
  {
    return "Trail19Network";
  }

  /**
   * return device folder type
   */
  @Override
  public Type getDeviceFolderType()
  {
    return BTrail19DeviceFolder.TYPE;
  }

  /**
   * return device type
   */
  @Override
  public Type getDeviceType()
  {
    return BTrail19Device.TYPE;
  }

  /**
   * return boolean if poll messages should be grouped
   */
  public boolean getShouldGroupPoll()
  {
    return true;
  }

  /* TODO - Add license check if needed
  @Override
  public final Feature getLicenseFeature()
  {
    return Sys.getLicenseManager().getFeature("?? vendor", "?? feature");
  }
  */

  @Override
  public void changed(Property p, Context cx)
  {
    super.changed(p, cx);
    if (!isRunning())
    {
      return;
    }

    if (p == status)
    {
      // Give any comms opportunity to respond to status changes
      getHttpConfig().statusUpdate();
      getTcpConfig().statusUpdate();
      getUdpConfig().statusUpdate();
      getSerialConfig().statusUpdate();
    }
  }

////////////////////////////////////////////////////////////////
// Security Dashboard
////////////////////////////////////////////////////////////////

  /**
   * Returns the header for the security dashboard card.
   *
   * @param cx user context
   */
  @Override
  public LexiconFormatInfo getSecurityDashboardSectionHeader(Context cx)
  {
    return LexiconFormatInfo.make(TYPE, "BTrail19Network.securityDashboard.title", BString.make("BTrail19Network.securityDashboard"), BString.make(this.getDisplayName(cx)));
  }

  /**
   * Returns the BOrd to link to when the user clicks on the security dashboard card.
   */
  @Override
  public BOrd getSecurityDashboardSectionHyperlinkOrd()
  {
    return getNavOrd().relativizeToSession();
  }

  /**
   * Returns the version of the security dashboard items.
   */
  @Override
  public int getSecurityDashboardItemsVersion()
  {
    // TODO - Update this version when the security dashboard items change.
    return SECURITY_DASHBOARD_ITEMS_VERSION;
  }

  /**
   * Returns the list of security dashboard items.
   * Here you can add any security issues with the driver that require user attention.
   * Items can be of three types: Info, Warning, and Alert.
   *
   * @param cx user context
   */
  @Override
  public List<SecurityDashboardItem> getSecurityDashboardItems(Context cx)
  {
    List<SecurityDashboardItem> items = new ArrayList<>();
    // TODO - add device level security items to the dashboard
    // Info item to show non critical security status
    /* items.add(SecurityDashboardItem.makeInfo(
     TYPE,
     "BTrail19Network.securityDashboard.info",
     "BTrail19Network.securityDashboard.info.description"
     )); */

    // Warning item to show critical security status
    /*
     if ("Warrants a Warning".equals(deviceState))
     {
     items.add(SecurityDashboardItem.makeWarning(
     TYPE,
     "BTrail19Network.securityDashboard.warningType1.title",
     "BTrail19Network.securityDashboard.warningType1.description"
     ));
     }
     else
     {
     items.add(SecurityDashboardItem.makeOk(
     TYPE,
     "BTrail19Network.securityDashboard.warningType1.title",
     "BTrail19Network.securityDashboard.warningType1.description"
     ));
     }
     */

    // Alert item to show critical security status
    /*
     if ("Alert condition".equals(deviceState))
     {
     items.add(SecurityDashboardItem.makeAlert(
     TYPE,
     "BTrail19Network.securityDashboard.alertType1.title",
     "BTrail19Network.securityDashboard.alertType1.description"
     ));
     }
     else
     {
     items.add(SecurityDashboardItem.makeOk(
     TYPE,
     "BTrail19Network.securityDashboard.alertType1.title",
     "BTrail19Network.securityDashboard.alertType1.description"
     ));
     }
     */

    return items;
  }

////////////////////////////////////////////////////////////////
// Utilities
////////////////////////////////////////////////////////////////

  /**
   * Access the http comm stack
   */
  public HttpComm hcomm()
  {
    return (HttpComm) getHttpConfig().comm();
  }

  /**
   * Access the tcp comm stack
   */
  public NComm tcomm()
  {
    return (NComm) getTcpConfig().comm();
  }

  /**
   * Access the udp comm stack
   */
  public NComm ucomm()
  {
    return (NComm) getUdpConfig().comm();
  }

  /**
   * Access the serial comm stack
   */
  public NComm scomm()
  {
    return (NComm) getSerialConfig().comm();
  }

  private static final int SECURITY_DASHBOARD_ITEMS_VERSION = 1;
  public static Lexicon LEX = Lexicon.make(BTrail19Network.class);
}
