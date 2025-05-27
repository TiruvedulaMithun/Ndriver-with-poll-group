/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

package com.mithun.trail19.point;

import javax.baja.driver.point.BReadWriteMode;
import javax.baja.ndriver.point.BNProxyExt;
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
/* Generated Tue May 27 14:40:23 EDT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

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
    return (BTrail19Device) ((BComplex) this).getAncestor(BTrail19Device.TYPE);
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
  public void readSubscribed(Context cx)
    throws Exception
  {
    // TODO
  }

  public void readUnsubscribed(Context cx)
    throws Exception
  {
     // TODO
  }

  public boolean write(Context cx)
    throws Exception
  {
    // TODO
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
   * Return the read/write mode of this proxy.
   */
  public BReadWriteMode getMode()
  {
    // TODO
    return BReadWriteMode.readonly;
  }

  public boolean isBoolean()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusBoolean;
  }

  public boolean isNumeric()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusNumeric;
  }

  public boolean isString()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusString;
  }

  public boolean isEnum()
  {
    return getParentPoint().getOutStatusValue() instanceof BStatusEnum;
  }
}
