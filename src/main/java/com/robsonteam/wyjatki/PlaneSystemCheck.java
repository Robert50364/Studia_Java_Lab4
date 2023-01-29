package com.robsonteam.wyjatki;

public class PlaneSystemCheck
{
    private boolean energyStatus = false;
    private boolean ciagStatus = false;
    private boolean wirnikiStatus = false;
    private boolean engineWorkStatus = false;

    public void setEnergyStatus(boolean val)
    {
        energyStatus = val;
    }

    public boolean getEnergyStatus()
    {
        return energyStatus;
    }
    public void setCiagStatus(boolean val)
    {
        ciagStatus = val;
    }

    public boolean getCiagStatus()
    {
        return ciagStatus;
    }

    public void setWirnikiStatus(boolean val)
    {
        wirnikiStatus = val;
    }

    public boolean getWirnikiStatus()
    {
        return wirnikiStatus;
    }

    public void setEngineWorkStatus(boolean val)
    {
        engineWorkStatus = val;
    }

    public boolean getEngineWrokStatus()
    {
        return engineWorkStatus;
    }

    public void systemModuleCheck(int moduleID) throws CoreSystemMissException
    {
        switch (moduleID)
        {
            case 0:
                if(getEnergyStatus() && getCiagStatus() && getWirnikiStatus())
                {
                    setEngineWorkStatus(true);
                }
                break;
            case 1:
                if(!getEnergyStatus())
                {
                    throw new CoreSystemMissException("Brak prądu");
                }
                break;
            case 2:
                if(!getCiagStatus())
                {
                    throw new CiagMissExcepiton("Brak ciągu");
                }
            case 3:
                if(!getWirnikiStatus())
                {
                    throw new WirnikiMissException("Wirniki wyłączone");
                }
        }
    }
}
