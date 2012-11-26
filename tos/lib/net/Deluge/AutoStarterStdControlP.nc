module AutoStarterStdControlP
{
    uses 
    {
        interface Boot;
        interface StdControl;
    }
}

implementation
{
    event void Boot.booted()
    {
        call StdControl.start();
    }
}
