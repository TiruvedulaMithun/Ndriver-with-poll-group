/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

package com.mithun.trail19.point;

import javax.baja.driver.point.BReadWriteMode;
import javax.baja.driver.util.BPollFrequency;
import javax.baja.ndriver.point.BNProxyExt;
import javax.baja.ndriver.poll.BINPollable;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatusBoolean;
import javax.baja.status.BStatusEnum;
import javax.baja.status.BStatusNumeric;
import javax.baja.status.BStatusString;
import javax.baja.sys.*;

import com.mithun.trail19.*;

/**
 * BTrail19ProxyExt
 *
 * @author mithun on 27 May 2025
 */
@NiagaraType
/*
Override ProxyExt default status to clear stale state if needed
@NiagaraProperty(
  name = "status",
  type = "BStatus",
  defaultValue = "BStatus.ok",
  flags = Flags.READONLY | Flags.TRANSIENT,
  override = true
)
*/
public class BTrail19ProxyExt
  extends BNProxyExt
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.mithun.trail19.point.BTrail19ProxyExt(2979906276)1.0$ @*/
/* Generated Tue May 27 15:03:53 EDT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrail19ProxyExt.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

////////////////////////////////////////////////////////////////
// Access
////////////////////////////////////////////////////////////////

  /**
   * Get the network cast to a BTrail19Network.
   */
  public final BTrail19Network getTrail19Network()
  {
    return (BTrail19Network) getNetwork();
  }

  /**
   * Get the device cast to a BTrail19Device.
   */
  public final BTrail19Device getBTrail19Device()
  {
    return (BTrail19Device) getAncestor(BTrail19Device.TYPE);
  }

  /**
   * Get the point device ext cast to a BTrail19PointDeviceExt.
   */
  public final BTrail19PointDeviceExt getTrail19PointDeviceExt()
  {
    return (BTrail19PointDeviceExt) getDeviceExt();
  }

////////////////////////////////////////////////////////////////
// ProxyExt
////////////////////////////////////////////////////////////////

  /**
   * Proxy extensions that belong to the same Poll Group should
   * return the equivalent poll group code from this method.
   * This allows the polling of those proxies to be coalesced
   * into a single poll.
   * <p>
   * In other words, if two proxy extensions are polled by one poll group
   * then the Objects returned by either of the proxy extension should
   * equal each other when passed to each other's .equals methods.
   */
  @Override
  public Object getPollGroupCode()
  {
    // TODO return the poll group code for this proxy extension
    return null;
  }

  @Override
  public boolean write(Context cx)
    throws Exception
  {
    // TODO write the point value. If performing any IO, it is recommended to use the (BTrail19Network) getNetwork()).postAsync(Runnable to perform the write) to not block the engine thread
    return false;
  }

  /**
   * Return the device type.
   */
  public Type getDeviceExtType()
  {
    return BTrail19PointDeviceExt.TYPE;
  }

  /**
   * Return the poll group type.
   */
  @Override
  public Type getPollGroupType()
  {
    return BTrail19PollGroup.TYPE;
  }

  /**
   * Return the read/write mode of this proxy.
   */
  public BReadWriteMode getMode()
  {
    // TODO determine the read/write mode based on the point.
    return BReadWriteMode.readonly;
  }
}
