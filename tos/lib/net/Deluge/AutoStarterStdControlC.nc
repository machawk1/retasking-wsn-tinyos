configuration AutoStarterStdControlC
{
    uses interface StdControl;
}

implementation
{
    components MainC, AutoStarterStdControlP;

    StdControl = AutoStarterStdControlP;
    AutoStarterStdControlP.Boot -> MainC;
}
