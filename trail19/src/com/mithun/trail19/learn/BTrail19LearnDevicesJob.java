/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

package com.mithun.trail19.learn;

import java.util.logging.Level;

import javax.baja.job.BSimpleJob;
import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.*;
import javax.baja.util.BFolder;

import com.mithun.trail19.BTrail19Network;

/**
 * BTrail19LearnDevicesJob - This job is used by the access device manager to discover connected
 * access devices.
 *
 * @author mithun on 27 May 2025
 */
@NiagaraType
@NiagaraProperty(
  name = "learnedDevices",
  type = "BFolder",
  defaultValue = "new BFolder()",
  flags = Flags.HIDDEN | Flags.READONLY | Flags.TRANSIENT
)
public class BTrail19LearnDevicesJob
  extends BSimpleJob
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.mithun.trail19.learn.BTrail19LearnDevicesJob(3804438489)1.0$ @*/
/* Generated Tue May 27 15:03:53 EDT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Property "learnedDevices"

  /**
   * Slot for the {@code learnedDevices} property.
   * @see #getLearnedDevices
   * @see #setLearnedDevices
   */
  public static final Property learnedDevices = newProperty(Flags.HIDDEN | Flags.READONLY | Flags.TRANSIENT, new BFolder(), null);

  /**
   * Get the {@code learnedDevices} property.
   * @see #learnedDevices
   */
  public BFolder getLearnedDevices() { return (BFolder)get(learnedDevices); }

  /**
   * Set the {@code learnedDevices} property.
   * @see #learnedDevices
   */
  public void setLearnedDevices(BFolder v) { set(learnedDevices, v, null); }

  //endregion Property "learnedDevices"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrail19LearnDevicesJob.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
  /**
   * Constructor - BTrail19LearnDevicesJob
   */
  public BTrail19LearnDevicesJob()
  {
    this(null);
  }

  /**
   * Constructor - BTrail19LearnDevicesJob
   */
  public BTrail19LearnDevicesJob(BTrail19Network net)
  {
    super();
    this.network = net;
  }

  // modify this method as needed to add device to learned devices
  void addLearnedDevice(String address)
  {
    String learnName = "device" + address;
    if (getLearnedDevices().get(learnName) == null) // If a learn entry does not yet exist for this point
    {
      getLearnedDevices().add(learnName, new BTrail19LearnDeviceEntry(address));
      logMessage("found device " + learnName);
    }
  }

  // modify this method to remove device to learned devices
  void removeLearnedDevice(int address)
  {
    String learnName = "device" + address;
    if (getLearnedDevices().get(learnName) != null) // If a learn entry exists for this point
    {
      getLearnedDevices().remove(learnName);        // Then this removes it.
    }
  }

  /* (non-Javadoc)
   * @see javax.baja.job.BSimpleJob#run(javax.baja.sys.Context)
   */
  public void run(Context cx)
    throws Exception
  {
    logMessage("starting");
    try
    {
      /* TO DO
      *  add code here to send what ever messages needed to the subsystem to determine what
      *  devices are connected to the network.
      *  You will need to modify the BTrail19LearnDeviceEntry to match the key data items to
      *  identify this device.
      *  You will need to modify addLearnedDevice to create and add an instance of
      *  BTrail19LearnDeviceEntry.

      *  Sample code
      for( int address = 0; address < MAX_ADDRESS; address++)
      {
        YourDiscoveryMessage message = new YourDiscoveryMessage(address);
        YourDiscoveryMessageResponse response;
        response = network.sendSync(message);
        if(response != null)
        {
          addLearnedDevice(address);
        }
      }
      */
    }
    catch (Exception e)
    {
    }
  }


  final BTrail19Network network;

  private void logMessage(String message)
  {
    log().message(message);

    if (network != null)
    {
      network.getLogger().log(Level.FINE, "Learn Access Devices Job:" + message);
    }
  }
}
