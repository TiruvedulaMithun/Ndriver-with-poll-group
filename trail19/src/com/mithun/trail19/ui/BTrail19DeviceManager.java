/*
 * Copyright 2025 mithun. All Rights Reserved.
 */

package com.mithun.trail19.ui;

import java.util.ArrayList;

import javax.baja.driver.*;
import javax.baja.driver.ui.device.DeviceExtsColumn;
import javax.baja.gx.*;
import javax.baja.job.*;
import javax.baja.ndriver.ui.device.*;
import javax.baja.nre.annotations.*;
import javax.baja.sys.*;
import javax.baja.ui.*;
import javax.baja.util.*;
import javax.baja.workbench.mgr.*;
import javax.baja.workbench.mgr.folder.*;

import com.mithun.trail19.*;
import com.mithun.trail19.learn.*;

/**
 * BTrail19DeviceManager provides the user interface to manage
 * trail19 devices on a single network.
 *
 * @author mithun on 27 May 2025
 */
@NiagaraType(
    agent = @AgentOn(types = { "trail19:Trail19DeviceExt", "trail19:Trail19DeviceFolder" })
)
public class BTrail19DeviceManager
  extends BNDeviceManager
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.mithun.trail19.ui.BTrail19DeviceManager(1286093609)1.0$ @*/
/* Generated Tue May 27 15:03:53 EDT 2025 by Slot-o-Matic (c) Tridium, Inc. 2012-2025 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BTrail19DeviceManager.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/
////////////////////////////////////////////////////////////////
// Constructor
////////////////////////////////////////////////////////////////

  public BTrail19DeviceManager()
  {
  }

  /**
   * Gets ancestor network object.
   */
  public BTrail19Network getNetwork()
  {
    BObject owner = getCurrentValue();
    if (owner instanceof BTrail19DeviceFolder)
    {
      return (BTrail19Network) ((BTrail19DeviceFolder) owner).getNetwork();
    }
    else if (owner instanceof BTrail19Network)
    {
      return (BTrail19Network) owner;
    }
    else
    {
      return null;
    }
  }

  public void doLoadValue(BObject obj, Context cx)
  {
    super.doLoadValue(obj,cx);
    // Sets the discovery data from the pan table entries
    updateLearnData();
  }

  /**
   * This method is called by the doLoadValue method and when the learn job completes.
   */
  void updateLearnData()
  {
    BTrail19LearnDevicesJob learnJob = (BTrail19LearnDevicesJob) getLearn().getJob();
    if (learnJob != null)
    {
      getLearn().updateRoots(learnJob.getLearnedDevices().getChildren(BTrail19LearnDeviceEntry.class));
    }
  }

  public BTrail19Device[] getSelectedDevices()
  {
    if (getModel() == null || getModel().getTable() == null)
    {
      return new BTrail19Device[0];
    }
    else
    {
      BComponent[] selection = getModel().getTable().getSelectedComponents();
      ArrayList<BTrail19Device> devicesList = new ArrayList<>();
      for (int i = 0; i < selection.length; i++)
      {
        if (selection[i].getType().is(BTrail19Device.TYPE))
        {
          devicesList.add((BTrail19Device)selection[i]);
        }
      }
      BTrail19Device[]devices = new BTrail19Device[devicesList.size()];
      devices = devicesList.toArray(devices);
      return devices;
    }
  }

////////////////////////////////////////////////////////////////
// Support
////////////////////////////////////////////////////////////////

  protected MgrModel makeModel()
  {
    return new Model(this);
  }

  protected MgrController makeController()
  {
    return new Controller(this);
  }

  protected MgrLearn makeLearn()
  {
    return new Learn(this);
  }

////////////////////////////////////////////////////////////////
// Model
////////////////////////////////////////////////////////////////

  class Model extends NDeviceModel
  {
    Model(BNDeviceManager manager)
    {
      super(manager);
    }

    protected MgrColumn[] makeColumns()
    {
      return cols;
    }
  }

/////////////////////////////////////////////////////////////
// Learn
//////////////////////////////////////////////////////////////

  /**
   * Override of base learn support object
   */
  class Learn extends MgrLearn
  {
    Learn(BNDeviceManager manager)
    {
      super(manager);
    }

    /**
     * This is method is called to initialize the
     * columns used for the discovery table.
     */
    protected MgrColumn[] makeColumns()
    {
      return new MgrColumn[]{
          //
          // TODO - add discovery column entries
          //
      };
    }

    public BImage getIcon(Object dis)
    {
      return stationIcon;
    }

    public MgrTypeInfo[] toTypes(Object discovery)
    {
      return MgrTypeInfo.makeArray(getNetwork().getDeviceType());
    }

    public void toRow(Object discovery, MgrEditRow row)
    {
      BTrail19LearnDeviceEntry learnEntry = (BTrail19LearnDeviceEntry) discovery;
      //
      // TODO - add code to make changes to row based on discovery object
      //
    }

    /**
     * Allows the core to ask us if a discovered item is equivalent
     * to a given pre-existing item.
     */
    public boolean isExisting(Object dis, BComponent comp)
    {
      BTrail19LearnDeviceEntry learnEntry = (BTrail19LearnDeviceEntry) dis;
      BTrail19Device d = (BTrail19Device) comp;

      //
      // TODO - add code to check if learnEntry is for specified device
      //

      return false;
    }

    /**
     * This callback is automatically invoked when the
     * current job set via {@code setJob()} completes.
     */
    public void jobComplete(BJob job)
    {
      super.jobComplete(job);
      if (job instanceof BTrail19LearnDevicesJob)
      {
        updateLearnData();
      }
    }
  }

////////////////////////////////////////////////////////////////
// Controller
////////////////////////////////////////////////////////////////

  class Controller extends NDeviceController
  {
    Controller(BNDeviceManager mgr)
    {
      super(mgr);
    }
  }

////////////////////////////////////////////////////////////////
// Attributes
////////////////////////////////////////////////////////////////

  static Lexicon lex = Lexicon.make(BTrail19DeviceManager.class);
  static BImage stationIcon = BImage.make("module://icons/x16/device.png");

  // base class columns
  MgrColumn colName         = new MgrColumn.Name();
  MgrColumn colType         = new MgrColumn.Type();
  MgrColumn colDeviceExts   = new DeviceExtsColumn(new BTrail19Device());
  MgrColumn colStatus       = new MgrColumn.Prop(BDevice.status);
  MgrColumn colEnabled      = new MgrColumn.Prop(BDevice.enabled, MgrColumn.EDITABLE | MgrColumn.UNSEEN);
  MgrColumn colHealth       = new MgrColumn.Prop(BDevice.health, 0);

  // Trail19Device specific columns
  // TODO - add custom columns definitions and include in cols[]

  MgrColumn[] cols =
  {
    colName, colType, colDeviceExts,
    colStatus, colEnabled, colHealth,
  };

}
